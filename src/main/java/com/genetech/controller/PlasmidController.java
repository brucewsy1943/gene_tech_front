package com.genetech.controller;

import com.genetech.bean.PlasmidInfo;
import com.genetech.bean.ResponseBean;
import com.genetech.bean.dto.PageDto;
import com.genetech.bean.dto.PlasmidInfoDto;
import com.genetech.service.PlasmidService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Administrator on 2019/12/11.
 */
@RestController
@RequestMapping("/plasmid")
public class PlasmidController {

    @Autowired
    private PlasmidService plasmidService;

    @ApiOperation(value="质粒查询",notes="质粒查询")
    @ApiImplicitParam(name = "plasmid", value = "用户实体", required = true, dataType = "PlasmidInfoDto")
    @PostMapping("/list")
    public ResponseBean getPlasmidList( PlasmidInfoDto plasmidInfoDto,PageDto pageDto){

       // PageInfo<PlasmidInfo> pageList=plasmidService.getPlasmidList(plasmidInfoDto, pageDto);
        PageInfo<PlasmidInfo> pageList=plasmidService.getPlasmidInfoPage(plasmidInfoDto, pageDto);
        return new ResponseBean(true, 200, "success！", pageList);
    }

    @ApiOperation(value="质粒查询",notes="质粒查询")
    @ApiImplicitParam(name = "plasmid", value = "用户实体", required = true, dataType = "PlasmidInfoDto")
    @GetMapping("/conditions")
    public ResponseBean getFilterConditions() throws NoSuchMethodException {

        return new ResponseBean(true, 200, "success！", plasmidService.getFilterConditions());
    }

    @ApiOperation(value="质粒查询",notes="质粒查询")
    @ApiImplicitParam(name = "plasmid", value = "用户实体", required = true, dataType = "PlasmidInfoDto")
    @GetMapping("/detail")
    public ResponseBean plasmidDtail(Integer id){
        if (id == null){
            return new ResponseBean(false,500, "质粒id不能为空！", null);
        }

        PlasmidInfoDto plasmidInfoDto = plasmidService.getPlasmidInfoDetail(id);
        if (plasmidInfoDto == null){
            return new ResponseBean(false,500, "质粒不存在！", plasmidInfoDto);
        }
        return new ResponseBean(true, 200, "success！", plasmidInfoDto);
    }
}
