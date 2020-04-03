package com.genetech.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.genetech.bean.User_Role;
import com.genetech.dao.User_RoleMapper;
import com.genetech.service.User_RoleService;

@Service
public class User_RoleServiceImpl  implements User_RoleService{

	@Autowired
	private User_RoleMapper user_RoleMapper;
	
	
	@Override
	public List<User_Role> selectAll() {
		
		return user_RoleMapper.selectAll();
	}

	@Transactional
	@Override
	public int updateByPrimaryKey(User_Role record) {
		
		return user_RoleMapper.updateByPrimaryKey(record);
	}

	@Transactional
	@Override
	public int insert(User_Role record) {
		
		return user_RoleMapper.insert(record);
	}

	@Transactional
	@Override
	public int deleteByPrimaryKey(Integer id) {
		
		return user_RoleMapper.deleteByPrimaryKey(id);
	}

	@Transactional
	@Override
	public int deleteByUserId(Integer userId) {
		
		return user_RoleMapper.deleteByUserId(userId);
	}

	
}
