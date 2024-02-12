package com.hoterservice.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoterservice.entity.Hotel;
import com.hoterservice.exception.ResourceNotFoundException;
import com.hoterservice.repo.HotelRepo;
import com.hoterservice.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepo hotelrepo;

	@Override
	public Hotel create(Hotel hotel) {
		
		String random=UUID.randomUUID().toString();
		hotel.setId(random);
		return hotelrepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelrepo.findAll();
	}

	@Override
	public Hotel get(String id) {
		return hotelrepo.findById(id).orElseThrow( ()->new ResourceNotFoundException());
	}

}