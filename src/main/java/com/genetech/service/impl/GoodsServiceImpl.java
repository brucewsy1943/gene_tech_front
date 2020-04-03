package com.genetech.service.impl;

import com.genetech.bean.Goods;
import com.genetech.bean.GoodsExample;
import com.genetech.bean.dto.GoodsDto;
import com.genetech.bean.dto.PageDto;
import com.genetech.dao.GoodsMapper;
import com.genetech.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Administrator on 2019/12/16.
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods getGoodsById(Integer id) {

        return goodsMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int addGoods(GoodsDto goodsDto) {
        goodsMapper.insert(goodsDto);
        return goodsDto.getId();
    }

    @Override
    public PageInfo<Goods> getGoodsPageList(GoodsDto goodsDto, PageDto pageDto) {
        GoodsExample goodsExample = new GoodsExample();

        PageHelper.startPage(pageDto.getPageNum(),pageDto.getPageSize());
        List<Goods> goodsPageList = goodsMapper.selectByExample(goodsExample);

        PageInfo<Goods> pageInfo = new PageInfo<>(goodsPageList);
        return pageInfo;
    }

    @Override
    public Goods getGoodsByProductId(Integer productId) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andProduct_idEqualTo(productId);
       List<Goods> goodses = goodsMapper.selectByExample(goodsExample);
        if (CollectionUtils.isEmpty(goodses)){
            return null;
        }
        return goodses.get(0);
    }

    @Override
    public void deleteGoodsByPruductId(List<Integer> productIds) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andProduct_idIn(productIds);
        goodsMapper.deleteByExample(goodsExample);
    }
}
