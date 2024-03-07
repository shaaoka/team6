package com.team6.bean;

public class DeliveryBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String cname;
	private String phone;
	private String product;
	private int price;	
	private String address;
	private String time;
	
	public DeliveryBean(int id, String cname, String phone, String product, int price, String address, String time) {
        this.id = id;
        this.cname = cname;
        this.phone = phone;
        this.product = product;
        this.price = price;
        this.address = address;
        this.time = time;
    }
	public DeliveryBean() {
    
	}
	// get
	public int getId() {return id;}
	public String getCname() {return cname;}
	public String getPhone() {return phone;}
	public String getProduct() {return product;}
	public int getPrice() {	return price;}
	public String getAddress() {return address;}
	public String getTime() {return time;}
	// set
	public void setId(int id) {this.id = id;}
	public void setCname(String cname) {this.cname = cname;}
	public void setPhone(String phone) {this.phone = phone;}
	public void setProduct(String product) {this.product = product;}
	public void setPrice(int price) {this.price = price;}
	public void setAddress(String address) {this.address = address;}
	public void setTime(String time) {this.time = time;}
	
	
}
