package com.rakuten.training.spring.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.spring.domain.Product;
import com.rakuten.training.spring.domain.Review;
import com.rakuten.training.spring.service.NoSuchProductException;
import com.rakuten.training.spring.service.ProductService;
import com.rakuten.training.spring.service.ReviewService;

@RestController
public class ReviewController {
	
	
	@Autowired
	ProductService service;
	@Autowired
	ReviewService s;
	
	@GetMapping("/products/{pid}/reviews")
	public ResponseEntity<List<Review>> showReviews(@PathVariable("pid")int id)
	{
		Product p=service.findById(id);
		if (p==null)
		{
			return new ResponseEntity<List<Review>>(HttpStatus.NOT_FOUND);
		}
		List<Review> reviews=s.findallReviewsOfAProduct(id);
		return new ResponseEntity<List<Review>>(reviews,HttpStatus.OK);
	}
	@PostMapping("/products/{pid}/reviews")
	public ResponseEntity<Review> addReview(@RequestBody Review r,@PathVariable("pid")int id)
	{
		try
		{
		Review n=s.addReview(r, id);
		HttpHeaders headers2=new HttpHeaders();
		headers2.setLocation(URI.create("/products/"+id+"/reviews/"+n.getId()));
		//return new ResponseEntity<Review>(headers2, HttpStatus.CREATED);
    return new ResponseEntity<Review>(r,headers2,HttpStatus.OK);
		}
		catch(NoSuchProductException e)
		{
			return new ResponseEntity<Review>(HttpStatus.BAD_REQUEST);
		}
	}
}
