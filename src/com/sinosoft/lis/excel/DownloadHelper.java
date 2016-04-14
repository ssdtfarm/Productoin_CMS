package com.sinosoft.lis.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import com.sinosoft.lis.pubfun.PubFun;

public class DownloadHelper {
	
	/**
	 * 文件下载功能
	 * 参数：response，文件全路径，下载时的文件显示名
	 */
	public static void download(HttpServletResponse response, String filePath, String displayName) {
		if (filePath == null || filePath.equals("")) {
			System.out.println("==============File Path is null, return;===============");
			return ;
		}
		if (displayName == null || displayName.equals("")) {
			displayName = (filePath.lastIndexOf(File.separator) == -1) ? filePath : (filePath.substring(filePath.lastIndexOf(File.separator) + 1));
		}
		response.reset();
		response.setContentType("application/octet-stream");
		try {
			response.setHeader("Content-Disposition","attachment; filename="+ new String(displayName.getBytes(),"ISO8859-1"));
			OutputStream os = response.getOutputStream();		
			FileInputStream fis = PubFun.createFileInputStream(filePath);
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = fis.read(b)) > 0) {
				os.write(b, 0, i);
			}
			fis.close();
			os.flush();
			os.close();
			
		} catch (Exception e) {
			System.out.println("==============File download exception in DownloadHelper===============");
			e.printStackTrace();
		}
	}
	

	/**
	 * 文件下载功能
	 * 参数：response，文件全路径名
	 */
	public static void download(HttpServletResponse response, String filePath) {
		download(response, filePath, null);
	}

}
