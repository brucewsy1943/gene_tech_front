package com.genetech.bean.dto;

import com.genetech.bean.Invoice;

/**
 * Created by Administrator on 2019/12/18.
 */
public class InvoiceDto extends Invoice {

    private Integer is_invoice_needed;//是否开局发票
    public InvoiceDto() {
    }

    public InvoiceDto(Integer id, String title, String taxpayer_number, String regist_address, String regist_phone, String open_bank, String open_account, Integer user_id, String content) {
        super(id, title, taxpayer_number, regist_address, regist_phone, open_bank, open_account, user_id, content);
    }

    public Integer getIs_invoice_needed() {
        return is_invoice_needed;
    }

    public void setIs_invoice_needed(Integer is_invoice_needed) {
        this.is_invoice_needed = is_invoice_needed;
    }
}
