package com.hoterservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoterservice.entity.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,String> {

}
