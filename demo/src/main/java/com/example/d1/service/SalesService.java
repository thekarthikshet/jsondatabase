package com.example.d1.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.d1.model.ResponseModel;
import com.example.d1.model.Sales;

@Service
public interface SalesService {
	
	
    
	ResponseModel addSales(Sales sales);

	ResponseModel fetchAllSales();

	ResponseModel fetchSalesDetails(int sales_id);

}
