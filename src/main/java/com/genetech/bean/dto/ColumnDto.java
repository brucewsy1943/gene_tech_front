package com.genetech.bean.dto;

import com.genetech.bean.Column;

public class ColumnDto extends Column{
     private  String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}
