/**
 * 
 */
package com.learning.microservices.orderfullfillment.listeners;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.learning.microservices.sagas.OrderSaga;

/**
 * @author Sushant
 *
 */

@Component
public class MessageListener {

	
	@JmsListener(destination = "order.created.queue", containerFactory = "jmsFactory")
	  public void receiveMessage(OrderSaga order) {
	    System.out.println("Received <" + order.getTransaction() + ","+ order.getState() + " >");
	    
	  }
	
}
