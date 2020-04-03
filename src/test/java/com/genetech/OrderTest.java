package com.genetech;

import com.genetech.bean.Goods;
import com.genetech.bean.dto.*;
import com.genetech.controller.OrderController;
import com.genetech.service.GoodsService;
import com.genetech.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2019/12/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderController orderController;

    @Test
    public void testInsert(){
        String orderId = UUID.randomUUID().toString();
        String orderNumber = UUID.randomUUID().toString();
        List<ShoppingCartDto> shoppingCartDtos = new ArrayList<>();

        //取5条数据
        GoodsDto goodsDto = new GoodsDto();
        PageDto pageDto = new PageDto();
        pageDto.setPageNum(1);
        pageDto.setPageSize(5);
        PageInfo<Goods> goodsPageInfo = goodsService.getGoodsPageList(goodsDto,pageDto);
        List<Goods> goodsList = goodsPageInfo.getList();
        for ( Goods goods :goodsList) {
            int goodsNum = (int) (Math.random()*5 + 1);
            BigDecimal price = new BigDecimal(300);
            BigDecimal sumary = price.multiply(new BigDecimal(goodsNum));
            ShoppingCartDto shoppingCartDto = new ShoppingCartDto(goods.getId(), //goodsId
                                                                    goods.getName(),//goodsName
                                                                    goods.getGoods_code(), //goodsCode
                                                                    goods.getProduct_code(),//productCode
                                                                    goodsNum,//goodsNum
                                                                    price,//price
                                                                    sumary,goods.getProduct_id());//sumary
            shoppingCartDtos.add(shoppingCartDto);
        }

       InvoiceDto invoiceDto = new InvoiceDto(null,//id
                                            "faked", //title 抬头
                                            "3958673edx",//tax_number
                                            "森帆高岛123号",//地址regist_address
                                             "13567849382",//注册电话regist_phone
                                                "中国银行",//开户行open_bank
                                              "293487523452",//账号open_account
                                              null,//user_id
                                              "content");

        DeliveryAddressDto deliveryAddressDto = new DeliveryAddressDto(null, //id
                                                                        null, //user_id
                                                                        "纳米城西北区",//地址
                                                                        "13345789832",
                                                                        null,
                                                                            0);

        /**
         * String id,
         * Integer address_id,
         * Integer user_id,
         * Integer status,
         * String order_number,
         * Date create_time,
         * Integer invoice_id,
         * Integer pay_type,
         * String remark

         */
        OrderDto orderDto = new OrderDto(null,//id
                                        null,//addressId
                                        null,//userId
                                        0,//status
                                        null,//order_number
                                        new Date(),
                                        null,//invoice_id
                                        0,//pay_type
                                        "remark"//remark
                                      );

      /*  MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/order/addOrder")
                .accept(MediaType.APPLICATION_FORM_URLENCODED).param("originContent", "15221365094"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();*/
       // orderController.addOrder(shoppingCartDtos,orderDto,deliveryAddressDto,invoiceDto);
       // orderService.addOrder(shoppingCartDtos,orderDto,12, 1, invoiceDto);
    }

}
