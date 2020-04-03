package com.genetech.dao;

import com.genetech.bean.dto.PermissionDto;
import com.genetech.bean.Permission;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface PermissionMapper {
   
    int deleteByPrimaryKey(Integer id);

    int deleteByPId(Integer pId);
    
    int insert(Permission record);

    
    Permission selectByPrimaryKey(Integer id);

    PermissionDto selectById(Integer id);
    
    Permission selectByNavCode(String  navCode);
    
    List<PermissionDto> selectAll();

    List<PermissionDto> selectSonPermissions(Integer id);
    
    int updateByPrimaryKey(Permission record);
}