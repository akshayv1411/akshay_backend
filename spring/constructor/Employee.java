package com.excel.spring.constructor;

public class Employee {
	private int id;
	private String name;
	private String address;
	
	public Employee(int id, String name, Address address) {
		super();
		this.id=id;
		this.name=name;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}