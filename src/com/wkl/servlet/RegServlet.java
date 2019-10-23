package com.wkl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wkl.dao.UserDao;
import com.wkl.dao.UserDaoImpl;
import com.wkl.pojo.User;

/**
 * Servlet implementation class RegServlet
 */
@SuppressWarnings("serial")
@WebServlet("/reg.do")
public class RegServlet extends HttpServlet {
	private UserDao ud = new UserDaoImpl();

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String pwd = req.getParameter("passwd");
		
		User user = new User();
		
		try {
			if(ud.findUserByPhone(phone).getUphone() != null) {
				req.setAttribute("msg","此电话已经注册");
//				resp.getWriter().print("<script>alert('此电话已经注册')</script>");
			}
//			else if(name == "" || phone == "" || email == "" || pwd == "") {
//				req.setAttribute("msg","注册内容不能为空！");
////				resp.getWriter().print("<script>alert('注册内容不能为空！')</script>");
//			}
			else {
				System.out.println(email + name);
				user.setEmail(email);
				user.setPwd(pwd);
				user.setUname(name);
				user.setUphone(phone);
				user.setSid(null);
				ud.insertUser(user);
				
				req.setAttribute("msg","注册成功！");
				resp.sendRedirect("People/login.jsp");
			}
		}catch ( Exception e) {
			System.out.println("RegServlet运行错误！");
			e.printStackTrace();// TODO: handle exception
		}
	}

}
