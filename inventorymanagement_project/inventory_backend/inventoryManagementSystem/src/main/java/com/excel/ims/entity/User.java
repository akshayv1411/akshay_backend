package com.excel.ims.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "userTable")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String username;
	 @Column(unique=true)
	private String email;
	private String password;
	private boolean isAdmin;
	private LocalDate createdAt;

	@OneToMany(cascade = CascadeType.MERGE.PERSIST.REFRESH.DETACH, fetch = FetchType.EAGER, mappedBy = "userTable")
	private List<PurchaseOrders> purchaseOrders;
	 @PrePersist
	    protected void onCreate() {
	        createdAt = LocalDate.now();
	   
	    }
}
