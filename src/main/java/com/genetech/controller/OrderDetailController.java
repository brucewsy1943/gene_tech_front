package com.genetech.controller;

import com.genetech.bean.Order;
import com.genetech.bean.OrderDetail;
import com.genetech.bean.ResponseBean;
import com.genetech.bean.dto.OrderDetailDto;
import com.genetech.bean.dto.OrderDto;
import com.genetech.service.OrderDetailService;
import com.genetech.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Created by Administrator on 2019/12/14.
 */
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderService orderService;

    private final long expiretime = 1000*60*60; //1000*60*60---1小时

    /**
     * 订单状态变更
     * @return
     */
    @PostMapping("/changeStatus")
    public ResponseBean changeOrderStatus(String orderDetailId,Integer status){
        if (orderDetailId == null || "".equals(orderDetailId)){
            return  new ResponseBean(false, 500, "id不能为空！",null);
        }
        if (status == null){
            return  new ResponseBean(false, 500, "状态码不能为空！",null);
        }

        try{
            orderDetailService.changeOrderStatus(orderDetailId,status);
            return  new ResponseBean(true, 200, "订单状态更新成功！",null);
        }catch(Exception e){
            e.printStackTrace();
            return  new ResponseBean(false, 500, "订单状态更新失败 服务器错误！",null);
        }

    }

    //是否允许取消订单
    @GetMapping("/isOrderCancelAllowed")
    public ResponseBean isOrderCancelAllowed(String orderDetailId){
        try {
            OrderDetailDto orderDetail = orderDetailService.getOrderDetailInfo(orderDetailId);
            if(orderDetail!=null && orderDetail.getOrder_id()!=null && !"".equals(orderDetail.getOrder_id())){
                Order order = orderService.getOrderInfo(orderDetail.getOrder_id());
                Date addTime = order.getCreate_time();
                Date now = new Date();
                if((now.getTime() - addTime.getTime())>expiretime){
                    return new ResponseBean(false, 201, "一小时后订单不可取消！",null);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBean(false, 500, "服务器错误！",null);
        }

        return new ResponseBean(true, 200, "可以取消！",null);
    }

}
