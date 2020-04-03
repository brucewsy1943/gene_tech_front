package com.genetech.dao;

import com.genetech.bean.Column;
import com.genetech.bean.dto.ColumnDto;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ColumnMapper {
 
    int deleteByPrimaryKey(Integer id);

   
    int insert(Column record);

    
    ColumnDto selectByPrimaryKey(Integer id);

    
    List<Column> selectAll();

    
    int updateByPrimaryKey(Column record);
    
    
    List<Integer> selectSonId(Integer id);
    
    int selectParentId(Integer id);
    
    List<Column> findSonColumn(Integer id);
    
    
    List<Column> fuzzySearch(String  keyword);
    
    
    
    
}