/**
 * 
 */
package com.learning.microservices.ordermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.microservices.ordermanagement.entity.OrderEntity;
import com.learning.microservices.ordermanagement.model.Order;

/**
 * @author ggne0084
 *
 */
@Service
public interface OrderManagementSvc {

	List<Order> getAllOrders();
	
	OrderEntity addOrder(final Order order);
	
}
