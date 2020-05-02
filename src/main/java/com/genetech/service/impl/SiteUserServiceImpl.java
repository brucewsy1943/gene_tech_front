package com.genetech.service.impl;

import com.genetech.bean.SiteUser;
import com.genetech.bean.SiteUserExample;
import com.genetech.bean.dto.SiteUserDto;
import com.genetech.dao.SiteUserMapper;
import com.genetech.service.SiteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * Created by Administrator on 2019/12/10.
 */
@Service("siteUserService")
public class SiteUserServiceImpl implements SiteUserService {

    @Autowired
    private SiteUserMapper siteUserMapper;

    @Transactional
    @Override
    public SiteUser registerSiteUser(SiteUserDto siteUserDto) {
        siteUserDto.setIsActive(3);//否通过PI审核 0：未通过 1：审核中 2：通过 3：未验证
        siteUserMapper.insert(siteUserDto);
        return null;
    }



    @Override
    public SiteUser getSiteUserByUserName(String userName) {
        //根据用户名，查找出该用户
        SiteUserExample siteUserExample = new SiteUserExample();
        SiteUserExample.Criteria criteria = siteUserExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<SiteUser> siteUsers = siteUserMapper.selectByExample(siteUserExample);
        if (!CollectionUtils.isEmpty(siteUsers)){
            return siteUsers.get(0);
        }
        return null;
    }

    @Override
    public SiteUser getSiteUserById(Integer id) {
        return siteUserMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public void piCertificate(Integer userId, SiteUserDto siteUserDto) {
        SiteUser siteUser = siteUserMapper.selectByPrimaryKey(userId);

        siteUser.setReal_name(siteUserDto.getReal_name());
        siteUser.setTelephone(siteUserDto.getTelephone());
        siteUser.setEmail(siteUserDto.getEmail());
        siteUser.setInstitute(siteUserDto.getInstitute());
        siteUser.setPi_name(siteUserDto.getPi_name());
        //siteUser.setPi_phone(siteUserDto.getPi_phone());
        siteUser.setPi_email(siteUserDto.getPi_email());
        siteUser.setInstitute_address(siteUserDto.getInstitute_address());
        siteUser.setIsActive(1);//是否通过PI审核 0：未通过 1：审核中 2：通过 3：未验证
        siteUserMapper.updateByPrimaryKey(siteUser);

    }

    @Override
    public void updateSiteUser(SiteUser siteUser,SiteUserDto siteUserDto) {
        if (siteUserDto!=null){
            siteUser.setUserName(siteUserDto.getUserName());
            siteUser.setPassword(siteUserDto.getPassword());
            siteUser.setArea(siteUserDto.getArea());
            siteUser.setInstitute(siteUserDto.getInstitute());
            siteUser.setOrganization_type(siteUserDto.getOrganization_type());
        }

        siteUserMapper.updateByPrimaryKey(siteUser);

    }
}
