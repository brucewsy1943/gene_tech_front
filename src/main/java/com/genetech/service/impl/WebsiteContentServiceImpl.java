package com.genetech.service.impl;

import java.util.List;

import com.genetech.bean.dto.WebsiteContentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.genetech.bean.WebsiteContent;
import com.genetech.dao.WebsiteContentMapper;
import com.genetech.service.WebsiteContentService;
@Service
public class WebsiteContentServiceImpl  implements WebsiteContentService{
	
	@Autowired
	private WebsiteContentMapper websiteContentMapper;

	@Transactional
	@Override
	public int deleteByPrimaryKey(Integer id) {
		
		return websiteContentMapper.deleteByPrimaryKey(id);
	}

	@Transactional
	@Override
	public int insert(WebsiteContent record) {
		
		return websiteContentMapper.insert(record);
	}

	@Override
	public WebsiteContent selectByPrimaryKey(Integer id) {
		
		return websiteContentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<WebsiteContent> selectAll() {
		
		return websiteContentMapper.selectAll();
	}

	@Transactional
	@Override
	public int updateByPrimaryKey(WebsiteContent record) {
		
		return websiteContentMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<WebsiteContentDto> contentAnalysis(String startDate, String endDate) {
		
		return websiteContentMapper.contentAnalysis(startDate,endDate);
	}

	@Override
	public List<WebsiteContentDto> columnAnalysis(String startDate,String endDate) {
		
		return websiteContentMapper.columnAnalysis(startDate,endDate);
	}

}
