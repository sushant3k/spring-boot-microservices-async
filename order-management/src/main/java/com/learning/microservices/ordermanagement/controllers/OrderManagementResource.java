/**
 * 
 */
package com.learning.microservices.ordermanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.microservices.ordermanagement.model.Order;
import com.learning.microservices.ordermanagement.model.Orders;
import com.learning.microservices.ordermanagement.service.OrderManagementSvc;

/**
 * @author Sushant
 *
 *
 */

//@RefreshScope
@RestController
public class OrderManagementResource {

	@Autowired
	private OrderManagementSvc orderManager;
	
	 
	
	@RequestMapping(method=RequestMethod.GET,produces="application/json", value="/orders")
	public Orders getAllOrders() {
		List<Order> l = orderManager.getAllOrders();
		Orders orders= new Orders();
		orders.setOrder(l);
		return orders;
	}
	
	@RequestMapping(method=RequestMethod.POST,consumes="application/json", value="/orders")
	public void addOrder(@RequestBody Order order) {
		
		orderManager.addOrder(order);
	}
}
