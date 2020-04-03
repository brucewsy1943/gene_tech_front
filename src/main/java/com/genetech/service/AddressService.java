package com.genetech.service;

import com.genetech.bean.DeliveryAddress;
import com.genetech.bean.dto.DeliveryAddressDto;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Administrator on 2019/12/18.
 */
public interface AddressService {

    public int addDeliveryAddress(DeliveryAddressDto deliveryAddressDto);

    public List<DeliveryAddress> getDeliveryAddressByUser(DeliveryAddressDto deliveryAddressDto);

    public DeliveryAddressDto getDeliverAddressById(Integer id) throws InvocationTargetException, IllegalAccessException;

    public void updateDeliveryAddress(DeliveryAddressDto deliveryAddressDto);

    public void deleteAddress(Integer id);
}
