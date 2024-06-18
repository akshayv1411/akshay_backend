package com.excel.ims.dto;
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
public class AdminDto {
	private Integer adminId;
	private String adminame;
	private String email;
	private String password;
	private boolean isAdmin;


}


