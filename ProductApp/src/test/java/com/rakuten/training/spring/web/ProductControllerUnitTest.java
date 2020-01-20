package com.rakuten.training.spring.web;
import org.hamcrest.CoreMatchers;
//import static org.springframework.
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rakuten.training.spring.domain.Product;
import com.rakuten.training.spring.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest({ProductController.class})
public class ProductControllerUnitTest {
  @Autowired MockMvc mockmvc;
  @MockBean
ProductService service;
  @Test
  public void getProductById_Returns_Ok_With_Correct_Product_If_Found()throws Exception {
	  //Arrange
	  Product found=new Product("test",133.0f,100);int id=1;
	  found.setId(id);
	  Mockito.when(service.findById(id)).thenReturn(found);
	  //Act and Assert
	  mockmvc.perform(MockMvcRequestBuilders.get("/products/{id}",id))
			  .andExpect(MockMvcResultMatchers.status().isOk())
			  .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(id)));
  }
  @Test
  public void getProductById_Returns_Not_Found_If_product_Not_Found()throws Exception
  
  {
	  //Arrange
	  Product p=new Product("test",1000,12);int id=1;
	p.setId(id);
	Mockito.when(service.findById(id)).thenReturn(p);
	//Act and Assert
	mockmvc.perform(MockMvcRequestBuilders.get("/products/{id}",id+1))
	.andExpect(MockMvcResultMatchers.status().isNotFound());
  }
  @Test
  public void addProduct_Returns_valid_id_If_Product_Is_Added()throws Exception
  {	ObjectMapper ob=new ObjectMapper();
	  //Arrange
	  Product p=new Product("test",123f,100);int id=1;
		p.setId(id);
		Mockito.when(service.addNewProduct(Mockito.any(Product.class))).thenReturn(1);
		//Act
		//service.addNewProduct(p);
		
		mockmvc.perform
		(MockMvcRequestBuilders.post("/products")
				.contentType(MediaType.APPLICATION_JSON)
				.content(ob.writeValueAsString(p)))
		.andExpect(MockMvcResultMatchers.header().string("location","/products/"+id))
		.andExpect(MockMvcResultMatchers.status().isCreated());
		Mockito.verify(service).addNewProduct(Mockito.any(Product.class));
  }
  @Test
  public void addProduct_Return_InValid_if_product_qoh_price_is_lt_10000() throws JsonProcessingException, Exception
  {
	  Product p=new Product("test",1.0f,1);int id=1;
		p.setId(id);
		ObjectMapper ob=new ObjectMapper();
		Mockito.when(service.addNewProduct(Mockito.any())).thenThrow(new IllegalArgumentException());
		mockmvc.perform
		(MockMvcRequestBuilders.post("/products")
				.contentType(MediaType.APPLICATION_JSON)
				.content(ob.writeValueAsString(p)))
		//.andExpect(MockMvcResultMatchers.header().string("location","/products/"+id))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
  }
  @Test
  public void deleteProduct_successfullyDeletes() throws Exception
  {
	  Product p=new Product("test",1.0f,1);int id=1;
		p.setId(id);
		Mockito.doThrow(new IllegalArgumentException()).when(service).removeProduct(Mockito.any());
		mockmvc.perform
		(MockMvcRequestBuilders.post("/products/{prodid}",id))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
  }
}
