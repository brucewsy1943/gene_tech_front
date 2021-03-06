package com.genetech;

import com.genetech.bean.*;
import com.genetech.bean.dto.GoodsDto;
import com.genetech.bean.dto.PageDto;
import com.genetech.bean.dto.PlasmidInfoDto;
import com.genetech.dao.GoodsMapper;
import com.genetech.dao.PlasmidInfoMapper;
import com.genetech.service.GoodsService;
import com.genetech.service.PlasmidService;
import com.genetech.utils.ExcelReaderUtil;
import com.genetech.utils.FileUtils;
import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2019/12/18.
 * 导数据步骤
 * 1、导入excel
 * 2、给每个质粒添加添加时间
 * 3、给每个运行testInsertGoods
 * 4、getQueryDate的时间用来为新增数据做标识。需要设置和新增的数据一样的时间
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTest {

    @Autowired
    private PlasmidService plasmidService;

    @Autowired
    private PlasmidInfoMapper plasmidInfoMapper;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsMapper goodsMapper;

    private static String filepath = "D:/work/细胞库/数据库/数据库文件/2020-7-13.xlsx";//每次记得修改一下日期就行
    private static String attachDirPath = "D:/uploadFile/lab_attachments";
    //private static String picDirPath = "D:/uploadFile/cell/imgs";
    private final static String folderName = "lab_attachments/";
    private final static List<String> fileNames = FileUtils.getFilesInFolder(attachDirPath);

   /* private Date getQueryDate() throws ParseException {
        String today = "2020-06-21";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(today);
    }*/

    /**
     * 添加的goods条数由plasmid来决定
     * @throws ParseException
     */
   /* @Test
    public void testInsertGoods() throws ParseException {


        //附件
        //获取文件夹下的所有文件
      *//*  String filePath = "";
        fileNames = FileUtils.getFilesInFolder(filePath);*//*

        *//**
         * Integer id,
         * BigDecimal price,
         * String name,
         * String attachment_urls,
         * Integer status,
         * String product_code,
         * Integer stock,
         * String goods_code,
         * String introduction
         *//*

        PlasmidInfoExample plasmidInfoExample = new PlasmidInfoExample();
        //添加筛选条件
        PlasmidInfoExample.Criteria criteria = plasmidInfoExample.createCriteria();
        //新增就添加当天的---日期和plasmid导入数据库的表格中的日期一致
        criteria.andAdd_timeEqualTo(getQueryDate());
        List<PlasmidInfo> plasmidInfos = plasmidInfoMapper.selectByExample(plasmidInfoExample);
        for (int i = 0; i < plasmidInfos.size(); i++) {
            PlasmidInfo info = plasmidInfos.get(i);
            String goodsCode = UUID.randomUUID().toString();
            //String attachmentUrls = getAttachmentUrl(info);
            GoodsDto goodsDto = new GoodsDto(null,
                    new BigDecimal(300),//price
                    info.getPlasmid_name(),//name
                    getAttachmentUrl(info),//attachment_urls附件
                    1,//status是否上架
                    info.getPlasmid_identification(),//product_code
                    123,//库存
                    goodsCode,//商品编号
                    info.getId(),
                    info.getPlasmid_description()//简介
                    );
            int goodsId = goodsService.addGoods(goodsDto);
            PlasmidInfoDto plasmidInfoDto = new PlasmidInfoDto();

        }
        updatePlasmid();
    }

    //给每个质粒添加attach 附件（附件最终还是在质粒信息中！！！！记住！！！！虽然goods中有附件，但是逻辑换过了！全部都用质粒信息的附件！）
    @Test
    public void updatePlasmid() throws ParseException {
        PlasmidInfoExample plasmidInfoExample = new PlasmidInfoExample();
        //添加筛选条件
        PlasmidInfoExample.Criteria criteria = plasmidInfoExample.createCriteria();
        //新增就添加当天的---日期和plasmid导入数据库的表格中的日期一致
        criteria.andAdd_timeEqualTo(getQueryDate());
        List<PlasmidInfo> plasmidInfos = plasmidInfoMapper.selectByExample(plasmidInfoExample);
        for (int i = 0; i < plasmidInfos.size(); i++) {
            PlasmidInfo info = plasmidInfos.get(i);
            PlasmidInfoDto plasmidInfoDto = new PlasmidInfoDto();

            //info.setGoods_id(goodsId);
            BeanUtils.copyProperties(info, plasmidInfoDto);
            //更新plasmid
            plasmidInfoDto.setAtt_urls(getAttachmentUrl(info));
            plasmidService.updadatePlasmidInfo(plasmidInfoDto);
        }
    }

    private String getAttachmentUrl(PlasmidInfo plasmidInfo){
        String plasmidID = plasmidInfo.getPlasmid_identification();
        List<String> temp = new ArrayList<>();
        String result = "";

        for (String fileName :fileNames) {
            String[] wholeName =fileName.split("\\.");
            String name = wholeName[0];
            if (name.contains(plasmidID)){
                temp.add(fileName);
            }
        }

        if (!CollectionUtils.isEmpty(temp)){
            result =folderName + temp.toString().replace("[","").replace("]","");
        }

        return result;
    }*/

  /*  @Test
    public void testUpdatePlasmid(){
        PlasmidInfoExample plasmidInfoExample = new PlasmidInfoExample();
        List<PlasmidInfo> plasmidInfos = plasmidInfoMapper.selectByExample(plasmidInfoExample);

        GoodsExample goodsExample = new GoodsExample();
        List<Goods> goodses = goodsMapper.selectByExample(goodsExample);

        //for (PlasmidInfo plasmidInfo : plasmidInfos) {
        for (int j = 0; j < plasmidInfos.size(); j++) {
            PlasmidInfo plasmidInfo = plasmidInfos.get(j);
            for (int i = 0; i < goodses.size(); i++) {
                if (plasmidInfo.getPlasmid_identification().equals(goodses.get(i).getProduct_code()) ){
                    goodses.get(i).setProduct_id(plasmidInfo.getId());
                    goodsMapper.updateByPrimaryKey(goodses.get(i));
                    plasmidInfo.setAtt_urls(goodses.get(i).getAttachment_urls());
                    plasmidInfoMapper.updateByPrimaryKey(plasmidInfo);
                    break;
                }
            }
        }
    }*/

    /**
     * 删除质粒和相应的商品---这里是质粒
     *//*
    @Test
    public void deletePlasmidAndRelativeGoods() throws ParseException {
        PlasmidInfoExample plasmidInfoExample = new PlasmidInfoExample();
        //添加筛选条件
        PlasmidInfoExample.Criteria criteria = plasmidInfoExample.createCriteria();
        //新增就添加当天的---日期和plasmid导入数据库的表格中的日期一致
        criteria.andAdd_timeEqualTo(getQueryDate());
        List<PlasmidInfo> plasmidInfos = plasmidInfoMapper.selectByExample(plasmidInfoExample);
        List<Integer> productIds = new ArrayList<>();
        for (int i = 0; i < plasmidInfos.size(); i++) {
           productIds.add(plasmidInfos.get(i).getId());
        }
        goodsService.deleteGoodsByPruductId(productIds);

        //删质粒
        plasmidService.deletePlasmidByIds(productIds);

    }*/

}
