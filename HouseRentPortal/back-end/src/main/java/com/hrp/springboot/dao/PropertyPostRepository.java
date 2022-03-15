package com.hrp.springboot.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hrp.springboot.entity.PropertyPostBean;
import com.hrp.springboot.entity.RentRequestBean;

@Repository
@Transactional
public class PropertyPostRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<PropertyPostBean> fetchAllPosts() {
		String jpql = "SELECT c FROM PropertyPostBean c";
        List<PropertyPostBean> query = entityManager.createQuery(jpql).getResultList();
        return query;
	}
	
	@Transactional
	public List<RentRequestBean> fetchAllRequests() {
		String jpql = "SELECT c FROM RentRequestBean c";
        List<RentRequestBean> query = entityManager.createQuery(jpql).getResultList();
        return query;
	}
	
	@Transactional
	public String savePost(PropertyPostBean bean) {
		
        entityManager.persist(bean);
        return "success";
	}
	
	@Transactional
	public PropertyPostBean getPropertById(int propId) {
		String jpql = "SELECT c PropertyPostBean c WHERE c.propId = ?";
		PropertyPostBean bean =   entityManager.find( PropertyPostBean.class,propId);
		
        return bean;
	}
	
	@Transactional
	public String saveRentRequest(RentRequestBean bean) {
		
        entityManager.persist(bean);
        return "success";
	}

}











