package com.genetech.controller;

import com.genetech.bean.Invoice;
import com.genetech.bean.ResponseBean;
import com.genetech.bean.SiteUser;
import com.genetech.bean.dto.InvoiceDto;
import com.genetech.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2019/12/18.
 */

@RestController
@RequestMapping("/invoice")
public class InvoiceController extends BaseController{

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/add")
    public ResponseBean addInvoice(HttpServletRequest request, InvoiceDto invoiceDto) throws Exception {
        SiteUser siteUser = getUserInfo(request);
        if (StringUtils.isEmpty(invoiceDto.getTitle())){
            return new ResponseBean(false, 500, "抬头不能为空！",null);
        }

        if (StringUtils.isEmpty(invoiceDto.getTaxpayer_number())){
            return new ResponseBean(false, 500, "纳税人识别号不能为空！",null);
        }

        int invoiceId = invoiceService.addInvoice(invoiceDto);
        Invoice invoice = invoiceService.getInvoiceInfo(invoiceId);

        return new ResponseBean(true, 200, "success！",invoice);
    }

    /*
    这个方法，又是新增又是修改----管理发票的时候用
     */
    @PostMapping("/modifyAdd")
    public ResponseBean modifyInvoice(HttpServletRequest request,InvoiceDto invoiceDto) throws Exception {
        SiteUser siteUser = getUserInfo(request);
        invoiceDto.setUser_id(siteUser.getId());
        if (invoiceDto.getId() == null){//假如id是空
            invoiceService.addInvoice(invoiceDto);
        }else{
            invoiceService.updateInvoice(invoiceDto);
        }
        return new ResponseBean(true, 200, "success！",invoiceService.getInvoiceByUser(siteUser.getId()));
    }

    @GetMapping("/info")
    public ResponseBean getInvoiceInfoByUser(HttpServletRequest request) {

        SiteUser siteUser = null;
        try {
            siteUser = getUserInfo(request);
            return new ResponseBean(true, 200, "success！",invoiceService.getInvoiceByUser(siteUser.getId()));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseBean(false, 500, "获取发票信息失败！",null);
        }

    }
}
