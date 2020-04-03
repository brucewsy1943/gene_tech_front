package com.genetech.bean.dto;

import com.genetech.bean.DeliveryAddress;

/**
 * Created by Administrator on 2019/12/18.
 */
public class DeliveryAddressDto extends DeliveryAddress {

    public DeliveryAddressDto() {
    }

    public DeliveryAddressDto(Integer id, Integer user_id, String detail_address, String phone, String name, Integer is_default) {
        super(id, user_id, detail_address, phone, name, is_default);
    }
}
