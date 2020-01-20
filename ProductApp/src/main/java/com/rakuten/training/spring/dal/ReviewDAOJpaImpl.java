package com.rakuten.training.spring.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rakuten.training.spring.domain.Product;
import com.rakuten.training.spring.domain.Review;

@Repository
@Transactional

public class ReviewDAOJpaImpl implements ReviewDAO {

	@Autowired
	EntityManager em;
	@Override
  public Review findById(int id)
	{
		return em.find(Review.class,id);
	}
	@Override
  public Review save(Review toBeSaved,int productId)
	{
		//Product p=em.find(Product.class, productId);
		//toBeSaved.setProduct(p);
		em.persist(toBeSaved);
		return toBeSaved;
	}
	@Override
  public void deleteById(int id)
	{
		Review r=em.find(Review.class, id);
		em.remove(r);
	}
	@Override
  public List<Review> findReviewsByProductId(int id)
	{
		if(em.find(Product.class, id)==null)
		{
			throw new NullPointerException("no such product object");
		}
		else
		{
			Query rList=em.createQuery("select e from Review e where e.product.id=:id");
			rList.setParameter("id", id);
			return rList.getResultList();
			
		}
		
	}
}
