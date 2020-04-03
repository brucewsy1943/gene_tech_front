package com.genetech.service.impl;

import java.util.List;

import com.genetech.bean.Role;
import com.genetech.bean.dto.PermissionDto;
import com.genetech.bean.dto.RoleDto;
import com.genetech.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.genetech.dao.RoleMapper;

@Service
public class RoleServiceImpl  implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	

	@Override
	public List<Role> selectAll() {
		
		return roleMapper.selectAll();
	}

	@Transactional
	@Override
	public int insert(Role record) {
		Integer n = roleMapper.insert(record);
		return n;
	}

	@Transactional
	@Override
	public int deleteByPrimaryKey(Integer id) {
	     int n = roleMapper.deleteByPrimaryKey(id);
		return n;
	}

	@Transactional
	@Override
	public int updateByPrimaryKey(Role record) {
		
		return roleMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<PermissionDto> getPermissions(Integer roleId, Integer style) {
		
		return roleMapper.getPermissions(roleId,style);
	}

	@Override
	public int selectIdByName(String roleName) {
		
		return roleMapper.selectIdByName(roleName);
	}

	@Override
	public RoleDto selectByPrimaryKey(Integer id) {
		
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PermissionDto> getPermissionsNoStyle(Integer roleId) {
		
		return roleMapper.getPermissionsNoStyle(roleId);
	}

	@Override
	public List<Role> fuzzySearch(String keyword) {
		
		return roleMapper.fuzzySearch(keyword);
	}

	

}
