package com.genetech;

import com.genetech.bean.PlasmidInfo;
import com.genetech.bean.PlasmidInfoExample;
import com.genetech.bean.dto.GoodsDto;
import com.genetech.bean.dto.PageDto;
import com.genetech.bean.dto.PlasmidInfoDto;
import com.genetech.dao.GoodsMapper;
import com.genetech.dao.PlasmidInfoMapper;
import com.genetech.service.GoodsService;
import com.genetech.service.PlasmidService;
import com.genetech.utils.ExcelReaderUtil;
import com.genetech.utils.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/12/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlasmidTest {
    @Autowired
    private PlasmidService plasmidService;

    @Autowired
    private PlasmidInfoMapper plasmidInfoMapper;

    @Autowired
    private GoodsService goodsService;

    private final static String filepath = "D:/work/质粒平台/数据库/2020-10-27/20201027-数据上传-修改.xlsx";//每次记得修改一下日期就行

    private final static String atalasDirPath = "D:/uploadFile/plasmid/files/atlas";
    private final static String sequeceDirPath = "D:/uploadFile/plasmid/files/sequence";
    //private final static String sequeceDirPath = "\\\\192.168.1.251/rdcc/Public Data/CCRB-质粒库/5-数据库/测序上传/20200918";
    //private static String picDirPath = "D:/uploadFile/plasmid/images";
    private final static String atlasFolderName = "files/atlas/";
    private final static String sequeceFolderName = "files/sequence/";
    private  static List<String> fileNameListForAtlas = FileUtils.getFilesInFolder(atalasDirPath);
    private  static List<String> fileNameListForSequence = FileUtils.getFilesInFolder(sequeceDirPath);
    //新增质粒
    @Test
    public void addPlasmid(){
        //读取excel文件
        ExcelReaderUtil<PlasmidInfo> excelReaderUtil = new ExcelReaderUtil<>();

        List<PlasmidInfo> targetList = excelReaderUtil.readExcel(filepath,PlasmidInfo.class);
        List<String> idetifiers = getAllIdentifiers();
        for (PlasmidInfo plasmidInfo :targetList) {
            PlasmidInfoDto plasmidInfoDto = new PlasmidInfoDto();
            BeanUtils.copyProperties(plasmidInfo,plasmidInfoDto);
            plasmidInfoDto.setAdd_time(new Date());
            /**
             * id, price, name, attachment_urls, status, product_code, stock, goods_code, product_id, introduction
             */
            GoodsDto goodsDto = new GoodsDto(null,
                    new BigDecimal(300),//price
                    plasmidInfo.getPlasmid_name(),//name
                    null,//attachment_urls
                    1,//status是否上架
                    plasmidInfo.getPlasmid_identification(),//product_code
                    123,//库存随便写
                    null,//goods_code
                    null,//product_id
                    plasmidInfo.getPlasmid_description()//简介
            );
            if(plasmidInfoDto.getPlasmid_identification() == null || "".equals(plasmidInfoDto.getGene_identification())){
                continue;
            }
            int plasmidInfoId = plasmidService.addPlasmidInfo(plasmidInfoDto);
            goodsDto.setProduct_id(plasmidInfoId);
            goodsService.addGoods(goodsDto);
        }
    }

    //更新质粒
    @Test
    public void updatePlasmids(){
        //读取excel文件----是需要修改的文件们
        ExcelReaderUtil<PlasmidInfo> excelReaderUtil = new ExcelReaderUtil<>();

        List<PlasmidInfo> targetList = excelReaderUtil.readExcel(filepath,PlasmidInfo.class);

        for (int i = 0; i < targetList.size(); i++) {
            PlasmidInfo source = targetList.get(i);
            PlasmidInfoExample plasmidInfoExample = new PlasmidInfoExample();
            PlasmidInfoExample.Criteria criteria = plasmidInfoExample.createCriteria();
            criteria.andPlasmid_identificationEqualTo(source.getPlasmid_identification());
            List<PlasmidInfo> list = plasmidInfoMapper.selectByExample(plasmidInfoExample);
            if(!CollectionUtils.isEmpty(list)){
                PlasmidInfo target = plasmidInfoMapper.selectByExample(plasmidInfoExample).get(0);
                Integer id = target.getId();
                source.setAtt_urls(target.getAtt_urls());
                source.setPlasmid_sequence(target.getPlasmid_sequence());
                BeanUtils.copyProperties(source,target);
                target.setId(id);
                //cellInfo.setAdd_time(new Date());
                plasmidInfoMapper.updateByPrimaryKeyWithBLOBs(target);
            }
        }
    }

    //新增图谱
    @Test
    public void addAtlas(){
        List<String> identifiers = new ArrayList<>();
        for (String filename :fileNameListForAtlas) {
            if (filename!=null && !"".equals(filename)){
                identifiers.add(filename.split("\\.")[0].split(" ")[0]);//具体用什么标识，再说
            }
        }
        List<PlasmidInfo> list = plasmidService.getPlasmidInfoByIdentifications(identifiers);
        for (int i = 0; i < list.size(); i++) {
            PlasmidInfo plasmidInfo = list.get(i);
            for (int j = 0; j < fileNameListForAtlas.size(); j++) {
                String fileName = fileNameListForAtlas.get(j).split("\\.")[0].split(" ")[0];
                if(fileName.equals(plasmidInfo.getPlasmid_identification())){
                    String attachUrls = plasmidInfo.getAtt_urls()==null?"":plasmidInfo.getAtt_urls();
                    //原来没有，直接添加
                    if("".equals(attachUrls)){
                        plasmidInfo.setAtt_urls(atlasFolderName+fileNameListForAtlas.get(j));
                        plasmidInfoMapper.updateByPrimaryKey(plasmidInfo);
                        continue;//可能一个质粒有多个附件，所以还要继续循环
                    }
                    //原来有附件的话，原来的保留且添加新的
                    String[] originUrls = attachUrls.split(",");
                    boolean flag = true;
                    for (String originUrl :originUrls) {
                        if((atlasFolderName + fileNameListForAtlas.get(j)).equals(originUrl)){//只要新的和以前有一个是重叠的，就不添加
                            flag = false;
                            break;
                        }
                    }
                    //否则把附件url加入
                    if(flag){
                        plasmidInfo.setAtt_urls(attachUrls+","+(atlasFolderName+fileNameListForAtlas.get(j)));
                        plasmidInfoMapper.updateByPrimaryKey(plasmidInfo);
                    }
                }
            }
        }
    }

    //新增测序文件
    @Test
    public void addSequences(){
        List<String> identifiers = new ArrayList<>();
        for (String filename :fileNameListForSequence) {
            if (filename!=null && !"".equals(filename)){
                identifiers.add(filename.split("\\.")[0].split(" ")[0]);//具体用什么标识，再说
            }
        }
        List<PlasmidInfo> list = plasmidService.getPlasmidInfoByIdentifications(identifiers);
        for (int i = 0; i < list.size(); i++) {
            PlasmidInfo plasmidInfo = list.get(i);
            for (int j = 0; j < fileNameListForSequence.size(); j++) {
                String fileName = fileNameListForSequence.get(j).split("\\.")[0];

                String identifier = fileName.split(" ")[0];
                if(identifier.equals(plasmidInfo.getPlasmid_identification())){
                    String sequenceUrls = plasmidInfo.getPlasmid_sequence()==null?"":plasmidInfo.getPlasmid_sequence();
                    //原来没有，直接添加
                    if("".equals(sequenceUrls)){
                        plasmidInfo.setPlasmid_sequence(sequeceFolderName+fileNameListForSequence.get(j));
                        plasmidInfoMapper.updateByPrimaryKey(plasmidInfo);
                        continue;//可能一个质粒有多个附件，所以还要继续循环
                    }
                    //原来有附件的话，原来的保留且添加新的
                    String[] originUrls = sequenceUrls.split(",");
                    boolean flag = true;
                    for (String originUrl :originUrls) {
                        String url = sequeceFolderName+fileNameListForSequence.get(j);//原先的文件名是带路径的
                        if(url.equals(originUrl)){//只要新的和以前有一个是重叠的，就不添加
                            flag = false;
                            break;
                        }
                    }
                    //否则把附件url加入
                    if(flag){
                        plasmidInfo.setPlasmid_sequence(sequenceUrls+","+(sequeceFolderName+fileNameListForSequence.get(j)));
                        plasmidInfoMapper.updateByPrimaryKey(plasmidInfo);
                    }

                }
            }
        }
    }

    private List<String> getAllIdentifiers(){
        List<PlasmidInfo> plasmidInfoList = plasmidInfoMapper.selectByExample(new PlasmidInfoExample());
        List<String> identifiers = new ArrayList<>();
        for (PlasmidInfo plasmidInfo :plasmidInfoList) {
            identifiers.add(plasmidInfo.getPlasmid_identification());
        }
        return identifiers;
    }

}
