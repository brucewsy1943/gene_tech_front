package com.genetech.bean.dto;

import com.genetech.bean.Goods;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2019/12/18.
 */
public class GoodsDto extends Goods {

    private  String keyword;

    public GoodsDto() {
    }

    public GoodsDto(Integer id, BigDecimal price, String name, String attachment_urls, Integer status, String product_code, Integer stock, String goods_code, Integer product_id, String introduction) {
        super(id, price, name, attachment_urls, status, product_code, stock, goods_code, product_id, introduction);
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }


}
