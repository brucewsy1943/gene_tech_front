package com.genetech.bean;

import java.util.Date;

public class Order {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.id
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.address_id
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    private Integer address_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.user_id
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    private Integer user_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.status
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.order_number
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    private String order_number;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.create_time
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    private Date create_time  = new Date();;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.invoice_id
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    private Integer invoice_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.pay_type
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    private Integer pay_type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.remark
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    private String remark;

    public Order() {
    }

    public Order(String id, Integer address_id, Integer user_id, Integer status, String order_number, Date create_time, Integer invoice_id, Integer pay_type, String remark) {
        this.id = id;
        this.address_id = address_id;
        this.user_id = user_id;
        this.status = status;
        this.order_number = order_number;
        this.create_time = create_time;
        this.invoice_id = invoice_id;
        this.pay_type = pay_type;
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.id
     *
     * @return the value of t_order.id
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.id
     *
     * @param id the value for t_order.id
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.address_id
     *
     * @return the value of t_order.address_id
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public Integer getAddress_id() {
        return address_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.address_id
     *
     * @param address_id the value for t_order.address_id
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.user_id
     *
     * @return the value of t_order.user_id
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.user_id
     *
     * @param user_id the value for t_order.user_id
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.status
     *
     * @return the value of t_order.status
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.status
     *
     * @param status the value for t_order.status
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.order_number
     *
     * @return the value of t_order.order_number
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public String getOrder_number() {
        return order_number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.order_number
     *
     * @param order_number the value for t_order.order_number
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public void setOrder_number(String order_number) {
        this.order_number = order_number == null ? null : order_number.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.create_time
     *
     * @return the value of t_order.create_time
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.create_time
     *
     * @param create_time the value for t_order.create_time
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.invoice_id
     *
     * @return the value of t_order.invoice_id
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public Integer getInvoice_id() {
        return invoice_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.invoice_id
     *
     * @param invoice_id the value for t_order.invoice_id
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public void setInvoice_id(Integer invoice_id) {
        this.invoice_id = invoice_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.pay_type
     *
     * @return the value of t_order.pay_type
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public Integer getPay_type() {
        return pay_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.pay_type
     *
     * @param pay_type the value for t_order.pay_type
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.remark
     *
     * @return the value of t_order.remark
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.remark
     *
     * @param remark the value for t_order.remark
     *
     * @mbg.generated Mon Dec 16 17:08:34 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}