package com.genetech.bean.dto;

import com.genetech.bean.PlasmidInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/12/11.
 */
public class PlasmidInfoDto extends PlasmidInfo{
    private String keyword;
    private List<String> attachmentUrls;
    private String column_name1;
    private String column_value1;
    private String column_name2;
    private String column_value2;
    private String column_name3;
    private String column_value3;

    private String[] plasmid_type_array;
    private String[] growth_bacterial_resistance_array;
    private String[] gene_species_array;
    private String[] vector_type_array;
    private Integer goods_id;
    private List<String> sequenceUrls;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<String> getAttachmentUrls() {
        return attachmentUrls;
    }

    public void setAttachmentUrls(List<String> attachmentUrls) {
        this.attachmentUrls = attachmentUrls;
    }

    public String getColumn_name1() {
        return column_name1;
    }

    public void setColumn_name1(String column_name1) {
        this.column_name1 = column_name1;
    }

    public String getColumn_value1() {
        return column_value1;
    }

    public void setColumn_value1(String column_value1) {
        this.column_value1 = column_value1;
    }

    public String getColumn_name2() {
        return column_name2;
    }

    public void setColumn_name2(String column_name2) {
        this.column_name2 = column_name2;
    }

    public String getColumn_value2() {
        return column_value2;
    }

    public void setColumn_value2(String column_value2) {
        this.column_value2 = column_value2;
    }

    public String getColumn_name3() {
        return column_name3;
    }

    public void setColumn_name3(String column_name3) {
        this.column_name3 = column_name3;
    }

    public String getColumn_value3() {
        return column_value3;
    }

    public void setColumn_value3(String column_value3) {
        this.column_value3 = column_value3;
    }

    public String[] getPlasmid_type_array() {
        return plasmid_type_array;
    }

    public void setPlasmid_type_array(String[] plasmid_type_array) {
        this.plasmid_type_array = plasmid_type_array;
    }

    public String[] getGrowth_bacterial_resistance_array() {
        return growth_bacterial_resistance_array;
    }

    public void setGrowth_bacterial_resistance_array(String[] growth_bacterial_resistance_array) {
        this.growth_bacterial_resistance_array = growth_bacterial_resistance_array;
    }

    public String[] getGene_species_array() {
        return gene_species_array;
    }

    public void setGene_species_array(String[] gene_species_array) {
        this.gene_species_array = gene_species_array;
    }

    public String[] getVector_type_array() {
        return vector_type_array;
    }

    public void setVector_type_array(String[] vector_type_array) {
        this.vector_type_array = vector_type_array;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public List<String> getSequenceUrls() {
        return sequenceUrls;
    }

    public void setSequenceUrls(List<String> sequenceUrls) {
        this.sequenceUrls = sequenceUrls;
    }
}
