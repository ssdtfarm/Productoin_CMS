package com.sinosoft.Resource;

import com.sinosoft.Resource.bundle;
import java.io.BufferedInputStream;   
import java.io.FileInputStream;   
import java.io.FileNotFoundException;   
import java.io.FileOutputStream;   
import java.io.IOException;   
import java.io.InputStream;   
import java.io.OutputStream;   
import java.util.Properties;   
  
  
/**  
* @author  
* @version  
*/   
public class PropertiesManage {   
    //属性文件的路径    
	static String mPath = System.getProperty("user.dir")+"\\src\\com\\sinosoft\\Resource\\";
	static String profilepath = mPath+ "LocalStrings_EN.properties";

    /**  
    * 采用静态方法  
    */   
    private static Properties props = new Properties();   
    static {   
        try {   
            props.load(new FileInputStream(profilepath));   
        } catch (FileNotFoundException e) {   
            e.printStackTrace(); 
            System.err.println("ERROR:PropertiesManage.java类中出现严重的问题。需要解决！！！");
            //System.exit(-1);   
        } catch (IOException e) { 
        	System.err.println("ERROR:PropertiesManage.java类中出现严重的问题。需要解决！！！");
        	e.printStackTrace(); 
        	// return;
        	// System.exit(-1);   
        }   
    }   
  
    /**  
    * 读取属性文件中相应键的值  
    * @param key  
    *            主键  
    * @return String  
    */   
    public static String getKeyValue(String key) {   
        return props.getProperty(key);   
    }   
  
    /**  
    * 根据主键key读取主键的值value  
    * @param filePath 属性文件路径  
    * @param key 键名  
    */   
    public static String readValue(String filePath, String key) {   
        Properties props = new Properties();   
        try {   
            InputStream in = new BufferedInputStream(new FileInputStream(   
                    filePath));   
            props.load(in);   
            String value = props.getProperty(key);   
            System.out.println(key +"键的值是："+ value);   
            return value;   
        } catch (Exception e) {   
            e.printStackTrace();   
            return null;   
        }   
    }   
      
    /**  
    * 更新（或插入）一对properties信息(主键及其键值)  
    * 如果该主键已经存在，更新该主键的值；  
    * 如果该主键不存在，则插件一对键值。  
    * @param keyname 键名  
    * @param keyvalue 键值  
    */   
    public static void writeProperties(String mprofilepath,String keyname,String keyvalue) {          
        try {   
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。    
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。    
            OutputStream fos = new FileOutputStream(mprofilepath);   
            props.setProperty(keyname, keyvalue);   
            // 以适合使用 load 方法加载到 Properties 表中的格式，    
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流    
            props.store(fos, "Update '" + keyname + "' value");  
            System.out.println("Update '" + keyname + "' value:"+keyvalue);
        } catch (IOException e) {   
            System.err.println(""+bundle.getString("waitForTran")+"");   
        }   
    }   
  
    /**  
    * 更新properties文件的键值对  
    * 如果该主键已经存在，更新该主键的值；  
    * 如果该主键不存在，则插件一对键值。  
    * @param keyname 键名  
    * @param keyvalue 键值  
    */   
    public void updateProperties(String keyname,String keyvalue) {   
        try {   
            props.load(new FileInputStream(profilepath));   
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。    
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。    
            OutputStream fos = new FileOutputStream(profilepath);              
            props.setProperty(keyname, keyvalue);   
            // 以适合使用 load 方法加载到 Properties 表中的格式，    
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流    
            props.store(fos, "Update '" + keyname + "' value");  
            System.out.println("Update '" + keyname + "' value:"+keyvalue);
        } catch (IOException e) {   
            System.err.println(""+bundle.getString("waitForTran")+"");   
        }   
    }   
    //测试代码    
//    public static void main(String[] args) {   
////        readValue(profilepath, "MAIL_SERVER_PASSWORD");   
////        writeProperties(profilepath,"MAIL_SERVER_INCOMING", "这是我的邮件");          
////        System.out.println("操作完成");   
//    	//System.out.println(System.getProperty("user.dir"));
//
//    }   
}   
