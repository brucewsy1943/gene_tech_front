package com.genetech.service;

import com.genetech.bean.Order;
import com.genetech.bean.dto.*;
import com.github.pagehelper.PageInfo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Administrator on 2019/12/17.
 */
public interface OrderService {

    public String addOrder(String cartKey, OrderDto orderDto, Integer userId,InvoiceDto invoiceDto);

    public OrderDto getOrderInfo(String orderId) throws InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException;

    public PageInfo<OrderDto> getOrderPageListByUser(Integer userId, PageDto pageDto);

    public void changeOrderStatus(OrderDto orderDto);

    public void deleteOrder(String id);

}
