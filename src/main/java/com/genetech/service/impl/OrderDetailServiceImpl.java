package com.genetech.service.impl;

import com.genetech.bean.OrderDetail;
import com.genetech.bean.OrderDetailExample;
import com.genetech.bean.dto.OrderDetailDto;
import com.genetech.constant.OrderEnums;
import com.genetech.dao.OrderDetailMapper;
import com.genetech.service.OrderDetailService;
import com.genetech.utils.SpringUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/12/18.
 */
@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Transactional
    @Override
    public int addOrderDetail(OrderDetailDto orderDetailDto) {

        return orderDetailMapper.insert(orderDetailDto);
    }

    @Override
    public List<OrderDetailDto> getOrderDetaiListByOrder(String orderId) throws InvocationTargetException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        OrderDetailExample orderDetailExample = new OrderDetailExample();
        OrderDetailExample.Criteria criteria = orderDetailExample.createCriteria();
        criteria.andOrder_idEqualTo(orderId);
        //List<OrderDetail> orderDetails = orderDetailMapper.selectByExample(orderDetailExample);
        List<OrderDetail> orderDetails = orderDetailMapper.selectOrderDetailList(orderDetailExample);

        //转化成DTO\
       /* SpringUtil<OrderDetail> stringUtil = new SpringUtil<>();
        String classPath = "com.genetech.bean.dto";
        List<OrderDetailDto> result = stringUtil.convertBeanToDto(orderDetails,OrderDetailDto.class,classPath);*/
        String classPath = "com.genetech.bean.dto.OrderDetailDto";
        List<OrderDetailDto> result = null;
        try {
            result = getOrderDetailList(orderDetails,classPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void changeOrderStatus(String orderDetailId, Integer status) {
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderDetailId);
        orderDetail.setOrder_status(status);
        orderDetailMapper.updateByPrimaryKey(orderDetail);
    }


    private List<OrderDetailDto> getOrderDetailList(List<OrderDetail> orderDetails,String classPath) throws Exception {
        SpringUtil<OrderDetail> stringUtil = new SpringUtil<>();
        List<OrderDetailDto> dtoResult = (List<OrderDetailDto>) stringUtil.convertBeanToDto(orderDetails,OrderDetailDto.class,classPath);


        for (int i = 0; i < dtoResult.size() ; i++) {
            OrderDetailDto ordeDetailDto = dtoResult.get(i);
            ordeDetailDto.setOrderStatus(OrderEnums.getOrderStateName(ordeDetailDto.getOrder_status()));
        }
        return dtoResult;
    }

}
