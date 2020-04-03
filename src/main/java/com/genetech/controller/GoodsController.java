package com.genetech.controller;

import com.genetech.bean.ResponseBean;
import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2019/12/14.
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    //添加商品到购物车
    @RequestMapping("/addToShoppingCart")
    public ResponseBean putGoodsIntoShoppingCart(Integer goodsId, HttpServletRequest request){
        HttpSession session = request.getSession();


        return null;
    }



}
