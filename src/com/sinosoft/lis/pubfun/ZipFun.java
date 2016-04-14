package com.sinosoft.lis.pubfun;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.*;

public class ZipFun {

    public ZipFun() {}

    /**
     * ZIP文件 压缩<br>
     * 该压缩方法是带压缩文件的所有路径的，即在压缩包内会有传入文件路径的所有层次文件夹 <br>
     * @param String filepath 需要压缩的文件夹目录
     * @param String zipFile 压缩后的文件名路径
     * @return
     */
    public boolean ZipEncrypt(String filepath,String zipFile) {
        try {
            byte b[] = new byte[1024];

            List fileList = allFile(filepath);

            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
            // 使用输出流检查
            CheckedOutputStream cs = new CheckedOutputStream(fileOutputStream,
                    new CRC32());
            // 声明输出zip流
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(
                    cs));

            for (int i = 0; i < fileList.size(); i++) {
                InputStream in = new FileInputStream((String) fileList.get(i));
                String fileName = ((String) (fileList.get(i))).replace(File.separatorChar, '/');
                fileName = fileName.substring(fileName.indexOf("/") + 1);
                File t = new File(fileName);
                ZipEntry e = new ZipEntry(t.getName());
                out.putNextEntry(e);
                int len = 0;
                while ((len = in.read(b)) != -1) {
                    out.write(b, 0, len);
                }
                out.closeEntry();
            }
            out.close();
            System.out.println("done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    
    /**
     * ZIP文件 压缩<br>
     * 该压缩方法是带压缩文件的所有路径的，即在压缩包内会有传入文件路径的所有层次文件夹<br>
     * @param List fileList 需要压缩的文件列表
     * @param String zipFile 压缩后的文件路径
     * @return
     */
    public boolean ZipEncrypt(List fileList,String zipFile) {
        try {
            byte b[] = new byte[1024];

            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
            // 使用输出流检查
            CheckedOutputStream cs = new CheckedOutputStream(fileOutputStream,
                    new CRC32());
            // 声明输出zip流
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(
                    cs));

            for (int i = 0; i < fileList.size(); i++) {
                InputStream in = new FileInputStream((String) fileList.get(i));
                String fileName = ((String) (fileList.get(i))).replace(File.separatorChar, '/');
                fileName = fileName.substring(fileName.indexOf("/") + 1);
                File t = new File(fileName);
                ZipEntry e = new ZipEntry(t.getName());
                out.putNextEntry(e);
                int len = 0;
                while ((len = in.read(b)) != -1) {
                    out.write(b, 0, len);
                }
                out.closeEntry();
            }
            out.close();
            System.out.println("done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    
    private static List allFile(String path) {
        List list = new ArrayList();
        File file = new File(path);
        String[] array = null;
        String sTemp = "";

        if (file.isDirectory()) {
        } else {
            return null;
        }
        array = file.list();
        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                sTemp = path + array[i];
                file = new File(sTemp);
                if (file.isDirectory()) {
                    allFile(sTemp + "/");

                } else {
                    list.add(sTemp);
                }
            }
        } else {
            return null;
        }

        return list;
    }

    /**
     * 
     * @param String zipFilePath ZIP文件路径
     * @param String extFilePath  解压后的路径
     * @return
     */
    public boolean ZipDec(String zipFilePath, String extFilePath) {
        try {
            InputStream in = null;
            ZipEntry entry = null;
            ZipFile zipFile = new ZipFile(zipFilePath);

            File files = new File(extFilePath);
            if (files.exists() == false) {
                files.mkdirs();
            }

            String inpath = extFilePath;
            Enumeration ea = zipFile.entries();
            while (ea.hasMoreElements()) {
                entry = (ZipEntry) ea.nextElement();
                String entryName = entry.getName();

                if (entry.isDirectory()) {
                    File file = new File(extFilePath + entryName);
                    file.mkdirs();
                    inpath += file.getName();
                } else {
                    File newfile = new File(extFilePath
                            + "\\"
                            + entryName.substring(0,
                                    entryName.lastIndexOf("/") + 1));
                    // System.out.println(newfile.getPath().toString());
                    if (newfile.exists()) {

                    } else {
                        newfile.mkdirs();
                    }
                    newfile = new File(extFilePath + File.separator + entryName);
                    newfile.createNewFile();

                    FileOutputStream os = new FileOutputStream(newfile);
                    in = zipFile.getInputStream(entry);
                    byte[] buf = new byte[5 * 1024];// 5*1024 扩大
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        os.write(buf, 0, len);
                    }
                    os.close();
                    in.close();
                }
            }
            zipFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

//    public static void main(String[] args) {
////        String zipFilePath = "C:/PengRui.zip";
////        String extFilePath = "C:/yanxzip/";
//        List list = new ArrayList();
//        String temp ="G:\\yanxingFireflyDEV\\ui\\vtsfile\\ClaimSpecial_86_admin_001.xls";
//        list.add(temp);
//        String filepath = "C:/1/";
//        String zipFile = "C:/ziptest.zip";
//        ZipFun zipFun = new ZipFun();
//        zipFun.ZipEncrypt(list, zipFile);
//
//    }

}
