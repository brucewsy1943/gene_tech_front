package com.genetech.dao;

import com.genetech.bean.Logger;
import com.genetech.bean.dto.LoggerDto;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface LoggerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Logger record);

    Logger selectByPrimaryKey(Integer id);

    List<LoggerDto> selectAll(@Param("userId") Integer userId,@Param("keyword") String keyword);

    int updateByPrimaryKey(Logger record);
}