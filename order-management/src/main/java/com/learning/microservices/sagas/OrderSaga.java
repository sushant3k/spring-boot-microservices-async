/**
 * 
 */
package com.learning.microservices.sagas;

import java.io.Serializable;

/**
 * @author Sushant
 *
 */
public class OrderSaga extends AbstractSaga implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void setTransaction(String txId) {
		// TODO Auto-generated method stub
		this.transactionId = txId;
	}

	@Override
	public void setState(byte state) {
		// TODO Auto-generated method stub
		this.state = state;
	}
	
	public String getTransaction() {
		return this.transactionId;
	}
	
	public byte getState() {
		return this.state;
	}

}
