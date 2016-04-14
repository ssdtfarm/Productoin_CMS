/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.lis.f1print;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


//生成文件名字,以vts模板名,加日期,加操作员,加一个递增的序列好.
public class FileNameQueue
{
    public static final String LINE="/";
    public static final String LINE2="-";
    public static final String PATTERN="yyMMddHHmm";
    public static final String XML=".xml";
    public static final String PRE="Pre";
    public static final String XML_PRE=".xmlPre";
    private static int nHead = 0;


    public FileNameQueue()
    {
    }

    public static synchronized String getFileName(String filepath,String templateOp)
    {
        StringBuffer sb=new StringBuffer(0);
        SimpleDateFormat sdf=new SimpleDateFormat(PATTERN);
        String dateStr=sdf.format(new Date());
        String fileName=null;

        while(true)
        {
            if (nHead !=Integer.MAX_VALUE)
            {
                nHead++;
            }
            else
            {
                nHead = 0;
            }
            //sb.append(filepath);
            //sb.append(line);
            sb.setLength(0);
            sb.append(templateOp);
            //sb.append(LINE2);
            sb.append(dateStr);
            sb.append(LINE2);
            sb.append(nHead);
            //sb.append(xml);
            fileName=sb.toString();

            if(canUseName(filepath,fileName))break;
        }
        //System.out.println(fileName);
        return fileName;
    }

    public static synchronized boolean canUseName(String filepath,String fileName)
    {
        StringBuffer sb=new StringBuffer(0);
        sb.setLength(0);
        sb.append(filepath);
        sb.append(LINE);
        sb.append(fileName);
        sb.append(XML);
        String fullFileName=sb.toString();
        sb.append(PRE);
        String fullFileNamePre=sb.toString();
        sb.setLength(0);

        File f=new File(fullFileName);
        File fPre=new File(fullFileNamePre);

        return (!f.exists()&&!fPre.exists());
    }

    public static synchronized boolean rename(String filepath,String fileName)
    {
        boolean b=false;
        StringBuffer sb=new StringBuffer(0);
        sb.setLength(0);
        sb.append(filepath);
        sb.append(LINE);
        sb.append(fileName);
        sb.append(XML);
        String fullFileName=sb.toString();
        sb.append(PRE);
        String fullFileNamePre=sb.toString();
        sb.setLength(0);

        File f=new File(fullFileName);
        File fPre=new File(fullFileNamePre);
        if(fPre.exists())
        {
            //System.out.println("XML_PRE name "+fPre.getAbsoluteFile());
            b= fPre.renameTo(f);
            //System.out.println("XML name "+f.getAbsoluteFile());
            //System.out.println("rename "+b);
            //System.out.println("fPre.exists() "+fPre.exists());
        }

        return b;
    }

//    public static void main(String[] args)
//    {
//        System.out.println(FileNameQueue.rename("C:\\nclprint","Contract-001-2005-08-29-14-06-1"));
//    }


}
