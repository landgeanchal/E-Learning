package com.project.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.elearning.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
   
}
