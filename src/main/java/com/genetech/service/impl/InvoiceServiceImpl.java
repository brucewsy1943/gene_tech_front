package com.genetech.service.impl;

import com.genetech.bean.Invoice;
import com.genetech.bean.InvoiceExample;
import com.genetech.bean.dto.InvoiceDto;
import com.genetech.dao.InvoiceMapper;
import com.genetech.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Administrator on 2019/12/18.
 */
@Service("invoiceService")
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceMapper invoiceMapper;

    @Transactional
    @Override
    public int addInvoice(InvoiceDto invoiceDto) {
        invoiceMapper.insert(invoiceDto);
        return invoiceDto.getId();
    }

    public Invoice getInvoiceInfo(Integer id){

        return invoiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateInvoice(InvoiceDto invoiceDto) {

        invoiceMapper.updateByPrimaryKey(invoiceDto);

    }

    @Override
    public Invoice getInvoiceByUser(Integer userId) {
        InvoiceExample invoiceExample = new InvoiceExample();
        InvoiceExample.Criteria criteria = invoiceExample.createCriteria();
        criteria.andUser_idEqualTo(userId);
        List<Invoice> list = invoiceMapper.selectByExample(invoiceExample);
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    //专门用于订单提交页面
    @Override
    public int updateInvoiceInOrderSubmit(Integer userId,InvoiceDto invoiceDto) {
        //根据userId找出
        Invoice invoice = getInvoiceByUser(userId);
        //假如是第一次新增发票
        if (invoice == null){
            return addInvoice(invoiceDto);
        }

        invoice.setTaxpayer_number(invoiceDto.getTaxpayer_number());
        invoice.setTitle(invoiceDto.getTitle());
        invoiceMapper.updateByPrimaryKey(invoice);
        return invoice.getId();
    }
}
