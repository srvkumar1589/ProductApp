package com.rakuten.training.spring.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.spring.domain.Product;
import com.rakuten.training.spring.domain.Review;
import com.rakuten.training.spring.service.ProductService;
import com.rakuten.training.spring.service.ReviewService;

@RestController
public class ProductController {
	@Autowired
	ProductService service;
	//@RequestMapping(method=RequestMethod.GET,value="/products")
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
	return service.findAll();	
	}
	@GetMapping("/products/{prodid}")//uri path template
	public ResponseEntity<Product> getProductById(@PathVariable("prodid")int id)
	{
		Product p=service.findById(id);
		if (p!=null) {
			return new ResponseEntity<Product>(p,HttpStatus.OK);
		}
		else
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		
	}
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product toBeAdded)
	{
		//toBeAdded.setId(0);
		try
		{
		int id=service.addNewProduct(toBeAdded);
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(URI.create("/products/"+id));//http header should have uri to the newly vreated resource
		return new ResponseEntity<Product>(headers, HttpStatus.CREATED);

		}
		catch(IllegalArgumentException e)
		{
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/products/{prodid}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("prodid")int id)
	{
		try
		{
			//Product p=service.findById(id);
			service.removeProduct(id);
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}
		catch(IllegalArgumentException e)
		{
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
		catch(NullPointerException e)
		{
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}
}
