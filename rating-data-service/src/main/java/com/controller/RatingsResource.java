package com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Rating;
import com.model.UserRatings;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

		@RequestMapping("/{movieId}")
		public Rating getRatings(@PathVariable("movieId") String movieid) {
			
			return new Rating(movieid, 3);
		}
		
		@RequestMapping("/users/{userId}")
		public UserRatings getUserRating (@PathVariable("userId") String userid){
			
			List<Rating> ratings = Arrays.asList(
					new Rating("123" , 4),
					new Rating("456", 3),
					new Rating("789", 5)
					);
			
			UserRatings userRatings = new UserRatings();
			userRatings.setUserRatings(ratings);
			return userRatings;
		}
}
