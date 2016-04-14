package com.sinosoft.lis.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.utility.ExeSQL;

/**
 * 
 * @version 1.0 2008-2-22
 * @author Wang Wei
 * @author Evan
 * 
 */
public class Config {
	// 存放报表模板的绝对路径
//	private static String TEMPLET_PATH; //"E:" + File.separator + "templet";

	// 存放报表的绝对路径
//	private static String WORK_PATH; //"E:" + File.separator + "tmp";

//	static {
//		File f = new File("sfd");
//		System.out.println("当前路径：" + f.getAbsolutePath());
//		File file = new File("report.properties");
//		Properties p = new Properties();
//		FileInputStream in = null;
//		try {
//			in = new FileInputStream(file);
//			p.load(in);
//			TEMPLET_PATH = p.getProperty("TEMPLET_PATH");
//			WORK_PATH = p.getProperty("WORK_PATH");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (in != null)
//				try {
//					in.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//		}
//	}

//	public Config() {
//	}

	/**
	 * @return 存放报表模板的文件夹的绝对路径
	 */
	public static String getTempletPath() {
//		return get("f1print/TEMPLATE_EXCEL");
		ExeSQL tExeSQL=new ExeSQL();
		return get(tExeSQL.getOneValue("select SysvarValue from ldsysvar where sysvar = 'ExportPath' "));
	}

	/**
	 * @return 存放报表的文件夹的绝对路径
	 */
	public static String getWorkPath() {
//		return get("vtsfile");
		ExeSQL tExeSQL=new ExeSQL();
		return get(tExeSQL.getOneValue("select SysvarValue from ldsysvar where sysvar = 'ExportFilePath' "));
	}
	
	/**add by Maqingyu
	 * 用于设置自动生成excel报表绝对路径
	 * @param sysvar
	 * @return
	 */
	public static String getWorkPath(String sysvar, String funName) {
//		ExeSQL tExeSQL=new ExeSQL();
//		return getByFunName(tExeSQL.getOneValue("select SysvarValue from ldsysvar where sysvar = 'ExportFilePath' "),funName);
		return getByFunName(sysvar,funName);
		
	}

	/**add by Maqingyu
	 * 用于获得自动生成excel报表绝对路径
	 * @param name
	 * @return
	 */
	public static String getByFunName(String sysvar,String funName){
		String value = null;
		ExeSQL tExeSQL=new ExeSQL();
		String filePath = tExeSQL.getOneValue("select SysvarValue from ldsysvar where sysvar = '"+sysvar+"' ");
		//前台报表路径
		if(sysvar.equals("OnwerExportFilePath"))
		{
//			try {
//				
//				String cls=getFullPathRelateClass("../../../../../../"+filePath+"/"+funName,Config.class);
//				value = cls;
//			
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} 
			
			value = filePath+"/"+funName;
			
		}
		//自动报表路径
		if(sysvar.equals("AutoExportFilePath"))
		{
			value = filePath+"/"+funName+"/"+PubFun.getCurrentDate().replace("-", "");
		}
		
		if(sysvar.equals("PortalExportFilePath"))
		{
			value = filePath+"/"+funName+"/"+PubFun.getCurrentDate().replace("-", "");
		}
		
		System.out.println("value====:::"+value);
		return value;
	}
	
	
	
	public static String get(String name) {
		String value = null;
		try {
		    String cls=getFullPathRelateClass("../../../../../../"+name,Config.class);
			value = cls;
			System.out.println(value);
			System.out.println("get&&value====:::::"+value);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return value;
	}
	
	
	/**
	  * 获取一个类的class文件所在的绝对路径。 这个类可以是JDK自身的类，也可以是用户自定义的类，或者是第三方开发包里的类。
	  * 只要是在本程序中可以被加载的类，都可以定位到它的class文件的绝对路径。
	  * 
	  * @param cls
	  *            一个对象的Class属性
	  * @return 这个类的class文件位置的绝对路径。 如果没有这个类的定义，则返回null。
	  */
	 public static String getPathFromClass(Class cls) throws IOException {
	     String path = null;
	     if (cls == null) {
	      throw new NullPointerException();
	     }
	     URL url = getClassLocationURL(cls);
	     if (url != null) {
	      path = url.getPath();
	      if ("jar".equalsIgnoreCase(url.getProtocol())) {
	       try {
	        path = new URL(path).getPath();
	       } catch (MalformedURLException e) {
	       }
	       int location = path.indexOf("!/");
	       if (location != -1) {
	        path = path.substring(0, location);
	       }
	      }
	      File file = new File(path);
	      path = file.getCanonicalPath();
	     }
	     return path;
	    }
	 
	 /**
	  * 这个方法可以通过与某个类的class文件的相对路径来获取文件或目录的绝对路径。 通常在程序中很难定位某个相对路径，特别是在B/S应用中。
	  * 通过这个方法，我们可以根据我们程序自身的类文件的位置来定位某个相对路径。
	  * 比如：某个txt文件相对于程序的Test类文件的路径是../../resource/test.txt，
	  * 那么使用本方法Path.getFullPathRelateClass("../../resource/test.txt",Test.class)
	  * 得到的结果是txt文件的在系统中的绝对路径。
	  * 
	  * @param relatedPath
	  *            相对路径
	  * @param cls
	  *            用来定位的类
	  * @return 相对路径所对应的绝对路径
	  * @throws IOException
	  *             因为本方法将查询文件系统，所以可能抛出IO异常
	  */
	 public static String getFullPathRelateClass(String relatedPath, Class cls)
	   throws IOException {
	  String path = null;
	  if (relatedPath == null) {
	   throw new NullPointerException();
	  }
	  String clsPath = getPathFromClass(cls);
	  File clsFile = new File(clsPath);
	  
	  String tempPath = clsFile.getParent() + File.separator + relatedPath;
	  
//	  System.out.println("config.tempPath=="+tempPath);
	  
	  File file = PubFun.createFile(tempPath);
	  path = file.getCanonicalPath();
	  return path;
	 }
	 
	 /** add by Maqingyu
	  * 用于获得自动生成excel路径
	  * @param relatedPath
	  * @return
	  * @throws IOException
	  */
	 
	 public static String getFullPathRelateClass(String relatedPath)
			   throws IOException {
			  String path = null;
			  if (relatedPath == null) {
			   throw new NullPointerException();
			  }
			  String tempPath = null;
			  
			  tempPath = relatedPath;
			  
			  System.out.println("config.tempPath=="+tempPath);
			  
			  File file = new File(tempPath);
			  path = file.getCanonicalPath();
			  return path;
			 }
	 
	 

	 /**
	  * 获取类的class文件位置的URL。这个方法是本类最基础的方法，供其它方法调用。
	  */
	 private static URL getClassLocationURL(final Class cls) {
	  if (cls == null)
	   throw new IllegalArgumentException("null input: cls");
	  URL result = null;
	  final String clsAsResource = cls.getName().replace('.', '/').concat(
	    ".class");
	  final ProtectionDomain pd = cls.getProtectionDomain();
	  // java.lang.Class contract does not specify
	  // if 'pd' can ever be null;
	  // it is not the case for Sun's implementations,
	  // but guard against null
	  // just in case:
	  if (pd != null) {
	   final CodeSource cs = pd.getCodeSource();
	   // 'cs' can be null depending on
	   // the classloader behavior:
	   if (cs != null)
	    result = cs.getLocation();

	   if (result != null) {
	    // Convert a code source location into
	    // a full class file location
	    // for some common cases:
	    if ("file".equals(result.getProtocol())) {
	     try {
	      if (result.toExternalForm().endsWith(".jar")
	        || result.toExternalForm().endsWith(".zip"))
	       result = new URL("jar:".concat(
	         result.toExternalForm()).concat("!/")
	         .concat(clsAsResource));
	      else if (new File(result.getFile()).isDirectory())
	       result = new URL(result, clsAsResource);
	     } catch (MalformedURLException ignore) {
	     }
	    }
	   }
	  }

	  if (result == null) {
	   // Try to find 'cls' definition as a resource;
	   // this is not
	   // document．d to be legal, but Sun's
	   // implementations seem to //allow this:
	   final ClassLoader clsLoader = cls.getClassLoader();
	   result = clsLoader != null ? clsLoader.getResource(clsAsResource)
	     : ClassLoader.getSystemResource(clsAsResource);
	  }
	  return result;
	 }
	 
	 
//	 public static void main(String[] args) {
//	        File f = new File("sfd");
//	        System.out.println("当前路径：" + f.getAbsolutePath());
////	      System.out.println(TEMPLET_PATH);
//	    }
}
