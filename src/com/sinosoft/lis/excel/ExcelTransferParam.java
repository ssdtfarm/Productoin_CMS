package com.sinosoft.lis.excel;

public class ExcelTransferParam {
	private String contentKey;
	private String contentValue;
	
	public ExcelTransferParam() {
		super();
	}
	
	public ExcelTransferParam(String contentKey, String contentValue) {
		super();
		this.contentKey = contentKey;
		this.contentValue = contentValue;
	}
	
	public String getContentKey() {
		return contentKey;
	}
	public void setContentKey(String contentKey) {
		this.contentKey = contentKey;
	}
	public String getContentValue() {
		return contentValue;
	}
	public void setContentValue(String contentValue) {
		this.contentValue = contentValue;
	}
	
	
}
