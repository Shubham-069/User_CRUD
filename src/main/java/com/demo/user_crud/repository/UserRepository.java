package com.demo.user_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.user_crud.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
