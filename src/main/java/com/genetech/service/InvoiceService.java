package com.genetech.service;

import com.genetech.bean.Invoice;
import com.genetech.bean.dto.InvoiceDto;

/**
 * Created by Administrator on 2019/12/18.
 */
public interface InvoiceService {

    public int addInvoice(InvoiceDto invoiceDto);

    public Invoice getInvoiceInfo(Integer id);

    public void updateInvoice(InvoiceDto invoiceDto);

    public Invoice getInvoiceByUser(Integer userId);

    //订单页面中的更新发票
    public int updateInvoiceInOrderSubmit(Integer userId,InvoiceDto invoiceDto);

}
