package com.sinosoft.report.ireport.util;

import java.util.List;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import org.apache.commons.beanutils.PropertyUtils;

/**
* <p>Description:  SubDataSource </p>
* <p>Copyright: Copyright (c) 2002 - 2006 unihub.net. All Right Reserved </p> 
* Created by Unihub GZ ODC 
* Midified by ....
*/

public class SubDataSource extends JREmptyDataSource {

	private List detailItems;
	private int index = -1;
	private Object paramObject;


	/**
	 * 
	 */
	public SubDataSource() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public SubDataSource(int arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Object getParamObject() {
		return paramObject;
	}

	public void setParamObject(Object paramObject) {
		this.paramObject = paramObject;
	}

	public List getDetailItems() {
		return detailItems;
	}

	public void setDetailItems(List detailItems) {
		this.detailItems = detailItems;
	}

	
	/* (non-Javadoc)
	 * @see net.sf.jasperreports.engine.JRDataSource#getFieldValue(net.sf.jasperreports.engine.JRField)
	 */
	public Object getFieldValue(JRField field){
		Object value = null;
		try{

			String fieldName = field.getName();
		
			Object bean = detailItems.get(index);
  		    value =  PropertyUtils.getProperty(bean,fieldName); 
		}
		catch(Exception e)
		{
		 
		   //throw new JRException(e);
		}
                /** updated by Forrest Chen 2005-07-14 **/
                if(value==null&&value instanceof String)
                        return "";
                else        
                        return value ;
	}

	/* (non-Javadoc)
	 * @see net.sf.jasperreports.engine.JRRewindableDataSource#moveFirst()
	 */
	public void moveFirst(){
		// TODO Auto-generated method stub
		super.moveFirst();
	}

	/* (non-Javadoc)
	 * @see net.sf.jasperreports.engine.JRDataSource#next()
	 */
	public boolean next(){
		index++;
		return (index < detailItems.size());
	}

}
