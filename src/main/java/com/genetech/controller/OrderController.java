package com.genetech.controller;

import com.genetech.bean.Order;
import com.genetech.bean.ResponseBean;
import com.genetech.bean.SiteUser;
import com.genetech.bean.dto.*;

import com.genetech.constant.ReturnCode;
import com.genetech.service.AddressService;
import com.genetech.service.InvoiceService;
import com.genetech.service.OrderDetailService;
import com.genetech.service.OrderService;
import com.genetech.utils.RedisUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2019/12/14.
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController{

    @Autowired
    private OrderService orderService;


    //生成订单---提交结算之后的操作
    @RequestMapping("/addOrder")
    public ResponseBean addOrder(HttpServletRequest request, OrderDto orderDto, InvoiceDto invoiceDto){

        SiteUser siteUser = null;
        try {
            siteUser = getUserInfo(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBean(false, ReturnCode.EMPTY_USER,"用户未登录",null,e.getMessage());
        }

        Integer userId =  siteUser.getId();
        String cartKey =userId +"shoppingCart";

        String orderId = orderService.addOrder(cartKey,orderDto,userId, invoiceDto);
        if (StringUtils.isEmpty(orderId)){
            return new ResponseBean(false, 500,"购物车已清空！",null);
        }

        return new ResponseBean(true, 200, "success！",orderId);
    }

    /**
     * 分页查询orderList
     */
    @RequestMapping("/list")
    public ResponseBean getOrderList(HttpServletRequest request , PageDto pageDto){

        SiteUser siteUser = null;
        try {
            siteUser = getUserInfo(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBean(true, ReturnCode.EMPTY_USER,"用户未登录",null,e.getMessage());
        }
        Integer userId =  siteUser.getId();

        PageInfo<OrderDto> orderPageInfo = orderService.getOrderPageListByUser(userId,pageDto);

        return new ResponseBean(true, 200, "success！",orderPageInfo);
    }




    /**
     * 订单详情
     */
    @RequestMapping("/info")
    public ResponseBean getOrderInfo(String id){
        if (id == null){
            return new ResponseBean(false, 500, "id不能为空！",null);
        }

        try {
            return new ResponseBean(true, 200, "success！",orderService.getOrderInfo(id));
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseBean(true, 500, "获取失败！",null);
    }

    @GetMapping("/delete")
    public ResponseBean deleteOrderInfo(String id){
      if (id == null){
          return new ResponseBean(false, 500, "id不能为空！",null);
      }
        try {
            orderService.deleteOrder(id);
            return new ResponseBean(true, 200, "删除成功！",null);
        } catch (Exception e) {
            e.printStackTrace();

        }
      return new ResponseBean(false, 500, "删除失败！",null);
    }

}
