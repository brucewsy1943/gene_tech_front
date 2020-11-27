package com.genetech.controller;

import com.alibaba.fastjson.JSON;
import com.genetech.bean.Goods;
import com.genetech.bean.ResponseBean;
import com.genetech.bean.SiteUser;
import com.genetech.bean.dto.ShoppingCartDto;
import com.genetech.constant.ReturnCode;
import com.genetech.service.GoodsService;
import com.genetech.service.SiteUserService;
import com.genetech.utils.RedisUtils;
import com.genetech.utils.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/12/15.
 */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController extends BaseController{

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public synchronized ResponseBean addGoodsToShoppingCart(Integer goodsId,Integer goodsNum, HttpServletRequest request){

        //找到相关goods信息
        Goods goods = goodsService.getGoodsById(goodsId);
        //user信息
        SiteUser siteUser = null;
        try {
            siteUser = getUserInfo(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBean(false,ReturnCode.EMPTY_USER,"用户未登录",null,e.getMessage());
        }
        //从redis中取出数据
        Integer userId = siteUser.getId();
         String cartKey = userId+"shoppingCart";
        List<ShoppingCartDto> list = RedisUtils.getList(cartKey,ShoppingCartDto.class);
        if (!CollectionUtils.isEmpty(list)){
            list = RedisUtils.getList(cartKey,ShoppingCartDto.class);
        }
        //标识符:判断是否存在此商品
        boolean flag = false;//假如之前已经添加了这个商品则只是数量上改变
        for (int i = 0; i < list.size(); i++) {
            ShoppingCartDto scv =  list.get(i);
            if (scv.getProductCode().equals(goods.getProduct_code())){
                flag = true;
                scv.setGoodsNum(scv.getGoodsNum() + goodsNum);
                scv.setSumary(goods.getPrice().multiply(BigDecimal.valueOf(scv.getGoodsNum())) );
            }
        }
        //新增商品
        if (!flag){
           //封装购物车对象
            BigDecimal sumary = goods.getPrice().multiply(BigDecimal.valueOf(goodsNum));
            ShoppingCartDto shoppingCartVo = new ShoppingCartDto(goodsId,goods.getName(), goods.getGoods_code(), goods.getProduct_code(), goodsNum, goods.getPrice(), sumary,goods.getProduct_id());
            list.add(shoppingCartVo);
        }
        //放入Redis
        //先清空
        Jedis jedis = RedisUtils.getJedis();
        jedis.del(cartKey);
       RedisUtils.saveList(cartKey,list);
        return new ResponseBean(true,200,"请求成功",null);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public synchronized ResponseBean updateGoodsToShoppingCart(Integer goodsId,Integer goodsNum, HttpServletRequest request){

        //找到相关goods信息
        Goods goods = goodsService.getGoodsById(goodsId);
        //user信息
        SiteUser siteUser = null;
        try {
            siteUser = getUserInfo(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBean(false,ReturnCode.EMPTY_USER,"用户未登录",null,e.getMessage());
        }
        //从redis中取出数据
        Integer userId = siteUser.getId();
        String cartKey = userId+"shoppingCart";
        List<ShoppingCartDto> list = RedisUtils.getList(cartKey,ShoppingCartDto.class);
        if (!CollectionUtils.isEmpty(list)){
            list = RedisUtils.getList(cartKey,ShoppingCartDto.class);
        }
        //标识符:判断是否存在此商品
        boolean flag = false;//假如之前已经添加了这个商品则只是数量上改变
        for (int i = 0; i < list.size(); i++) {
            ShoppingCartDto scv =  list.get(i);
            if (scv.getGoodsName().equals(goods.getName())){
                flag = true;
                scv.setGoodsNum(goodsNum);
                scv.setSumary(goods.getPrice().multiply(BigDecimal.valueOf(goodsNum)) );
            }
        }
        //新增商品
        if (!flag){
            //封装购物车对象
            BigDecimal sumary = goods.getPrice().multiply(BigDecimal.valueOf(goodsNum));
            ShoppingCartDto shoppingCartVo = new ShoppingCartDto(goodsId,goods.getName(), goods.getGoods_code(), goods.getProduct_code(), goodsNum, goods.getPrice(), sumary,goods.getProduct_id());
            list.add(shoppingCartVo);
        }
        //放入Redis
        //先清空
        Jedis jedis = RedisUtils.getJedis();
        jedis.del(cartKey);
        RedisUtils.saveList(cartKey,list);
        return new ResponseBean(true,200,"请求成功",null);
    }




    /**
     * 获取购物车列表
     * @return
     */
    @RequestMapping("/list")
    public  ResponseBean shoppingCartList(HttpServletRequest request){
        SiteUser siteUser = null;
        List<ShoppingCartDto> list = null;
        try {
            siteUser = getUserInfo(request);
            if(siteUser == null){
                new ResponseBean(false, ReturnCode.EMPTY_USER,"用户未登录！",null);
            }
            Integer userId = siteUser.getId();
            String cartKey = userId+"shoppingCart";
            list = RedisUtils.getList(cartKey,ShoppingCartDto.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBean(false, ReturnCode.EMPTY_USER,e.getMessage(),null,e.getMessage());
        }

        //List<ShoppingCartDto> list = cartMap.get(cartKey);
        return new ResponseBean(true,200,"请求成功",list);
    }

    /**
     * 清空购物车
     */
    @RequestMapping("/clear")
    public ResponseBean clearShoppingCart(HttpServletRequest request){
        SiteUser siteUser = null;
        try {
            siteUser = getUserInfo(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBean(false,ReturnCode.EMPTY_USER,"用户未登录",null,e.getMessage());
        }

        Integer userId = siteUser.getId();
        String cartKey = userId+"shoppingCart";
       Jedis jedis = RedisUtils.getJedis();
        jedis.del(cartKey);
        //cartMap.remove(cartKey);
        return new ResponseBean(true,200,"请求成功",null);
    }

    /**
     * 清除某一项购物车
     *
     */
    @GetMapping("/delete")
    public ResponseBean removeShoppingCartItem(HttpServletRequest request,Integer id){
        if (id == null){
            return  new ResponseBean(false,500,"商品ID不能为空！",null);
        }

        SiteUser siteUser = null;
        try {
            siteUser = getUserInfo(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBean(false,ReturnCode.EMPTY_USER,"用户未登录",null,e.getMessage());
        }

        Integer userId = siteUser.getId();
        String cartKey = userId+"shoppingCart";

        List<ShoppingCartDto> list = RedisUtils.getList(cartKey,ShoppingCartDto.class);
        for (int i = 0; i <list.size() ; i++) {
            if (id.equals(list.get(i).getGoodsId())){
                list.remove(i);
            }
        }
        Jedis jedis = RedisUtils.getJedis();
        //先删了
        jedis.del(cartKey);
        //再放进去
        if(!CollectionUtils.isEmpty(list)){
            RedisUtils.saveList(cartKey,list);
        }
        return new ResponseBean(true,200,"请求成功",null);
    }

    private ResponseBean errorMessage(HttpServletRequest request){
        SiteUser siteUser = null;
        try {
            siteUser = getUserInfo(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBean(false,ReturnCode.EMPTY_USER,"用户未登录",null,e.getMessage());
        }
        return null;
    }

    //增减数量
    @GetMapping("/changeNum")
    public ResponseBean changeShoppingCartItemNum(HttpServletRequest request,Integer id,Integer number){
        SiteUser siteUser = null;
        try {
            siteUser = getUserInfo(request);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBean(false,ReturnCode.EMPTY_USER,"用户未登录",null,e.getMessage());
        }

        Integer userId = siteUser.getId();
        String cartKey = userId+"shoppingCart";
        Jedis jedis = RedisUtils.getJedis();

        List<ShoppingCartDto> list = RedisUtils.getList(cartKey,ShoppingCartDto.class);
        //先找到
        for (int i = 0; i <list.size() ; i++) {
            if (id.equals(list.get(i).getGoodsId())){
                list.get(i).setGoodsNum(number);
            }
        }
        //重新塞回去
        RedisUtils.saveList(cartKey,list);
        return new ResponseBean(true,200,"请求成功",list);
    }



}
