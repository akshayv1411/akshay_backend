package com.excel.ims.dto;
import java.time.LocalDate;

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
public class UserDto {
	private Integer userId;
	private String username;
	private String email;
	private String password;
	private boolean isAdmin;
	private LocalDate createdAt;
	
}
