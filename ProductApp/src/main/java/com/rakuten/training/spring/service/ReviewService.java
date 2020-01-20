package com.rakuten.training.spring.service;

import java.util.List;

import com.rakuten.training.spring.domain.Review;

public interface ReviewService {
	public  List<Review> findallReviewsOfAProduct(int id);
	public Review addReview(Review r,int id);
}

