package com.genetech.bean.dto;

/**
 * Created by Administrator on 2019/12/15.
 */

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 购物车
 */
public class ShoppingCartDto implements Serializable{

    private Integer goodsId;
    private String goodsName;
    private String goodsCode;//商品编号
    private String productCode;//产品编号
    private Integer goodsNum;//数量
    private BigDecimal price;//价格
    private BigDecimal sumary;//小计
    private Integer productId;

    public ShoppingCartDto() {
    }

    public ShoppingCartDto(Integer goodsId, String goodsName, String goodsCode, String productCode, Integer goodsNum, BigDecimal price, BigDecimal sumary, Integer productId) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsCode = goodsCode;
        this.productCode = productCode;
        this.goodsNum = goodsNum;
        this.price = price;
        this.sumary = sumary;
        this.productId = productId;
    }

    public ShoppingCartDto(String goodsName, String goodsCode, String productCode, Integer goodsNum, BigDecimal price, BigDecimal sumary) {
        this.goodsName = goodsName;
        this.goodsCode = goodsCode;
        this.productCode = productCode;
        this.goodsNum = goodsNum;
        this.price = price;
        this.sumary = sumary;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSumary() {
        return sumary;
    }

    public void setSumary(BigDecimal sumary) {
        this.sumary = sumary;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
