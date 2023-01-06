package com.example.d1.model;


public class Sales {

  public Sales( String product_name, double price, int quantity) {
		super();
		
		this.product_name = product_name;
		this.price = price;
		this.quantity = quantity;
		this.total_sales=price*quantity;
	}
  
 
private int sales_id;
  private String product_name;
  private double price;
  private int quantity;
  private double total_sales=price*quantity;
  
  
  
public int getSales_id() {
	return sales_id;
}
public void setSales_id(int sales_id) {
	this.sales_id = sales_id;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getTotal_sales() {
	return total_sales;
}
public void setTotal_sales(double total_sales) {
	this.total_sales = total_sales;
}

}
