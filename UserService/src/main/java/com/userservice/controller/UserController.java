package com.userservice.controller;

import java.util.Arrays;
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
import org.springframework.web.client.RestTemplate;

import com.userservice.entity.Hotel;
import com.userservice.entity.Rating;
import com.userservice.entity.User;
import com.userservice.external.services.HotelService;
import com.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private RestTemplate resttemplate;
	
	@Autowired
	private HotelService hotelservice;
	
	@GetMapping("/")
	public String fine()
	{
		return "Workinf fine";
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user1= userservice.SaveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
		
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userid)
	{
		User user=userservice.getUser(userid);
		
		//fetch raiting of the user
		Rating[] forobject=resttemplate.getForObject("http://RATING-SERVICE/rating/getbyUserId/"+user.getUserid(),Rating[].class);
		List<Rating> ratings =Arrays.stream(forobject).toList();
		for(Rating r:ratings) {
		//ResponseEntity<Hotel> ratinglist=resttemplate.getForEntity("http://HOTEL_SERVICE/hotel/"+r.getHotelId(), Hotel.class);
			Hotel hotel=hotelservice.getHotel(r.getHotelId());
		r.setHotel(hotel);
		}
		
		user.setRating(ratings);
		
		return ResponseEntity.ok(user);
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> user=userservice.getAllUser();
		
		return ResponseEntity.ok(user);
		
	}
	
	

}
