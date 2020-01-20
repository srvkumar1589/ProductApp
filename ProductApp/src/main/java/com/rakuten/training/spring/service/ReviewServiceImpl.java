package com.rakuten.training.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.training.spring.dal.ProductDAO;
import com.rakuten.training.spring.dal.ReviewDAO;
import com.rakuten.training.spring.domain.Product;
import com.rakuten.training.spring.domain.Review;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {
  @Autowired ReviewDAO rdao;
  @Autowired ProductDAO dao;

  @Override
  public List<Review> findallReviewsOfAProduct(int id) {
    return rdao.findReviewsByProductId(id);
  }

  @Override
  public Review addReview(Review r, int id) {
    Product p = dao.findById(id);
    if (p != null) {
      r.setProduct(p); // ye
      rdao.save(r, id);

      return r;
    } else {
      // throw new IllegalArgumentException("no such product exists");
      throw new NoSuchProductException();
    }
  }
}
