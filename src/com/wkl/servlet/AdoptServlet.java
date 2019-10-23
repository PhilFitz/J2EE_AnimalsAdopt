package com.wkl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wkl.dao.StarDao;
import com.wkl.dao.StarDaoImpl;
import com.wkl.dao.UserDao;
import com.wkl.dao.UserDaoImpl;
@SuppressWarnings("serial")
@WebServlet("/people/adopt.do")
public class AdoptServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao ud = new UserDaoImpl();
		StarDao sd = new StarDaoImpl();
		String strId = req.getParameter("id");
		int id = 0;
		if( strId == null) {
			id = 0;
		}else {
			id = Integer.parseInt(strId);
		}
		
		int starId = Integer.parseInt(req.getParameter("starId"));
		resp.setContentType("text/html;charset=utf-8");
		System.out.println(id);
		System.out.println(starId);
		try {
			if(0 == id) {
				resp.getWriter().print("您还没有登录，不能领养");
			}else {
				ud.adoptStar(id, starId);
				sd.adoptStar(starId, id);
				resp.getWriter().print(	"领养成功==请私信它的原主人，三天后会核实若领养不成功，此星人仍会在网站寻找新主人");
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
