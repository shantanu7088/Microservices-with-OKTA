package com.ratingservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ratingservice.entity.Rating;


@Service
public interface RatingService {
	
	Rating create(Rating rating);
	
	List<Rating> getAll();
	
	List<Rating> getAllByUserId(String userid);
	
	List<Rating> getAllByHotelId(String hotelid);
	

}
