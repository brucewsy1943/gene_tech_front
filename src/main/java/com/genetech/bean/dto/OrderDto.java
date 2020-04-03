package com.genetech.bean.dto;

import com.genetech.bean.Order;
import com.genetech.bean.OrderDetail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/12/16.
 */
public class OrderDto extends Order{
    private List<OrderDetailDto> orderDetails;
    private String createTime;//yyyy-MM-dd
    private DeliveryAddressDto deliveryAddressDto;//地址

    public OrderDto() {

    }

    public OrderDto(String id, Integer address_id, Integer user_id, Integer status, String order_number, Date create_time, Integer invoice_id, Integer pay_type, String remark) {
        super(id, address_id, user_id, status, order_number, create_time, invoice_id, pay_type, remark);

    }

    public List<OrderDetailDto> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailDto> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.createTime = sdf.format(super.getCreate_time());
    }
    public void setCreateTime(String createTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.createTime = sdf.format(super.getCreate_time());
    }

    public DeliveryAddressDto getDeliveryAddressDto() {
        return deliveryAddressDto;
    }

    public void setDeliveryAddressDto(DeliveryAddressDto deliveryAddressDto) {
        this.deliveryAddressDto = deliveryAddressDto;
    }
}
