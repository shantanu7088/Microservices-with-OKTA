package com.userservice.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.userservice.entity.Rating;

@FeignClient(name="RATING-SERVICE")	
public interface RatingService {
	
	
	@PostMapping("/rating/save")
	public Rating createRating(Rating rating);

	
	

}
