package com.genetech.service;

import java.util.List;

import com.genetech.bean.Website;
import com.genetech.bean.dto.ContentPubnish;
import com.genetech.bean.dto.WebsiteDto;
import com.genetech.bean.dto.WebsiteEcharts;

public interface WebsiteService {
  
	int deleteByPrimaryKey(Integer id);

    int insert(Website record);

    Website selectByPrimaryKey(Integer id);

    List<Website> selectAll();

    int updateByPrimaryKey(Website record);
    
    Website selectDateByIp(String ip);
    
    //网站综合分析
    WebsiteDto comprehensiveAnalysis();
    
    //ip数和访问量图表显示
    List<WebsiteEcharts> echarts (String startDate, String endDate);
    
    //内容发布统计
    List<ContentPubnish> contentPubnish(String startDate, String endDate);
       
    //内容发布统计(按消息来源统计)
    List<ContentPubnish> contentSource(String startDate,String endDate);
}
