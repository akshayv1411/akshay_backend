//package com.excel.hibernate.onetomany.entity;
//
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "laptop")
//public class Laptop {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "student_id")
//	private int id;
//	private String brand;
//	private String serialNo;
//	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Student student;
//}