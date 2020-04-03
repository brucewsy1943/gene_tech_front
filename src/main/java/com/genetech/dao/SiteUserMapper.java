package com.genetech.dao;

import com.genetech.bean.SiteUser;
import com.genetech.bean.SiteUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SiteUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_site_user
     *
     * @mbg.generated Fri Dec 27 15:21:11 CST 2019
     */
    long countByExample(SiteUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_site_user
     *
     * @mbg.generated Fri Dec 27 15:21:11 CST 2019
     */
    int deleteByExample(SiteUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_site_user
     *
     * @mbg.generated Fri Dec 27 15:21:11 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_site_user
     *
     * @mbg.generated Fri Dec 27 15:21:11 CST 2019
     */
    int insert(SiteUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_site_user
     *
     * @mbg.generated Fri Dec 27 15:21:11 CST 2019
     */
    int insertSelective(SiteUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_site_user
     *
     * @mbg.generated Fri Dec 27 15:21:11 CST 2019
     */
    List<SiteUser> selectByExample(SiteUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_site_user
     *
     * @mbg.generated Fri Dec 27 15:21:11 CST 2019
     */
    SiteUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_site_user
     *
     * @mbg.generated Fri Dec 27 15:21:11 CST 2019
     */
    int updateByExampleSelective(@Param("record") SiteUser record, @Param("example") SiteUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_site_user
     *
     * @mbg.generated Fri Dec 27 15:21:11 CST 2019
     */
    int updateByExample(@Param("record") SiteUser record, @Param("example") SiteUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_site_user
     *
     * @mbg.generated Fri Dec 27 15:21:11 CST 2019
     */
    int updateByPrimaryKeySelective(SiteUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_site_user
     *
     * @mbg.generated Fri Dec 27 15:21:11 CST 2019
     */
    int updateByPrimaryKey(SiteUser record);
}