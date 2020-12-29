package com.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.model.CatalogItem;
import com.model.Movie;
import com.model.Rating;
import com.model.UserRatings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userid){
		
		
		UserRatings ratings = restTemplate.getForObject("http://rating-data-service/ratings/users/" + userid, UserRatings.class);
		
		return ratings.getUserRatings().stream().map(rating->{
			
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
				return new CatalogItem(movie.getName(), "test", rating.getRating());	
	
				})
				.collect(Collectors.toList());
		
		
//		return Collections.singletonList(
//				new CatalogItem("transformer", "transformer test", 4)
//				
//				);
	}

}
