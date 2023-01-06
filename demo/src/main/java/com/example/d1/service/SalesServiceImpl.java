package com.example.d1.service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.d1.model.ResponseModel;
import com.example.d1.model.Sales;
import com.example.d1.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class SalesServiceImpl implements SalesService{
	
	
     int salesidgen=0;
	SalesServiceImpl(){}
	@Override
	public ResponseModel addSales(Sales sales) {
		// TODO Auto-generated method stub
		ResponseModel responseModel=new ResponseModel();
		salesidgen++;
		sales.setSales_id(salesidgen);
		List<Sales> salesData=readJsonData();
		Sales salesPresent=null;
		
		if(salesData !=null)
		{
			salesPresent=salesData.parallelStream().filter(sid->sid.getSales_id()==(sales.getSales_id())).findAny().orElse(null);
		}
		else
			salesData=new ArrayList<>();
		if(salesPresent==null) {
			salesData.add(sales);
		
		
		boolean status= writeJsonData(salesData);
		
		if(status) {
			responseModel.setStatus(Constants.SUCCESS);
			responseModel.setData(Constants.SALES_ADDED_SUCCESSFULLY);
			}
		}
		else {
			responseModel.setData(Constants.SALES_ALREADY_EXISTS);
		}
		return responseModel;
	}
	
	public List<Sales> readJsonData(){
		List<Sales> saleslist=new ArrayList<>();
		try {
			String json=Files.readString(Path.of("C:\\Users\\FCI773\\eclipse-workspace5\\demo\\datajson.txt"));
		    saleslist=new Gson().fromJson(json, new TypeToken<List<Sales>>() {}.getType());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return saleslist;
	}
	
	public boolean writeJsonData(List<Sales> salesData) {
		boolean status=false;
		try(FileWriter file= new FileWriter("C:\\Users\\FCI773\\eclipse-workspace5\\demo\\datajson.txt"))
		{
			file.write(new Gson().toJson(salesData));
			file.flush();
			status=true;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public ResponseModel fetchAllSales() {
		// TODO Auto-generated method stub
		ResponseModel responseModel =new ResponseModel();
		
		List<Sales> salesData =readJsonData();
		
		responseModel.setStatus(Constants.SUCCESS);
		responseModel.setData(salesData);
		return responseModel;
	}
	@Override
	public ResponseModel fetchSalesDetails(int sales_id) {
		// TODO Auto-generated method stub
		ResponseModel responseModel =new ResponseModel();
		
		List<Sales> salesData =readJsonData();
		Sales sales=salesData.parallelStream().filter(sid->sid.getSales_id()==(sales_id)).findAny().orElse(null);
		
		if(sales!=null)
		{
			responseModel.setStatus(Constants.SUCCESS);
			responseModel.setData(sales);
		}
		else {
			responseModel.setStatus(Constants.SUCCESS);
			responseModel.setData(Constants.SALES_NOT_FOUND);
		}
		return responseModel;
	}

}
