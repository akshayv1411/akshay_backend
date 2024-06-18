package com.excel.ims.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.excel.ims.exception.NoUserFoundException;

@RestControllerAdvice
public class UserControllerAdvice {
@ExceptionHandler(NoUserFoundException.class)
public ResponseEntity<String> noUserFoundHandler(RuntimeException exe){
	return ResponseEntity.status(HttpStatus.OK).body(exe.getMessage());
}

}
