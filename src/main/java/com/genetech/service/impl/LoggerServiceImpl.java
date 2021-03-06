package com.genetech.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.genetech.bean.Logger;
import com.genetech.bean.dto.LoggerDto;
import com.genetech.bean.dto.PageDto;
import com.genetech.dao.LoggerMapper;
import com.genetech.service.LoggerService;
@Service
public class LoggerServiceImpl  implements LoggerService{
    
	 @Autowired
	 private LoggerMapper  loggerMapper;
	 
	 @Transactional
	@Override
	public int deleteByPrimaryKey(Integer id) {
		
		return loggerMapper.deleteByPrimaryKey(id);
	}

	 @Transactional
	@Override
	public int insert(Logger record) {
		
		return loggerMapper.insert(record);
	}

	@Override
	public Logger selectByPrimaryKey(Integer id) {
		
		return loggerMapper.selectByPrimaryKey(id);
	}



	@Transactional
	@Override
	public int updateByPrimaryKey(Logger record) {
		
		return loggerMapper.updateByPrimaryKey(record);
	}


	@Override
	public PageInfo<LoggerDto> selectAll(Integer userId, String keyword, PageDto pageDto) {
		PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
		List<LoggerDto> loggerDtos = loggerMapper.selectAll(userId,keyword);
		PageInfo<LoggerDto> pagelist = new PageInfo<LoggerDto>(loggerDtos);
		return pagelist;
	}

}
