package com.ratingservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ratingservice.entity.Rating;


@Repository
public interface RatingRepo extends JpaRepository<Rating,String> {
	
	List<Rating> findByUserId(String userid);
	List<Rating> findByHotelId(String hotelid);

}
