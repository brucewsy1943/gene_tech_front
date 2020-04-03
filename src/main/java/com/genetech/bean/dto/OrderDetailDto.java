package com.genetech.bean.dto;

import com.genetech.bean.OrderDetail;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2019/12/17.
 */
public class OrderDetailDto extends OrderDetail {
    private String orderStatus;
    private String goodsName;
    private Integer plasmidId;
    private String productCode;

    public OrderDetailDto() {
    }

    public OrderDetailDto(String id, String order_id, Integer goods_num, BigDecimal money, Integer goods_id, BigDecimal discount, Integer pay_type, Integer order_status, BigDecimal sumary, String goods_name, Integer product_id) {
        super(id, order_id, goods_num, money, goods_id, discount, pay_type, order_status, sumary, goods_name, product_id);
    }

    public OrderDetailDto(String id, String order_id, Integer goods_num, BigDecimal money, Integer goods_id, BigDecimal discount, Integer pay_type, Integer order_status, BigDecimal sumary, String goods_name, Integer product_id, String orderStatus, String goodsName, Integer plasmidId, String productCode) {
        super(id, order_id, goods_num, money, goods_id, discount, pay_type, order_status, sumary, goods_name, product_id);
        this.orderStatus = orderStatus;
        this.goodsName = goodsName;
        this.plasmidId = plasmidId;
        this.productCode = productCode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getPlasmidId() {
        return plasmidId;
    }

    public void setPlasmidId(Integer plasmidId) {
        this.plasmidId = plasmidId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
