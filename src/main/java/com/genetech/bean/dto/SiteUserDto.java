package com.genetech.bean.dto;

import com.genetech.bean.SiteUser;

import java.util.Date;

/**
 * Created by Administrator on 2019/12/10.
 */
public class SiteUserDto extends SiteUser{
    private String verifyCode;//verifyCode: 4fea
    private String confirmPassword;

    public SiteUserDto() {
    }

    public SiteUserDto(Integer id, String loginName, String userName, String password, String email, String telephone, Date lastLoginTime, Date createdTime, Date modifiedTime, Integer roleId, Integer orderId, String userSource, Integer isActive, String remark, String institute, String area, String lab_leader, Integer organization_type, String pi_name, String pi_phone, String real_name, String institute_address) {
        super(id, loginName, userName, password, email, telephone, lastLoginTime, createdTime, modifiedTime, roleId, orderId, userSource, isActive, remark, institute, area, lab_leader, organization_type, pi_name, pi_phone, real_name, institute_address);
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
