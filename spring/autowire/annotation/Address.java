package com.excel.spring.autowire.annotation;

public class Address {
	private String address;

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Address [place=" + address + "]";
	}

	public void setAddress(String address) {
		this.address = address;
	}
}