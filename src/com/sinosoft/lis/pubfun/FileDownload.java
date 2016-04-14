package com.sinosoft.lis.pubfun;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinosoft.utility.CError;
import com.sinosoft.utility.CErrors;

public class FileDownload extends HttpServlet {

	CErrors errors = new CErrors();

	private void buildError(String funName, String errMsg) {
		CError error = new CError();
		error.moduleName = "Download";
		error.functionName = funName;
		error.errorMessage = errMsg;
		errors.addOneError(error);
	}

	// Initialize global variables
	public void init() throws ServletException {
		System.out.println("Download Servlet Init!");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// Process the HTTP Get request
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Downloading files......");
		HttpSession session = request.getSession();
		System.out.println("sessionID=" + session.getId());
		String filepath = (String) session.getAttribute("filepath");
		String filename = (String) session.getAttribute("filename");
//		String filepath = (String) request.getAttribute("filepath");
//		String filename = (String) request.getAttribute("filename");
		System.out.println("filepath=" + filepath); 
		if (filepath == null || filepath.equals("")) {
			String msg = "********************** Filepath not exists! *****************************";
			System.out.println(msg);
			buildError("download", msg);
			return ;
		}
		if(filename == null || "".equals(filename)) {
			File file = new File(filepath);
			filename = file.getName();
		}
		File file = new File(filepath);
		if (!file.exists()) {
			String msg = "********************** File not exists! *****************************";
			System.out.println(msg);
			buildError("download", msg);
			return ;
		}
		OutputStream out = null;
		InputStream is = null;
		try {
			String contentType = "application/octet-stream;charset=iso-8859-1";
//			String contentType = "application/x-download;charset=gbk";
			response.setContentType(contentType);
			StringBuffer contentDisposition = new StringBuffer();
//			System.out.println("filename(iso): " + new String(filename.getBytes("iso-8859-1"),"iso-8859-1"));
//			System.out.println("filename(utf8): " + new String(filename.getBytes("utf-8"),"iso-8859-1"));
//			System.out.println("filename(gbk): " + new String(filename.getBytes("gbk"),"iso-8859-1"));
//			System.out.println("filename(iso-gbk): " + new String(filename.getBytes("iso-8859-1"),"gbk"));
//			System.out.println("filename(iso-utf): " + new String(filename.getBytes("iso-8859-1"),"utf-8"));
//			System.out.println("filename(gbk-utf): " + new String(filename.getBytes("gbk"),"utf-8"));
//			System.out.println("filename(utf-gbk): " + new String(filename.getBytes("utf-8"),"gbk"));
			System.out.println("filename: " + filename);
//			System.out.println("file.encoding: " + System.getProperty("file.encoding"));
			filename = java.net.URLEncoder.encode(filename, "UTF-8");
			System.out.println("filename: " + filename);
			contentDisposition.append("attachment;filename=");
			contentDisposition.append(filename);
//			response.setHeader("Content-Disposition", new String(
//					contentDisposition.toString().getBytes(
//							System.getProperty("file.encoding")), "iso-8859-1"));
			response.setHeader("Content-Disposition", new String(
			contentDisposition.toString().getBytes(
					System.getProperty("file.encoding")), "iso-8859-1"));
			System.out.println("filepath=" + filepath);
			out = response.getOutputStream();
			out.flush();

			byte[] bytes = new byte[4 * 1024];
			is = new BufferedInputStream(new FileInputStream(filepath));
			int b = -1;
			while ((b = is.read(bytes)) > -1) {
				out.write(bytes, 0, b);
//				System.out.println(b);
			}
			out.flush();
			System.out.println("After writting-------");

		} catch (Exception e) {
			e.printStackTrace();
			String msg = "********************** IOException occured! *****************************";
			System.out.println(msg);
			buildError("download", msg);
		} finally {
			System.out.println("Closing stream------");
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Closing stream22------");
		}
		//清空session，防止不停刷新页面，进行恶意DOS攻击
		session.removeAttribute("filepath");
		session.removeAttribute("filename");
		
	}

	// Clean up resources
	public void destroy() {
	}

}