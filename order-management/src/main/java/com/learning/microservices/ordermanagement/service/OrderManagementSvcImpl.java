/**
 * 
 */
package com.learning.microservices.ordermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.microservices.ordermanagement.annotations.EventSender;
import com.learning.microservices.ordermanagement.entity.OrderEntity;
import com.learning.microservices.ordermanagement.model.Order;
import com.learning.microservices.ordermanagement.repository.OrderRepository;

/**
 * @author Sushant
 *
 */
@Service
public class OrderManagementSvcImpl implements OrderManagementSvc{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Order> getAllOrders() {
		List<OrderEntity> oe = orderRepository.findAll();
		
		if (oe == null || oe.isEmpty()) {
			return null;
		}
		
		List<Order> order = new ArrayList<>(oe.size());
		
		for (OrderEntity o : oe) {
			
			Order ord = new Order();
			ord.setName(o.getName());
			ord.setOrderId(o.getOrderId());
			ord.setOrderNumber(o.getOrderNumber());
			ord.setQuantity(o.getQuantity());
			order.add(ord);
		}
		
		return order;
	}

	@EventSender(qName="order.created.queue")
	@Override
	public OrderEntity addOrder(Order order) {
		
		if (order == null) {
			return null;
		}
		
		OrderEntity oe = new OrderEntity();
		oe.setName(order.getName());
		oe.setOrderId(order.getOrderId());
		oe.setOrderNumber(order.getOrderNumber());
		oe.setQuantity(oe.getQuantity());
		oe.setState((byte)0);
		orderRepository.save(oe);
		return oe;
	}

}
