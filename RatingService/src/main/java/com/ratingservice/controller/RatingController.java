package com.ratingservice.controller;

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

import com.ratingservice.entity.Rating;
import com.ratingservice.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingservice;
	
	@PostMapping("/save")
	public ResponseEntity<Rating> create(@RequestBody Rating rating)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingservice.create(rating));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Rating>> getAll()
	{
		return ResponseEntity.ok(ratingservice.getAll());
	}
	
	@GetMapping("/getbyUserId/{userid}")
	public ResponseEntity<List<Rating>>  getAllUserID(@PathVariable String userid)
	{
		return ResponseEntity.ok(ratingservice.getAllByUserId(userid));
	}
	@PostMapping("/getbyHotelId/{hotelid}")
	public ResponseEntity<List<Rating>> getAllHotelId(@PathVariable String hotelid)
	{
		return ResponseEntity.ok(ratingservice.getAllByHotelId(hotelid));
	}
	
	
}
