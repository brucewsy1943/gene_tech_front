package com.genetech.service.impl;

import com.genetech.bean.DeliveryAddress;
import com.genetech.bean.DeliveryAddressExample;
import com.genetech.bean.dto.DeliveryAddressDto;
import com.genetech.dao.DeliveryAddressMapper;
import com.genetech.service.AddressService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Administrator on 2019/12/18.
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private DeliveryAddressMapper deliveryAddressMapper;

    @Override
    public int addDeliveryAddress(DeliveryAddressDto deliveryAddressDto) {
        deliveryAddressMapper.insert(deliveryAddressDto);
        return deliveryAddressDto.getId();
    }

    @Override
    public List<DeliveryAddress> getDeliveryAddressByUser(DeliveryAddressDto deliveryAddressDto) {
        DeliveryAddressExample deliveryAddressExample = new DeliveryAddressExample();
        DeliveryAddressExample.Criteria criteria = deliveryAddressExample.createCriteria();
        criteria.andUser_idEqualTo(deliveryAddressDto.getUser_id());
        return deliveryAddressMapper.selectByExample(deliveryAddressExample);
    }

    @Override
    public DeliveryAddressDto getDeliverAddressById(Integer id) throws InvocationTargetException, IllegalAccessException {
        DeliveryAddress deliveryAddress = deliveryAddressMapper.selectByPrimaryKey(id);
        DeliveryAddressDto deliveryAddressDto = new DeliveryAddressDto();
        BeanUtils.copyProperties(deliveryAddressDto,deliveryAddress);
        return deliveryAddressDto;
    }

    @Override
    public void updateDeliveryAddress(DeliveryAddressDto deliveryAddressDto) {

       deliveryAddressMapper.updateByPrimaryKey(deliveryAddressDto);

        //return deliveryAddressMapper.selectByPrimaryKey(deliveryAddressDto.getId());
    }

    @Override
    public void deleteAddress(Integer id) {
        deliveryAddressMapper.deleteByPrimaryKey(id);
    }
}
