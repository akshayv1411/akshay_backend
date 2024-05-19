package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Account {
	
	SAVINGS("SAVINGS"),
	CURRENT("CURRENT");
	
	private final String accountType;
	
}
