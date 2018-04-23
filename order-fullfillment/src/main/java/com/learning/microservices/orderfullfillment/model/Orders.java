/**
 * 
 */
package com.learning.microservices.orderfullfillment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sushant
 *
 */
public class Orders implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Order> order;

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	public void addOrder(Order order) {
		if (this.order == null || this.order.isEmpty()) {
			this.order = new ArrayList<Order>();
		}
		this.order.add(order);
	}
}
