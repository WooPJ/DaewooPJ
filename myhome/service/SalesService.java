package com.springboot.myhome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.myhome.mapper.SalesMapper;
import com.springboot.myhome.model.Sale;
import com.springboot.myhome.model.SaleDetail;

@Service
public class SalesService {
	@Autowired
	private SalesMapper salesMapper;
	
	public Integer getMaxSaleId() {
		Integer max = this.salesMapper.getMaxSaleId();
		if(max == null) return 0;
		else return max;
	}
	public void putSale(Sale sale) {
		this.salesMapper.putSale(sale);
	}
	public void putSaleDetail(SaleDetail detail) {
		detail.setSaleId(detail.getSale().getSaleId());
		detail.setItemId(detail.getItemId());
		this.salesMapper.putSaleDetail(detail);
		
	}
}
