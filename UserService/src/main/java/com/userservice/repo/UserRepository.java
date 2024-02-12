package com.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.userservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

}