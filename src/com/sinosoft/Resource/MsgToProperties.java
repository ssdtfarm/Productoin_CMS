package com.sinosoft.Resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;

/**
 * local cn-中文 en-英文 ja-日文
 * */
public class MsgToProperties {
    private ExeSQL exe = new ExeSQL();
    /**
     * 获取属性文件
     * @param local cn-中文 en-英文 ja-日文
     * */
    private void getMsg(String path,String local) {
        String localName = local;
        if (local.equals("cn")) {
            localName = "zh_CN";
        }else if (local.equals("tr")) {
            localName = "zh_TW";
        }else if (local.equals("en")) {
            localName = "en";
        }


        int maxnum = 8000;

        SSRS ssrs = exe.execSQL("select msg_id,msg_" + local + " From msg_info order by Msg_Type,SeqNo ");
        if (ssrs != null && ssrs.getMaxRow() > 0) {
            if (ssrs.getMaxRow() <= 8000) {
                File srcFile = new File(path +  "LocalStrings_" + localName +
                                ".properties");
                Properties tProperties = new Properties();
                for (int i = 1; i <= ssrs.getMaxRow(); i++) {
                    String key = ssrs.GetText(i, 1);
                    String value = ssrs.GetText(i, 2);
                    if(value==null){
                    	value=key;
                    }
                    tProperties.setProperty(key, value);
                    System.out.println(key);
                }
                try {
                    saveProerties(tProperties, srcFile);
                } catch (FileNotFoundException e) {
                    // TODO 自动生成 catch 块
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO 自动生成 catch 块
                    e.printStackTrace();
                }

            } else {
                int count = 1;
                File srcFile = new File(path +  "LocalStrings_" + localName +
                        ".properties");
                try {
                Properties tProperties = new Properties();
                for (int j = 1; j <= ssrs.getMaxRow() / maxnum + 1; j++) {
                    for (int i = count; i <= ssrs.getMaxRow(); i++) {
                        String key = ssrs.GetText(i, 1);
                        String value = ssrs.GetText(i, 2);
                        System.out.println(key+"="+value);
                        if(value==null){
                        	value=key;
                        }
                        tProperties.setProperty(key, value);
                        count++;
                        if(count/maxnum==j)
                            break;
                    }
                }

                
                    saveProerties(tProperties, srcFile);
                } catch (FileNotFoundException e) {
                	System.out.println(count);
                    // TODO 自动生成 catch 块
                    e.printStackTrace();
                } catch (IOException e) {
                	System.out.println(count);
                    // TODO 自动生成 catch 块
                    e.printStackTrace();
                }

            }
        }

    }

    /**
     * 存储属性文件
     * */
    private void saveProerties(Properties tProperties, File tFile) throws
            FileNotFoundException, IOException {
        tProperties.store(new FileOutputStream(tFile), "");
    }

    /**
     * 转换数据库为属性文件
     * @param local cn-中文 en-英文 ja-日文
     * */
    public void deal(String path,String localType) {

         getMsg(path,localType);

    }

//    private String i18nPath = "/i18n/";
//    private String path;

//    public String getPath() {
//        return path;
//    }
//
//    public void setPath(String path) {
//        this.path = path;
//    }

//	private void usage() {
//		System.out.println("* * * * * * * * Usage * * * * * * ");
//		System.out.println("java com.sinosoft.i18n.tools.MsgToProperties destpath");
//		System.out.println("Example : com.sinosoft.i18n.tools.MsgToProperties c:/BOC_Insu/");
//	}
    
    
    public static final String CN = "cn";
    public static final String EN = "en";
    public static final String TR = "tr";
//    public void createFile(String directory, String language) {
//    	MsgToProperties tMsgToProperties = new MsgToProperties();
//        tMsgToProperties.setPath(directory);
//        tMsgToProperties.deal(language);
//    }
    
    public static void main(String[] args) {
        MsgToProperties tMsgToProperties = new MsgToProperties();
        String dirpath = "src/com/sinosoft/Resource/";
        
        tMsgToProperties.deal(dirpath,"en");
		tMsgToProperties.deal(dirpath,"cn");
        tMsgToProperties.deal(dirpath,"tr");
    }
}
