
/**
* 文件名：bundle.java
*
* 版本信息：
* 日期：2014-11-25
* Copyright sinosoft Corporation 2014
* 版权所有
*
*/
	
package com.sinosoft.Resource;

import java.util.Locale;
import java.util.MissingResourceException;

import org.apache.axis.session.Session;


/**
 *
 * 类名称：I18NMSG
 * 类描述：根据key获得国际化资源value
 * 创建人：lixianpeng
 * 创建时间：2014-11-25 下午2:51:39
 * 修改备注：
 * @version
 *
 */

public class bundle {
	private  static ResourceManager bundle= new ResourceManager("com.sinosoft.Resource");
	
	public static void initBundle(){
		bundle= new ResourceManager("com.sinosoft.Resource");
	}
	
	public static  String getString(String key) {
//		System.out.println("key--"+key);
		String str = key;
		  try{
		        str = bundle.getString(key);
	        }catch(MissingResourceException mre){
		        str = "未_"+key;
	        }
//		  System.out.println("value--"+str);
		return str;
	}

}
