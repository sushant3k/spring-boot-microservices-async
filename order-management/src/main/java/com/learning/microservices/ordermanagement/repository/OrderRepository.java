/**
 * 
 */
package com.learning.microservices.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.microservices.ordermanagement.entity.OrderEntity;

/**
 * @author Sushant
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	
	

}
