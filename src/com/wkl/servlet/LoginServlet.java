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

@SuppressWarnings("serial")
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{
	/**
	 * 登录Servlet
	 */

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phone = req.getParameter("phone");
		String pwd = req.getParameter("pwd");// TODO 自动生成的方法存根
		String msg = null;
		
		try {
			UserDao ud = new UserDaoImpl();
			User user = ud.findUserByPhone(phone);
			if(user.getUphone()==null) {
				msg = "该用户还未注册";
				req.setAttribute("msg", msg);
				req.getRequestDispatcher("People/login.jsp").forward(req, resp);
//				resp.sendRedirect("People/login.jsp");
			}else {
				if(!user.getPwd().equals(pwd)) {
					msg = "密码输入错误！";
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("People/login.jsp").forward(req, resp);
				}else {
					req.getSession().setAttribute("p", user);
					req.getRequestDispatcher("index.jsp").forward(req, resp);
				}
			}
		}catch (Exception e) {
			System.out.println("loginServlet出错");
			e.printStackTrace();// TODO: handle exception
		}
	}
}
