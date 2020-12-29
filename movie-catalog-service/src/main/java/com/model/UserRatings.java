package com.model;

import java.util.List;

public class UserRatings {
	private List<Rating> userRatings;
	
	public UserRatings() {
		// TODO Auto-generated constructor stub
	}

	public List<Rating> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<Rating> userRatings) {
		this.userRatings = userRatings;
	}

	public UserRatings(List<Rating> userRatings) {
		super();
		this.userRatings = userRatings;
	}

	@Override
	public String toString() {
		return "UserRatings [userRatings=" + userRatings + "]";
	}
	
}
