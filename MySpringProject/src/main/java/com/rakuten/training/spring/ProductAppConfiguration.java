package com.rakuten.training.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.rakuten.training.spring.dal.ProductDAO;
import com.rakuten.training.spring.dal.ProductDAOInMemImpl;
import com.rakuten.training.spring.service.ProductService;
import com.rakuten.training.spring.service.ProductServiceImpl;
import com.rakuten.training.spring.ui.ProductConsoleUI;
	@Configuration
	@ComponentScan(basePackages="com.rakuten.training.spring")
	public 	class ProductAppConfiguration
	{
		/*@Bean
		public ProductDAO daoObj() {
			ProductDAOInMemImpl dao = new ProductDAOInMemImpl();
			return dao;
		}
		
		@Bean
		public ProductService serviceObj() {
			ProductServiceImpl service = new ProductServiceImpl();
			service.setDao(daoObj());
			return service;
		}
		
		@Bean
		public ProductConsoleUI uiObj() {
			ProductConsoleUI ui = new ProductConsoleUI();
			ui.setService(serviceObj());
			return ui;
		}
	*/
	}
