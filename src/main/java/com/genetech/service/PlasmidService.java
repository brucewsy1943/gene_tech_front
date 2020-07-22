package com.genetech.service;

import com.genetech.bean.PlasmidInfo;
import com.genetech.bean.dto.PageDto;
import com.genetech.bean.dto.PlasmidFilterDto;
import com.genetech.bean.dto.PlasmidInfoDto;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/12/11.
 */
public interface PlasmidService {
   public PageInfo<PlasmidInfo> getPlasmidList(PlasmidInfoDto plasmidInfoDto, PageDto pageDto);

   public Map<String, List<PlasmidFilterDto>> getFilterConditions() throws NoSuchMethodException;

   public PlasmidInfoDto getPlasmidInfoDetail(Integer id);

   public void updadatePlasmidInfo(PlasmidInfoDto plasmidInfoDto);

   public PageInfo<PlasmidInfo> getPlasmidInfoPage(PlasmidInfoDto plasmidInfoDto, PageDto pageDto);

   public void deletePlasmidByIds(List<Integer> ids);

   public int addPlasmidInfo(PlasmidInfoDto plasmidInfoDto);

   public List<PlasmidInfo> getPlasmidInfoByIdentifications(List<String> identifications);
}
