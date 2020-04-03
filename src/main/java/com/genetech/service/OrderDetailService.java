package com.genetech.service;

import com.genetech.bean.dto.OrderDetailDto;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Administrator on 2019/12/17.
 */

public interface OrderDetailService {

    public int addOrderDetail(OrderDetailDto orderDetailDto);

    public List<OrderDetailDto> getOrderDetaiListByOrder(String orderId) throws InvocationTargetException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    public void changeOrderStatus(String orderDetailId, Integer status);
}
