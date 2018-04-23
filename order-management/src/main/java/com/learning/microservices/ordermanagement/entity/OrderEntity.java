/**
 * 
 */
package com.learning.microservices.ordermanagement.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.learning.microservices.ordermanagement.annotations.SagaTransaction;

/**
 * @author Sushant
 *
 */

@Entity
@Table(name = "Orders")
public class OrderEntity {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;

	private String name;
	
	private String orderNumber;
	
	private int quantity;
	
	private String orderId;

	@SagaTransaction
	private String txId = UUID.randomUUID().toString();
	
	private byte state; 
	
	
	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}
	
	
	
}
