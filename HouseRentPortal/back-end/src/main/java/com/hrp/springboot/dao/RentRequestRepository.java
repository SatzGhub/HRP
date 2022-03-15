package com.hrp.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hrp.springboot.entity.RentRequestBean;

@Repository
@Transactional
public interface RentRequestRepository extends JpaRepository<RentRequestBean, Integer> {
	
	@Query("SELECT u FROM RentRequestBean u WHERE u.ownerId = :ownerId")
	public List<RentRequestBean> findAllReqForOwner(@Param("ownerId") int ownerId);
	
	
}
