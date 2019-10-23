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

@SuppressWarnings("serial")
@WebServlet("/show.do")
public class StarShowServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Stars s = new Stars();
		StarDao sd = new StarDaoImpl();
		try {
			s = sd.getStar(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("s", s);
		req.getRequestDispatcher("/Star/show.jsp").forward(req, resp);
	}
}
