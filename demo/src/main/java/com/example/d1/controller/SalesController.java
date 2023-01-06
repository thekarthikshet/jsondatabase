package com.example.d1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.d1.model.ResponseModel;
import com.example.d1.model.Sales;
import com.example.d1.service.SalesService;

@RestController
public class SalesController {

	@Autowired
	SalesService salesService;
	
	@PostMapping("/sales")
	public ResponseModel addSales(@RequestBody Sales sales) {
		return salesService.addSales(sales);
	}
	
	@GetMapping("/sales/all")
	public ResponseModel fetchAllSales()
	{
		return salesService.fetchAllSales();
	}
	
	@GetMapping("/sales/{sales_id}")
	public ResponseModel fetchSalesDetails(@PathVariable int sales_id )
	{
		return salesService.fetchSalesDetails(sales_id);
	}
}
