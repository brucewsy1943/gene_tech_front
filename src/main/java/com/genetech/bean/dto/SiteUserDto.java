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
