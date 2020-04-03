package com.genetech.controller;

/**
 * Created by Administrator on 2019/12/15.
 */

import com.genetech.bean.DeliveryAddress;
import com.genetech.bean.ResponseBean;
import com.genetech.bean.SiteUser;
import com.genetech.bean.dto.DeliveryAddressDto;
import com.genetech.constant.ReturnCode;
import com.genetech.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 地址
 */
@RestController
@RequestMapping("/address")
public class AddressController extends BaseController{

    @Autowired
    private AddressService addressService;


    @GetMapping("/list")
    public ResponseBean getAddressList(HttpServletRequest request,DeliveryAddressDto deliveryAddressDto){

        isUserLogin(request);
        SiteUser siteUser = null;
        try {
            siteUser = getUserInfo(request);
            deliveryAddressDto.setUser_id(siteUser.getId());
            List<DeliveryAddress> list = addressService.getDeliveryAddressByUser(deliveryAddressDto);
            return new ResponseBean(true, 200, "success！",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return   new ResponseBean(false, 500, "服务器错误！获取列表失败！",null);

    }

    @PostMapping("/add")
    public  ResponseBean addAddress(HttpServletRequest request,DeliveryAddressDto deliveryAddressDto){
        deliveryAddressDto.setId(null);
        try {
            isUserLogin(request);
            SiteUser siteUser = getUserInfo(request);
            deliveryAddressDto.setUser_id(siteUser.getId());
            int addressId = addressService.addDeliveryAddress(deliveryAddressDto);
            DeliveryAddressDto result = addressService.getDeliverAddressById(addressId);
            return new ResponseBean(true, 200, "success！",result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return   new ResponseBean(false, 500, "添加失败！",null);
    }

    @PostMapping("/modify")
    public  ResponseBean modifyAddress(HttpServletRequest request,DeliveryAddressDto deliveryAddressDto){
        if (deliveryAddressDto.getId() == null){
            return new ResponseBean(false, 500, "id不能为空！",null);
        }
        SiteUser siteUser = null;
        try {
            siteUser = getUserInfo(request);
            if (siteUser == null){
                return new ResponseBean(false, 500, "获取用户信息失败！",null);
            }
            deliveryAddressDto.setUser_id(siteUser.getId());
            addressService.updateDeliveryAddress(deliveryAddressDto);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBean(false, 500, "服务器错误！修改失败！",null);
        }
        return new ResponseBean(true, 200, "success！",null);
    }

    @GetMapping("/info")
    public ResponseBean getAddressById(Integer id){
        if (id == null){
            return new ResponseBean(false, 500, "id不能为空！",null);
        }
        DeliveryAddress info = null;
        try {
            info = addressService.getDeliverAddressById(id);
            if (info == null){
              return new ResponseBean(false, 500, "地址不存在！",null);
            }
        }catch (Exception e){
            e.printStackTrace();
           return new ResponseBean(false, 500, "服务器错误！修改失败！",null);
        }
        return new ResponseBean(true, 200, "success！",info);

    }

    @GetMapping("/delete")
    public ResponseBean deleteAddr(Integer id){

        if (id == null){
            return  new ResponseBean(false, 500, "id不能为空！",null);
        }

        addressService.deleteAddress(id);

        return new ResponseBean(true, 200, "success！",null);
    }
}
