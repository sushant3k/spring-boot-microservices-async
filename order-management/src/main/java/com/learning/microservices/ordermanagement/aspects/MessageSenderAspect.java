/**
 * 
 */
package com.learning.microservices.ordermanagement.aspects;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.learning.microservices.ordermanagement.annotations.EventSender;
import com.learning.microservices.ordermanagement.annotations.SagaTransaction;
import com.learning.microservices.sagas.OrderSaga;

/**
 * @author Sushant
 *
 */
@Aspect
@Component
public class MessageSenderAspect {

//	@Autowired
	private JmsTemplate jmsTemplate;
	
	

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}


	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}



	@AfterReturning(value = "@annotation(com.learning.microservices.ordermanagement.annotations.EventSender)", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {

		
		MethodSignature ms = (MethodSignature)joinPoint.getSignature();
		EventSender es = ms.getMethod().getAnnotation(EventSender.class);
//		EventSender es = joinPoint.getClass().getAnnotation(EventSender.class);

		try {
			OrderSaga os = new OrderSaga();

			Class<?> cls = result.getClass();
			
			
			Field stateField = cls.getDeclaredField("state");
			char initChar = Character.toUpperCase(stateField.getName().charAt(0));
			Method m = cls.getMethod("get"+ initChar + stateField.getName().substring(1), (Class<?> []) null);
//			m.setAccessible(true);
			Object obj1 = m.invoke(cls.newInstance(), (Object [])null);
			byte b = (byte)obj1;
			System.out.println("Setting State as: " + b);
			os.setState(b);

			Field[] fs = cls.getDeclaredFields();
			for (Field f : fs) {
				if (f.isAnnotationPresent(SagaTransaction.class)) {
					f.setAccessible(true);					
					Object obj = f.get(cls.newInstance());
					if (obj != null) {
						System.out.println("Setting Transaction as: " + obj.toString());
						os.setTransaction(obj.toString());
						break;
					}
				}
			}

			jmsTemplate.convertAndSend(es.qName(), os);
			System.out.println("Message Sent......");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
