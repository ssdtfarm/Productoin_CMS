package com.sinosoft.Resource;

import java.util.Hashtable;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.jspsmart.upload.Request;
import com.sinosoft.utility.ExeSQL;

public class ResourceManager {
	ResourceBundle bundle = null;

	// 用于保存ResourceBundle的实例对象
	private static Hashtable managers = new Hashtable();
	
	// 构造函数，得到ResourceBundle的实例
	public ResourceManager(String packageName) {
		// 获取配置文件的绝对路径，注意后缀为.LocalStrings，不加_EN或_CN，系统将根据本地语言自动获取相应配置文件
		HttpServletRequest request = RequestFilter.threadLocalRequest.get();
		Locale locale = (Locale) request.getSession().getAttribute("locale");
//		String initLan = (String) request.getSession().getAttribute("initLan");
//		request.getSession().invalidate();
//		request.getSession().setAttribute("locale",locale);
//		request.getSession().setAttribute("initLan",initLan);
		if(locale==null){
			locale = Locale.getDefault();	
			System.out.println("ResourceManager----locale----Fail_______________________________"+locale);
		}
		System.out.println("ResourceManager----locale----"+locale);
		String bundleName = packageName + ".LocalStrings";

		// 获取 ResourceBundle 对象

		bundle = PropertyResourceBundle.getBundle(bundleName,locale);
 	}

	// 得到某个属性的值
	public String getString(String key) {
		return bundle.getString(key);
	}


	// 得到ResourceBundle对象的实例
	public synchronized static ResourceManager getManager(String packageName) {
		ResourceManager mgr = (ResourceManager) managers.get(packageName);
		if (mgr == null) {
			mgr = new ResourceManager(packageName);
			managers.put(packageName, mgr);
		}
		return mgr;
	}

	// 得到ResourceBundle对象的实例
	public synchronized static ResourceManager getManager(Class cls) {
		return getManager(cls.getPackage().getName());
	}

//	public static void main(String[] args) {
//		ResourceManager bundle = new ResourceManager("com.sinosoft.Resource");
//		System.out.print(bundle.getString("MENU_10"));
//	}
}
