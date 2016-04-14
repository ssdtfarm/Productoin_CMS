
/**
* 文件名：I18NMSG.java
*
* 版本信息：
* 日期：2014-11-25
* Copyright Sinosft Corporation 2014
* 版权所有
*
*/
	
package com.sinosoft.utility;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.apache.commons.fileupload.servlet.ServletRequestContext;


/**
 *
 * 项目名称：ccms
 * 类名称：I18NMSG
 * 创建人：lixianpeng
 * 创建时间：2014-11-25 上午9:07:18
 * 修改人：lixianpeng
 * 修改时间：2014-11-25 上午9:07:18
 * 修改备注：获得资源文件
 * @version
 *
 */

public final class bundle{


	public static String getString(String msg_id){
		
		Locale locale = Locale.getDefault();
        System.out.println(locale.toString());
        // 获得资源文件
        ResourceBundle rb = ResourceBundle.getBundle("i18n.LocalStrings", locale);       
        // 获得相应的key值       
		String str = rb.getString(msg_id);
		return str;
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println(getString("G0000036042"));
//	}

}
