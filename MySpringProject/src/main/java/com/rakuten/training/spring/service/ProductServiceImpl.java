package com.rakuten.training.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rakuten.training.spring.dal.ProductDAO;
import com.rakuten.training.spring.dal.ProductDAOInMemImpl;
import com.rakuten.training.spring.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
  ProductDAO dao;

  @Autowired
  public void setDao(ProductDAO dao) {
    this.dao = dao;
  }

  @Override
  public int addNewProduct(Product toBeAdded) {
    if (toBeAdded.getPrice() * toBeAdded.getQoh() >= 10000) {
      Product added = dao.save(toBeAdded);
      return added.getId();
    } else {
      throw new IllegalArgumentException("The monetary value of product is <10000");
    }
  }

  @Override
  public void removeProduct(int id) {
    Product existing = dao.findById(id);
    if (existing != null)
      if (existing.getPrice() * existing.getQoh() >= 100000) {
        throw new IllegalStateException("monetary value >1000000.Cant delete");
      }
  }

  @Override
  public List<Product> findAll() {
    return dao.findAll();
  }

  @Override
  public Product findById(int id) {
    return dao.findById(id);
  }
}
