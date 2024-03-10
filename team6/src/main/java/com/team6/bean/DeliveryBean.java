package com.team6.bean;

public class DeliveryBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String cname;
	private String phone;
	private String product;
	private int num;
	private int price;
	private String ename;
	private String address;
	private int time;
	
	public DeliveryBean(int id, String cname, String phone, String product,int num, int price,String ename, String address, int time) {
        this.id = id;
        this.cname = cname;
        this.phone = phone;
        this.product = product;
        this.num = num;
        this.price = price;
        this.ename = ename;
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
	public int getTime() {return time;}
	public int getNum() {return num;}
	public String getEname() {return ename;}
	
	// set
	public void setId(int id) {this.id = id;}
	public void setCname(String cname) {this.cname = cname;}
	public void setPhone(String phone) {this.phone = phone;}
	public void setProduct(String product) {this.product = product;}
	public void setPrice(int price) {this.price = price;}
	public void setAddress(String address) {this.address = address;}
	public void setTime(int time) {this.time = time;}
	public void setEname(String ename) {this.ename = ename;}
	public void setNum(int num) {this.num = num;}
	
	
	
}
