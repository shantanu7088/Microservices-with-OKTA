package com.hoterservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoterservice.entity.Hotel;
import com.hoterservice.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	
	@Autowired
	private HotelService hotelservice;
	
	
	@PostMapping("/save")
	public ResponseEntity<Hotel> save(@RequestBody Hotel hotel)
	{
		
		hotelservice.create(hotel);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
		
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(hotelservice.get(hotelId));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Hotel>> getHotel()
	{
		return ResponseEntity.status(HttpStatus.OK).body(hotelservice.getAll());
	}

}
