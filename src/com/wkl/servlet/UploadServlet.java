package com.wkl.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.wkl.pojo.User;

@SuppressWarnings("serial")
@WebServlet("/up.do")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		User user = (User) req.getSession().getAttribute("p");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	    String createdate = sdf.format(date);
		Part part = req.getPart("img");
		InputStream is = part.getInputStream();
		String realFileName = user.getUphone()+ "@" + createdate + ".jpg";
//		OutputStream os = new FileOutputStream(new File("E:/JAVA/ego/adopt-web/WebContent/img/", realFileName));
		OutputStream os = new FileOutputStream(new File("/usr/java/tomcat/apache-tomcat-9.0.24/webapps/adopt-web/img/", realFileName));
		int len = 0;
		byte[] buff = new byte[1024*8];
		
		while((len = is.read(buff)) > -1) {
			os.write(buff, 0, len);
			
		}
		is.close();
        os.close();
        resp.setCharacterEncoding("utf-8");
//        resp.getWriter().print("upload success!!");
//        resp.getWriter().print("/adopt-web/WebContent/img/"+ realFileName);
        resp.getWriter().print("/adopt-web/img/"+ realFileName);
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
////		Part part = req.getPart("img");
////		String h = part.getHeader("content-disposition");
////		String filename = part
//		Part part = req.getPart("img");
//		// 获取到文件名
//		String logoName = part.getSubmittedFileName();
//		// 如果文件名不为空，就写入到硬盘
//		if (!"".equals(logoName)) {
//			// 获取项目路径
//			String localPath = "E:/JAVA/ego/adopt-web/WebContent/img/" + logoName;
//			// 获取tomcat路径
//			String xmPath = this.getServletContext().getRealPath("img/" + logoName);
//			// 写入到tomcat路径
//			part.write(xmPath);
//			// copy到项目路径
//			FileUtils.copyFile(new File(xmPath), new File(localPath));
//
//		}
//
//	}
