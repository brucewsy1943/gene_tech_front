package com.genetech.controller;

import com.genetech.bean.ResponseBean;
import com.genetech.bean.dto.OrderDto;
import com.genetech.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/12/14.
 */
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;
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
}
