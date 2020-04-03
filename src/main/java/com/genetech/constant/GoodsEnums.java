package com.genetech.constant;

/**
 * Created by Administrator on 2019/12/19.
 */
public enum GoodsEnums {
    //商品
    GOODS_OFFLINE(0,"下架"),
    GOODS_ONLINE(1,"上架");

    private Integer index;
    private String value;

    GoodsEnums(Integer index, String value) {
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

    public static String getGoodsStateName(Integer index){
        for (GoodsEnums e : GoodsEnums.values()) {
            if (e.getIndex() .equals(index) ) {
                return e.getValue();
            }
        }
        return null;
    }
}
