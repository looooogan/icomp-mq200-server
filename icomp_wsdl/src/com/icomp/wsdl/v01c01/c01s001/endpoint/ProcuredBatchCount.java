package com.icomp.wsdl.v01c01.c01s001.endpoint;

import java.io.Serializable;

public class ProcuredBatchCount implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = -788973736255609436L;
	

	/* 采购批次 */
	private String procuredBatch;
	
	/* 采购数量 */
	private String procuredCount;

	public String getProcuredBatch() {
		return procuredBatch;
	}

	public void setProcuredBatch(String procuredBatch) {
		this.procuredBatch = procuredBatch;
	}

	public String getProcuredCount() {
		return procuredCount;
	}

	public void setProcuredCount(String procuredCount) {
		this.procuredCount = procuredCount;
	}
}
