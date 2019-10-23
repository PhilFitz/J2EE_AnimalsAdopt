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
@WebServlet("/people/update.do")
public class PeopleUpdateServlet extends HttpServlet{
	UserDao ud = new UserDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phone = req.getParameter("phone");
		
		try {
			User user = ud.findUserByPhone(phone);
			req.setAttribute("p", user);
			req.getRequestDispatcher("/People/one.jsp").forward(req, resp);
		}catch (ServletException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String sid = null;
		
		UserDao ud = new UserDaoImpl();
		User user = new User();
		
		try {
			user.setId(id);
			user.setUname(name);
			user.setUphone(phone);
			user.setEmail(email);
			user.setPwd(pwd);
			user.setSid(sid);
			resp.setContentType("text/html;charset=UTF-8");
			if(ud.updateUser(user)) {
				req.getSession().setAttribute("p", user);
				resp.getWriter().print("信息修改成功！");
			}else {
				resp.getWriter().print("信息修改失败！");
			}
		}catch (IOException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
}
