package com.wkl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wkl.dao.StarDao;
import com.wkl.dao.StarDaoImpl;
import com.wkl.pojo.Stars;
import com.wkl.pojo.User;

@SuppressWarnings("serial")
@WebServlet("/star/add.do")
public class StarAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");
			int age = Integer.parseInt(req.getParameter("age"));
			String photo = req.getParameter("photo");
			int sex = Integer.parseInt(req.getParameter("sex"));
			String address = req.getParameter("address");
			String phone = req.getParameter("phone");
			String type = req.getParameter("type");
			String breed = req.getParameter("breed");
			User us = (User) req.getSession().getAttribute("p");
			int momId = us.getId();
			Stars st = new Stars();
			StarDao ad = new StarDaoImpl();

//			resp.setCharacterEncoding("text/html;charset=utf-8");

			st.setSname(name);
			st.setAge(age);
			st.setPhoto(photo);
			st.setSex(sex);
			st.setAddress(address);
			st.setSphone(phone);
			st.setType(type);
			st.setBreed(breed);
			st.setIsAdopt(0);
			st.setMomId(momId);
			resp.setContentType("text/html;charset=UTF-8");
			if (ad.insertStar(st)) {
				resp.getWriter().print("添加成功！");
			} else {
				resp.getWriter().print("添加失败！");
			}
		} catch (IOException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
}
