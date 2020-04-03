package com.genetech.service;

import java.util.List;

import com.genetech.bean.dto.PermissionDto;
import com.genetech.bean.Permission;

public interface PermissionService {
	
	List<PermissionDto> selectAll();

	int updateByPrimaryKey(Permission record);
	
	int insert(Permission record);
	
	int deleteByPrimaryKey(Integer id);
	
	int deleteByPId(Integer pId);
	
	PermissionDto selectById(Integer id);
	  
	List<PermissionDto> selectSonPermissions(Integer id);
	
	Permission selectByNavCode(String  navCode);
}
