package com.excel.ims.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.ims.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
   Optional<Admin>findByEmail(String email);


}


