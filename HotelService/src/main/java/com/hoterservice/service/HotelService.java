package com.hoterservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hoterservice.entity.Hotel;

@Service
public interface HotelService {
	
	Hotel create(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel get(String id);
	

}
