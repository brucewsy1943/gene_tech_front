package com.genetech.service;

import com.genetech.bean.Goods;
import com.genetech.bean.PlasmidInfo;
import com.genetech.bean.dto.GoodsDto;
import com.genetech.bean.dto.PageDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/12/16.
 */
public interface GoodsService {

    public Goods getGoodsById(Integer id);

    public int addGoods(GoodsDto goodsDto);

    public PageInfo<Goods> getGoodsPageList(GoodsDto goodsDto, PageDto pageDto);

    Goods getGoodsByProductId(Integer productId);

    void deleteGoodsByPruductId(List<Integer> productIds);
}
