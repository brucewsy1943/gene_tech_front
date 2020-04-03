package com.genetech.bean.dto;

import com.genetech.bean.Role;

public class RoleDto extends Role{
     
	 private String permissions;

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
}
