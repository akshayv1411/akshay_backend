package com.excel.spring.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Employee 
{
	private String name;
	private List<String> phone;
	private Set<String> skills;
	private Map<String, String> nominees;

	public Employee(String name, List<String> phone, Set<String> skills, Map<String, String> nominees) {
		super();
		this.name = name;
		this.phone = phone;
		this.skills = skills;
		this.nominees = nominees;
	}

	public Employee() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhone() {
		return phone;
	}

	public void setPhone(List<String> phone) {
		this.phone = phone;
	}

	public Set<String> getSkills() {
		return skills;
	}

	public void setSkills(Set<String> skills) {
		this.skills = skills;
	}

	public Map<String, String> getNominees() {
		return nominees;
	}

	public void setNominees(Map<String, String> nominees) {
		this.nominees = nominees;
	}




}