package com.sinosoft.lis.excel;

/**
 * 
 * @version 1.0 2008-2-22
 * @author Wang Wei
 * @author Evan
 *
 */
class ExcelException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -415720489952215657L;
	public ExcelException(Exception e) {
		super(e.getMessage());
	}
	public ExcelException(String message) {
		super(message);
	}
}
