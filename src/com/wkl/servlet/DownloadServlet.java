package com.wkl.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/down.do")
public class DownloadServlet extends HttpServlet{
	
	public static void copy(InputStream in, java.io.OutputStream out)
			throws IOException {
		byte[] buffer = new byte[1024 * 10];
		while ((in.read(buffer)) != -1) {
			out.write(buffer);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = req.getParameter("file");
//		File img = new File("E:/JAVA/ego" + fileName);
		File img = new File("/usr/java/tomcat/apache-tomcat-9.0.24/webapps" + fileName);
		InputStream is = new FileInputStream(img);
		copy(is, resp.getOutputStream());
		is.close();
		
	}
}
