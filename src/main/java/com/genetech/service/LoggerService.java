package com.genetech.service;

import com.github.pagehelper.PageInfo;
import com.genetech.bean.Logger;
import com.genetech.bean.dto.LoggerDto;
import com.genetech.bean.dto.PageDto;

public interface LoggerService {
	int deleteByPrimaryKey(Integer id);

    int insert(Logger record);

    Logger selectByPrimaryKey(Integer id);

    PageInfo<LoggerDto>   selectAll(Integer userId,String keyword,PageDto pageDto);

    int updateByPrimaryKey(Logger record);
}
