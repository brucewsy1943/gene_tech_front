package com.genetech.bean;

public class DeliveryAddress {

    public DeliveryAddress() {
    }

    public DeliveryAddress(Integer id, Integer user_id, String detail_address, String phone, String name, Integer is_default) {
        this.id = id;
        this.user_id = user_id;
        this.detail_address = detail_address;
        this.phone = phone;
        this.name = name;
        this.is_default = is_default;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_delivery_address.id
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_delivery_address.user_id
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    private Integer user_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_delivery_address.detail_address
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    private String detail_address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_delivery_address.phone
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_delivery_address.name
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_delivery_address.is_default
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    private Integer is_default;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_delivery_address.id
     *
     * @return the value of t_delivery_address.id
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_delivery_address.id
     *
     * @param id the value for t_delivery_address.id
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_delivery_address.user_id
     *
     * @return the value of t_delivery_address.user_id
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_delivery_address.user_id
     *
     * @param user_id the value for t_delivery_address.user_id
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_delivery_address.detail_address
     *
     * @return the value of t_delivery_address.detail_address
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    public String getDetail_address() {
        return detail_address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_delivery_address.detail_address
     *
     * @param detail_address the value for t_delivery_address.detail_address
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address == null ? null : detail_address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_delivery_address.phone
     *
     * @return the value of t_delivery_address.phone
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_delivery_address.phone
     *
     * @param phone the value for t_delivery_address.phone
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_delivery_address.name
     *
     * @return the value of t_delivery_address.name
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_delivery_address.name
     *
     * @param name the value for t_delivery_address.name
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_delivery_address.is_default
     *
     * @return the value of t_delivery_address.is_default
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    public Integer getIs_default() {
        return is_default;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_delivery_address.is_default
     *
     * @param is_default the value for t_delivery_address.is_default
     *
     * @mbg.generated Fri Dec 27 15:23:01 CST 2019
     */
    public void setIs_default(Integer is_default) {
        this.is_default = is_default;
    }
}