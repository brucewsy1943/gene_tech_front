package com.genetech.service;

import java.util.List;

import com.genetech.bean.Role;
import com.genetech.bean.dto.UserDto;
import com.genetech.bean.User;

public interface UserService {

	int deleteByPrimaryKey(Integer id);


    int insert(User record);

   UserDto selectByPrimaryKey(Integer id);

  
    List<UserDto> selectAll();
    
    
   User selectByName(String username);
    
    List<Role> getRoles(String username);

    
    int updateByPrimaryKey(User record);
    
    List<UserDto> fuzzySearch(String keyword);
    
    List<User> checkName(String loginname);
    
}
