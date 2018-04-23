package com.learning.microservices.ordermanagement.messaging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.learning.microservices.sagas.OrderSaga;

@Component
public class MessageListener {

	
	@JmsListener(destination = "order.status.topic", containerFactory = "jmsFactory")
	  public void receiveMessage(OrderSaga saga) {
	    System.out.println("Received <" + saga.getTransaction() + ", " + saga.getState() +">");
	    
	  }
	
}
