package com.genetech.service;

import java.util.List;

import com.genetech.bean.dto.PermissionDto;
import com.genetech.bean.Role;
import com.genetech.bean.dto.RoleDto;


public interface RoleService {
	List<PermissionDto> getPermissions(Integer roleId, Integer style);
	
	List<Role> selectAll();
	
    RoleDto selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(Role record);
	
	int insert(Role record);
	
	int deleteByPrimaryKey(Integer id);
	
	 int selectIdByName(String roleName);
	 
	 List<Role>  fuzzySearch(String keyword);
	 
	 List<PermissionDto>  getPermissionsNoStyle(Integer roleId);
}
