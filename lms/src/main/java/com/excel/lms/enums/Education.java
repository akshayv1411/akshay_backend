package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Education {
	
	UNDER_GRADUATE("UNDER_GRADUATE"),
	POST_GRADUATE("POST_GRADUATE"),
	OTHER("OTHER");
	
	private final String educationType;
}
