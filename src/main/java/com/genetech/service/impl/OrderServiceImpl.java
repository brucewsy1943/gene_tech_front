package com.genetech.service.impl;

import com.genetech.bean.Goods;
import com.genetech.bean.Order;
import com.genetech.bean.OrderDetail;
import com.genetech.bean.OrderExample;
import com.genetech.bean.dto.*;
import com.genetech.dao.OrderMapper;
import com.genetech.service.*;
import com.genetech.utils.RedisUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2019/12/17.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AddressService addressService;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private GoodsService goodsService;

    ReentrantLock reentrantLock = new ReentrantLock();
    //---这个方法要加锁，为了保证订单编号的唯一递增
    @Transactional
    @Override
    synchronized public String addOrder(String cartKey,OrderDto orderDto,Integer userId,InvoiceDto invoiceDto) {
        //0、取出购物车
        List<ShoppingCartDto> shoppingList = RedisUtils.getList(cartKey,ShoppingCartDto.class);
        //假如购物车没货
        if (CollectionUtils.isEmpty(shoppingList)){
            return null;
        }

        //1、需要生成发票的时候
        if (invoiceDto.getIs_invoice_needed()!=null && 1==invoiceDto.getIs_invoice_needed()){
            //更新发票信息
            invoiceDto.setUser_id(userId);
            int invoiceId = invoiceService.updateInvoiceInOrderSubmit(userId,invoiceDto);
            orderDto.setInvoice_id(invoiceId);
        }

        //3、生成order
        //生成id和订单编号orderNumber

        String orderId = UUID.randomUUID().toString();
        String orderNumber = generateOrderNumber();

        orderDto.setId(orderId);
        orderDto.setOrder_number(orderNumber);
        orderDto.setUser_id(userId);
        //生成时间
        orderDto.setCreateTime();
        orderMapper.insert(orderDto);
        //封装插入order_detail
        //String id,
        // String order_id,
        // Integer goods_num,
        // BigDecimal money,
        // Integer goods_id,
        // BigDecimal discount,
        // Integer pay_type,
        // Integer order_status,
        // Long sumary,
        // String goods_name,
        // Integer product_id) {

        if (!CollectionUtils.isEmpty(shoppingList)){
            for (ShoppingCartDto shoppingCartDto : shoppingList) {
                String detailId = UUID.randomUUID().toString();
                OrderDetailDto ordetailDto = new OrderDetailDto(detailId,
                        orderId,
                        shoppingCartDto.getGoodsNum(),
                        shoppingCartDto.getPrice(),
                        shoppingCartDto.getGoodsId(),
                        null,//discount
                        null,//pay_type
                        0,//order_status
                        shoppingCartDto.getSumary(),//sumary
                        shoppingCartDto.getGoodsName(),
                        shoppingCartDto.getProductId());//
                orderDetailService.addOrderDetail(ordetailDto);
            }
        }
        return orderId;
    }

    @Override
    public OrderDto getOrderInfo(String orderId) throws InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        OrderDto orderDto = new OrderDto();
        ConvertUtils.register(new DateConverter(null), java.math.BigDecimal.class);
        org.apache.commons.beanutils.BeanUtils.copyProperties(orderDto,order);

        //订单详情
        List<OrderDetailDto> orderDetails = orderDetailService.getOrderDetaiListByOrder(orderDto.getId());

        for (int i = 0; i < orderDetails.size(); i++) {

            OrderDetailDto orderDetailDto = orderDetails.get(i);
            Goods goods = goodsService.getGoodsById(orderDetailDto.getGoods_id());
            orderDetailDto.setProductCode(goods.getProduct_code());
        }
        orderDto.setOrderDetails(orderDetails);

        //地址
        DeliveryAddressDto deliveryAddressDto = addressService.getDeliverAddressById(order.getAddress_id());
        orderDto.setDeliveryAddressDto(deliveryAddressDto);

        return orderDto;
    }

    @Override
    public PageInfo<OrderDto> getOrderPageListByUser(Integer userId, PageDto pageDto) {

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUser_idEqualTo(userId);

        PageHelper.startPage(pageDto.getPageNum(),pageDto.getPageSize());
        List<Order> orders = orderMapper.selectByExample(orderExample);

        //封装对应的OrderDetail
        List<OrderDto> resultList = new ArrayList<>();
        for (Order order:orders) {
            OrderDto orderDto = new OrderDto();
            BeanUtils.copyProperties(order,orderDto);
            List<OrderDetailDto> orderDetails = null;
            try {
                orderDetails = orderDetailService.getOrderDetaiListByOrder(orderDto.getId());

            } catch (Exception e) {
                e.printStackTrace();
            }
            orderDto.setOrderDetails(orderDetails);
            orderDto.setCreateTime();
            resultList.add(orderDto);
        }

        PageInfo<OrderDto> pageInfos = new PageInfo<>(resultList);

        return pageInfos;
    }

    @Transactional
    @Override
    public void changeOrderStatus(OrderDto orderDto) {
        Order order = orderMapper.selectByPrimaryKey(orderDto.getId());
        order.setStatus(orderDto.getStatus());
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void deleteOrder(String id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    //生成订单编号
    private String generateOrderNumber(){
        //SP-DXXXXXXXXX XX指年份；XX指月份；XXX为001-999
        //currentYear + currentMonth + countValue
        String orderNumber= "";
        String countValue = "";

        //获取当前年月
        Calendar calendar = Calendar.getInstance();
        String currentYear = calendar.get(Calendar.YEAR) + "";
        String currentMonth = "";
        int currentMonthInt = calendar.get(Calendar.MONTH) + 1;
        if(currentMonthInt<10){
            currentMonth = "0" + currentMonthInt;
        }else{
            currentMonth = currentMonthInt + "";
        }

        Order lastOrder =  orderMapper.findLastOrderData();
        //还没有订单的时候，则为第一条
        if (lastOrder == null){
            orderNumber ="SP-D"+ currentYear + currentMonth + "001";
            return orderNumber;
        }

        String orderNumberInLastOrder = lastOrder.getOrder_number();
        //获取最后一个订单的月份
        String monthInOrder = orderNumberInLastOrder.substring(8,10);

        //假如当前的订单月份和最后一个不一致，则重新生成后三位
        if (!monthInOrder.equals(currentMonth)){
            countValue = "001";
        }else {//一致，则在原来的基础上加1
            //最后一个订单的个数编号---最后3位
            String countValueInLastOrderStr = orderNumberInLastOrder.substring(10,13);
            Integer countValueInLastOrderInt = Integer.parseInt(countValueInLastOrderStr);
            Integer currentCountValueInteger = countValueInLastOrderInt + 1;
            if (currentCountValueInteger < 10){
                countValue = "00" + currentCountValueInteger + "";
            }else if(countValueInLastOrderInt + 1 < 100){
                countValue = "0" + currentCountValueInteger + "";
            }

        }
        orderNumber= "SP-D"+currentYear + currentMonth + countValue;
        return orderNumber;
    }

}