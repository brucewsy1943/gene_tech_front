package com.genetech.bean;

import java.math.BigDecimal;

public class OrderDetail {

    public OrderDetail() {
    }

    public OrderDetail(String id, String order_id, Integer goods_num, BigDecimal money, Integer goods_id, BigDecimal discount, Integer pay_type, Integer order_status, BigDecimal sumary, String goods_name, Integer product_id) {
        this.id = id;
        this.order_id = order_id;
        this.goods_num = goods_num;
        this.money = money;
        this.goods_id = goods_id;
        this.discount = discount;
        this.pay_type = pay_type;
        this.order_status = order_status;
        this.sumary = sumary;
        this.goods_name = goods_name;
        this.product_id = product_id;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_detail.id
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_detail.order_id
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    private String order_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_detail.goods_num
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    private Integer goods_num;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_detail.money
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    private BigDecimal money;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_detail.goods_id
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    private Integer goods_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_detail.discount
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    private BigDecimal discount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_detail.pay_type
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    private Integer pay_type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_detail.order_status
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    private Integer order_status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_detail.sumary
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    private BigDecimal sumary;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_detail.goods_name
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    private String goods_name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_detail.product_id
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    private Integer product_id;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_detail.id
     *
     * @return the value of t_order_detail.id
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_detail.id
     *
     * @param id the value for t_order_detail.id
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_detail.order_id
     *
     * @return the value of t_order_detail.order_id
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public String getOrder_id() {
        return order_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_detail.order_id
     *
     * @param order_id the value for t_order_detail.order_id
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public void setOrder_id(String order_id) {
        this.order_id = order_id == null ? null : order_id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_detail.goods_num
     *
     * @return the value of t_order_detail.goods_num
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public Integer getGoods_num() {
        return goods_num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_detail.goods_num
     *
     * @param goods_num the value for t_order_detail.goods_num
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public void setGoods_num(Integer goods_num) {
        this.goods_num = goods_num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_detail.money
     *
     * @return the value of t_order_detail.money
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_detail.money
     *
     * @param money the value for t_order_detail.money
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_detail.goods_id
     *
     * @return the value of t_order_detail.goods_id
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public Integer getGoods_id() {
        return goods_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_detail.goods_id
     *
     * @param goods_id the value for t_order_detail.goods_id
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_detail.discount
     *
     * @return the value of t_order_detail.discount
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_detail.discount
     *
     * @param discount the value for t_order_detail.discount
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_detail.pay_type
     *
     * @return the value of t_order_detail.pay_type
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public Integer getPay_type() {
        return pay_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_detail.pay_type
     *
     * @param pay_type the value for t_order_detail.pay_type
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_detail.order_status
     *
     * @return the value of t_order_detail.order_status
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public Integer getOrder_status() {
        return order_status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_detail.order_status
     *
     * @param order_status the value for t_order_detail.order_status
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_detail.sumary
     *
     * @return the value of t_order_detail.sumary
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public BigDecimal getSumary() {
        return sumary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_detail.sumary
     *
     * @param sumary the value for t_order_detail.sumary
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public void setSumary(BigDecimal sumary) {
        this.sumary = sumary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_detail.goods_name
     *
     * @return the value of t_order_detail.goods_name
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public String getGoods_name() {
        return goods_name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_detail.goods_name
     *
     * @param goods_name the value for t_order_detail.goods_name
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name == null ? null : goods_name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_detail.product_id
     *
     * @return the value of t_order_detail.product_id
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public Integer getProduct_id() {
        return product_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_detail.product_id
     *
     * @param product_id the value for t_order_detail.product_id
     *
     * @mbg.generated Wed Jan 01 22:39:31 CST 2020
     */
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
}