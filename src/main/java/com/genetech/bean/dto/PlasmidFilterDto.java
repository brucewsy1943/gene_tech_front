package com.genetech.bean.dto;

import java.util.List;

/**
 * Created by Administrator on 2019/12/28.
 */
public class PlasmidFilterDto {

    private String name;
    private List<String> values;

    public PlasmidFilterDto() {
    }

    public PlasmidFilterDto(String name, List<String> values) {
        this.name = name;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
