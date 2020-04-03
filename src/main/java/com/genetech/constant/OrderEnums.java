package com.genetech.constant;

/**
 * Created by Administrator on 2019/12/19.
 * 状态枚举
 */
public enum OrderEnums {
    //订单 0：未付款 1：待发货 2：待收货 3：完成 4：取消
    ORDER_CANCEL(4,"已取消"),
    ORDER_COMPLETE(3,"已完成"),
    ORDER_WAIT_RECEIVE(2,"待收货"),
    ORDER_WAIT_SEND(1,"待发货"),
    ORDER_WAIT_PAY(0,"未付款");

    private Integer index;
    private String value;

    OrderEnums(Integer index, String value) {
        this.index = index;
        this.value = value;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static String getOrderStateName(Integer index){
        for (OrderEnums e : OrderEnums.values()) {
            if (e.getIndex() .equals(index) ) {
                return e.getValue();
            }
        }
        return null;
    }

}
