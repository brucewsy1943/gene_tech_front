package com.genetech.dao;
import com.genetech.bean.Role;
import com.genetech.bean.dto.PermissionDto;
import com.genetech.bean.dto.RoleDto;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);


    RoleDto selectByPrimaryKey(Integer id);

    List<Role> selectAll();
    
    List<Role>  fuzzySearch(String keyword);

    int updateByPrimaryKey(Role record);
    
    int selectIdByName(String roleName);
    
  //根据角色id来获取角色的所有权限
    List<PermissionDto> getPermissions(@Param("roleId") Integer roleId, @Param("style")Integer style);
    
     List<PermissionDto>  getPermissionsNoStyle(Integer roleId);
    
}