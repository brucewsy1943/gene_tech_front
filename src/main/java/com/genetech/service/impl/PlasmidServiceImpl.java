package com.genetech.service.impl;

import com.genetech.bean.*;
import com.genetech.bean.dto.PageDto;
import com.genetech.bean.dto.PlasmidFilterDto;
import com.genetech.bean.dto.PlasmidInfoDto;
import com.genetech.dao.PlasmidDictMapper;
import com.genetech.dao.PlasmidInfoMapper;
import com.genetech.service.GoodsService;
import com.genetech.service.PlasmidService;
import com.genetech.utils.SpringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by Administrator on 2019/12/11.
 */
@Service("plasmidService")
public class PlasmidServiceImpl implements PlasmidService {
    @Autowired
    private PlasmidInfoMapper plasmidInfoMapper;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private PlasmidDictMapper plasmidDictMapper;

    @Override
    public PageInfo<PlasmidInfo> getPlasmidList(PlasmidInfoDto plasmidInfoDto, PageDto pageDto) {

        String keyword = plasmidInfoDto.getKeyword();
        PlasmidInfoExample plasmidInfoExample = new PlasmidInfoExample();

        PlasmidInfoExample.Criteria criteria = plasmidInfoExample.or();

        //暂时先提供标题的模糊搜索----z增加详情的大约总共10个搜索
        if (!StringUtils.isEmpty(plasmidInfoDto.getKeyword())){
            plasmidInfoExample.or().andPlasmid_nameLike(keyword);//质粒名
            plasmidInfoExample.or().andPlasmid_identificationLike(keyword);//质粒编号
            plasmidInfoExample.or().andGene_nameLike(keyword);//基因名
            plasmidInfoExample.or().andPlasmid_typeLike(keyword);//质粒类型

        }

        //分类搜索
        if (!StringUtils.isEmpty(plasmidInfoDto.getPlasmid_type())){//plasmidtype
            String[] plasmidTypes = plasmidInfoDto.getPlasmid_type().split(",");
            for ( String plasmidType : plasmidTypes) {
                plasmidInfoExample.or().andPlasmid_typeEqualTo(plasmidType);
            }
        }

        /*if (!StringUtils.isEmpty(plasmidInfoDto.getVector_type())){//vectorType
            String[] vecrorTypes = plasmidInfoDto.getVector_type().split(",");
            for ( String vecrorType : vecrorTypes) {
                plasmidInfoExample.or().andPlasmid_typeEqualTo(vecrorType);
            }
        }*/

        if (!StringUtils.isEmpty(plasmidInfoDto.getGrowth_bacterial_resistance())){//bacterial_resistance
            String[] bacterialResistances = plasmidInfoDto.getGrowth_bacterial_resistance().split(",");
            for ( String bacterialResistance : bacterialResistances) {
                plasmidInfoExample.or().andGrowth_bacterial_resistanceEqualTo(bacterialResistance);
            }
        }

        if (!StringUtils.isEmpty(plasmidInfoDto.getGrowth_selection_mark())){//selection_mark
            String[] selectionMarks = plasmidInfoDto.getGrowth_selection_mark().split(",");
            for ( String selectionMark : selectionMarks) {
                plasmidInfoExample.or().andGrowth_selection_markEqualTo(selectionMark);
            }
        }

        if (!StringUtils.isEmpty(plasmidInfoDto.getGene_species())){//Gene_species
            String[] gene_species = plasmidInfoDto.getGene_species().split(",");
            for ( String gene_specy : gene_species) {
                plasmidInfoExample.or().andGene_speciesEqualTo(gene_specy);
            }
        }

        /*if (!StringUtils.isEmpty(plasmidInfoDto.getGrowth_copy_number())){//copy_number
            String[] copy_numbers = plasmidInfoDto.getGrowth_copy_number().split(",");
            for ( String copy_number : copy_numbers) {
                plasmidInfoExample.or().andGrowth_copy_numberEqualTo(copy_number);
            }

        }*/

        /*if (!StringUtils.isEmpty(plasmidInfoDto.getGrowth_temperature())){//temperature
            String[] temperatures = plasmidInfoDto.getGrowth_temperature().split(",");
            for ( String temperature : temperatures) {
                plasmidInfoExample.or().andGrowth_temperatureEqualTo(temperature);
            }
        }*/

        //advanced搜索 用and like


        //分页
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        List<PlasmidInfo> plasmidInfos = plasmidInfoMapper.selectByExample(plasmidInfoExample);
        PageInfo<PlasmidInfo> pagelist = new PageInfo<PlasmidInfo>(plasmidInfos);

        return pagelist;
    }

    @Override
    public Map<String, List<PlasmidFilterDto>> getFilterConditions() throws NoSuchMethodException {

        Map<String,List<PlasmidFilterDto>> result = new LinkedHashMap<>();//不是other的情况 [name,[{value1,null},{value2,null}......]]
        //是other的情况：[name,[{value1,list},{value2,list}......]]
        Map<String,List<String>> temp = new LinkedHashMap<>();
        List<PlasmidFilterDto> plasmidFilterDtoList = new ArrayList<>();
        List<String> columnNames = SpringUtil.getAllFieldNamesInClass(PlasmidDict.class);

        for (String columnName:columnNames) {
            List<String> columnValues = plasmidDictMapper.selectPlasmidDictByColumn(columnName);
            temp.put(columnName,columnValues);
        }

        for ( String columnName:columnNames) {
            if (columnName.contains("other")){
                continue;
            }
            List<String> columnValues = temp.get(columnName);

            for (String str : columnValues ) {
                if ("other".equals(str)){
                    String key = columnName + "_other";
                    plasmidFilterDtoList.add(new PlasmidFilterDto(str,temp.get(key)));
                    continue;
                }
                plasmidFilterDtoList.add(new PlasmidFilterDto(str,null));
            }
            result.put(columnName,plasmidFilterDtoList);

            plasmidFilterDtoList = new ArrayList<>();

            //result.put(columnName,columnValues);
        }



        return result;
    }

    @Override
    public PlasmidInfoDto getPlasmidInfoDetail(Integer id) {

        //返回结果
        PlasmidInfoDto pd = new PlasmidInfoDto();

        //查找详情
        PlasmidInfo plasmidInfo =  plasmidInfoMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(plasmidInfo,pd);
        //找到goods
       /* Integer goodsId = plasmidInfo.getGoods_id();
        Goods goods = goodsService.getGoodsById(goodsId);*/
        Goods goods = goodsService.getGoodsByProductId(id);
        pd.setGoods_id(goods==null?null:goods.getId());

        //附件
       String attachmentUrls = pd.getAtt_urls();
        List<String> result = new ArrayList<>();
        if (!StringUtils.isEmpty(attachmentUrls)){
            String[] urls = attachmentUrls.split(",");
            for (int i = 0; i < urls.length; i++) {
                result.add( "/" + urls[i]);
            }
            pd.setAttachmentUrls(result);
        }
        return pd;
    }

    @Override
    public void updadatePlasmidInfo(PlasmidInfoDto plasmidInfoDto) {
        Integer id = plasmidInfoDto.getId();
        PlasmidInfo plasmidInfo = plasmidInfoMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(plasmidInfoDto,plasmidInfo);

        plasmidInfoMapper.updateByPrimaryKey(plasmidInfo);
    }

    @Override
    public PageInfo<PlasmidInfo> getPlasmidInfoPage(PlasmidInfoDto plasmidInfoDto, PageDto pageDto) {
        if (!StringUtils.isEmpty(plasmidInfoDto.getPlasmid_type())){//plasmidtype
            String[] plasmid_type_array = plasmidInfoDto.getPlasmid_type().split(",");
            plasmidInfoDto.setPlasmid_type_array(plasmid_type_array);
        }

        if (!StringUtils.isEmpty(plasmidInfoDto.getGrowth_bacterial_resistance())){//bacterial_resistance
            String[] bacterialResistances = plasmidInfoDto.getGrowth_bacterial_resistance().split(",");
            plasmidInfoDto.setGrowth_bacterial_resistance_array(bacterialResistances);
        }

        if (!StringUtils.isEmpty(plasmidInfoDto.getVector_type())){//selection_mark
            String[] plasmid_descriptions = plasmidInfoDto.getVector_type().split(",");
            plasmidInfoDto.setVector_type_array(plasmid_descriptions);
        }

        if (!StringUtils.isEmpty(plasmidInfoDto.getGene_species())){//Gene_species
            String[] gene_species = plasmidInfoDto.getGene_species().split(",");
            plasmidInfoDto.setGene_species_array(gene_species);
        }

        //分页
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        List<PlasmidInfo> plasmidInfos = plasmidInfoMapper.searchPlasmidInfos(plasmidInfoDto);
        PageInfo<PlasmidInfo> pagelist = new PageInfo<PlasmidInfo>(plasmidInfos);

        return pagelist;
    }

    @Override
    public void deletePlasmidByIds(List<Integer> ids) {
        PlasmidInfoExample plasmidInfoExample = new PlasmidInfoExample();
        PlasmidInfoExample.Criteria criteria = plasmidInfoExample.createCriteria();
        criteria.andIdIn(ids);
        plasmidInfoMapper.deleteByExample(plasmidInfoExample);
    }

    @Override
    public int addPlasmidInfo(PlasmidInfoDto plasmidInfoDto) {
        plasmidInfoMapper.insert(plasmidInfoDto);
        return plasmidInfoDto.getId();
    }

    @Override
    public List<PlasmidInfo> getPlasmidInfoByIdentifications(List<String> identifications) {
        PlasmidInfoExample plasmidInfoExample = new PlasmidInfoExample();
        PlasmidInfoExample.Criteria criteria = plasmidInfoExample.createCriteria();
        criteria.andPlasmid_identificationIn(identifications);
        return plasmidInfoMapper.selectByExample(plasmidInfoExample);
    }

}
