package com.genetech.service;

import java.util.List;

import com.genetech.bean.User_Role;


public interface User_RoleService {
	
	
	List<User_Role> selectAll();

	int updateByPrimaryKey(User_Role record);
	
	int insert(User_Role record);
	
	int deleteByPrimaryKey(Integer id);
	
	int deleteByUserId(Integer userId);
	
}
