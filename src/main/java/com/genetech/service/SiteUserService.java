package com.genetech.service;

import com.genetech.bean.SiteUser;
import com.genetech.bean.dto.SiteUserDto;

/**
 * Created by Administrator on 2019/12/10.
 */
public interface SiteUserService {

    //注册用户
    public SiteUser registerSiteUser(SiteUserDto siteUserDto);

    //用户登录
    public SiteUser getSiteUserByUserName(String userName);

    //根据ID查询用户详情
    public SiteUser getSiteUserById(Integer id);

    //PI更新
    public void piCertificate(Integer userId, SiteUserDto siteUserDto);


    //用户更新
    public void updateSiteUser(SiteUser siteUser,SiteUserDto siteUserDto);

    //重置密码
    public void resetPassword(SiteUserDto siteUserDto);

}
