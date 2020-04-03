package com.genetech.service.impl;

import java.util.List;

import com.genetech.bean.Website;
import com.genetech.bean.dto.ContentPubnish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.genetech.bean.dto.WebsiteDto;
import com.genetech.bean.dto.WebsiteEcharts;
import com.genetech.dao.WebsiteMapper;
import com.genetech.service.WebsiteService;
@Service
public class WebsiteServiceImpl implements WebsiteService {
	
	@Autowired
	private WebsiteMapper websiteMapper;

	@Transactional
	@Override
	public int deleteByPrimaryKey(Integer id) {
		
		return websiteMapper.deleteByPrimaryKey(id);
	}

	@Transactional
	@Override
	public int insert(Website record) {
		
		return websiteMapper.insert(record);
	}

	
	@Override
	public Website selectByPrimaryKey(Integer id) {
		
		return websiteMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Website> selectAll() {
		
		return websiteMapper.selectAll();
	}

	@Transactional
	@Override
	public int updateByPrimaryKey(Website record) {
		
		return websiteMapper.updateByPrimaryKey(record);
	}

	@Override
	public Website selectDateByIp(String ip) {
	
		return websiteMapper.selectDateByIp(ip);
	}

	@Override
	public WebsiteDto comprehensiveAnalysis() {
		
		return websiteMapper.comprehensiveAnalysis();
	}

	@Override
	public List<WebsiteEcharts> echarts(String startDate, String endDate) {
		
		return websiteMapper.echarts(startDate, endDate);
	}

	@Override
	public List<ContentPubnish> contentPubnish(String startDate, String endDate) {
		
		return websiteMapper.contentPubnish(startDate,endDate);
	}

	@Override
	public List<ContentPubnish> contentSource(String startDate,String endDate) {
		
		return websiteMapper.contentSource(startDate,endDate);
	}

}
