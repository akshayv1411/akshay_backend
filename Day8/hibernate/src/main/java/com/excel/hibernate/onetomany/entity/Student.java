//package com.excel.hibernate.onetomany.entity;
//
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
////@Builder
//@Entity
//@Table(name = "student")
//public class Student {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "student_id")
//	private int id;
//	
//	@Column(name = "student_name")
//	private String name;
//	
//	@Column(name = "student_age")
//	private int age;
//	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
//	private List<Laptop> laptops;
//}