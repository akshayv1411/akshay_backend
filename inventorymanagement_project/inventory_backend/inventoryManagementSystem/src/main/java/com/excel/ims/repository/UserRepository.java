package com.excel.ims.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.ims.entity.User;

public interface UserRepository  extends JpaRepository<User, Integer>{
Optional<User>findByEmail(String email);

}
