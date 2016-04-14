/*
 * All rights reserved. All information contained in this software is
 * confidential and proprietary to Pacific Century Cyberworks. No part of this
 * software may be reproduced or transmitted in any form or any means,
 * electronic, mechanical, photocopying, recording or otherwise stored in any
 * retrieval system of any nature without the prior written permission of
 * Pacific Century Cyberworks.
 *
 * This material is a trade secret and its confidentiality is strictly
 * maintained. Use of any copyright notice does not imply unrestricted public
 * access to this material.
 *
 * (c) Pacific Century Cyberworks
 */
package com.sinosoft.report.ireport.util;

import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import org.apache.commons.beanutils.PropertyUtils;

/**
* <p>Description:  ReportDataSource </p>
*/

public class ReportDataSource implements IReportDataSource{
    private List detailItems;
    private int index = -1;
    private Object paramObject;

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

    public boolean next() throws JRException
	{
		index++;

		return (index < detailItems.size());
	}

	public Object getFieldValue(JRField field) throws JRException
	{
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
        
        if(value==null && value instanceof String)
        	return "";
        else        
        	return value ;
    }
}
