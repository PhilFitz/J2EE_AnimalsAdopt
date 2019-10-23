package com.wkl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wkl.dao.StarDao;
import com.wkl.dao.StarDaoImpl;
import com.wkl.pojo.Stars;
@SuppressWarnings("serial")
@WebServlet("/other/list.do")
public class OtherServlet extends HttpServlet {
	private StarDao StarDao = new StarDaoImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<Stars> List = StarDao.findAllOther();
			req.setAttribute("List", List);
			req.setAttribute("type", "no");
			req.getRequestDispatcher("/Star/list.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
