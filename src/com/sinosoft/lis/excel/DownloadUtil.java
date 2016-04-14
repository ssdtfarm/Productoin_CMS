package com.sinosoft.lis.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.sinosoft.lis.pubfun.PubFun;

/**
 * 
 * @version 1.0 2008-3-25
 * @author WangWei
 * @author Evan
 * 
 */
class DownloadUtil {
	// private static FileInputStream getInputStream() {
	// return null;
	// }
	DownloadUtil() {
		// TODO Auto-generated constructor stub
	}

	private static void writeTo(OutputStream out, InputStream in) {
		try {
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int aRead = 0;
		try {
			while ((aRead = in.read()) != -1 & in != null) {
				out.write(aRead);
			}
		} catch (IOException e) {
			System.out.println("文件下载异常---" + e.getMessage());
			System.out.println("可能是因为下载被取消");
			// e.printStackTrace();
		}
		try {
			out.flush();
		} catch (IOException e) {
			System.out.println("文件下载异常---" + e.getMessage());
			System.out.println("可能是因为下载被取消");
			// e.printStackTrace();
		}

	}

	/**
	 * 将指定的文件写到指定的输出流中
	 * 
	 * @param out
	 * @param filePath
	 */
	public static void writeTo(OutputStream out, String filePath) {
		InputStream in = null;
		try {
			in = PubFun.createFileInputStream(filePath);
			if (in != null) {
				writeTo(out, in);
			}
		} catch (Exception e) {
			System.out.println("文件下载异常---" + e.getMessage());
			System.out.println("可能是因为下载被取消");
			// e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
					
				} catch (IOException e) {
					System.out.println("文件下载异常---" + e.getMessage());
					System.out.println("可能是因为下载被取消");
					// e.printStackTrace();
				}
		}
	}
}
