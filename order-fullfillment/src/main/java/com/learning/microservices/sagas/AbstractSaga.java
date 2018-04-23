/**
 * 
 */
package com.learning.microservices.sagas;

import java.io.Serializable;

/**
 * @author ggne0084
 *
 */
public abstract class AbstractSaga implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String transactionId;
	
	protected byte state; // 0-init, 1-success, 2-failed, 3-created
	
	public abstract void setTransaction(String txId);
	public abstract void setState(byte state);
}
