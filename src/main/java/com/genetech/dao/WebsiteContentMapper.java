package com.genetech.dao;

import com.genetech.bean.dto.WebsiteContentDto;
import com.genetech.bean.WebsiteContent;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface WebsiteContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebsiteContent record);

    WebsiteContent selectByPrimaryKey(Integer id);

    List<WebsiteContent> selectAll();

    int updateByPrimaryKey(WebsiteContent record);
    
    List<WebsiteContentDto> contentAnalysis(@Param("startDate")String startDate, @Param("endDate")String endDate);
    
    List<WebsiteContentDto> columnAnalysis(@Param("startDate")String startDate,@Param("endDate")String endDate);
}