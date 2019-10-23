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
@WebServlet("/yes/list.do")
public class AdoptedServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StarDao starDao = new StarDaoImpl();
		try {
			List<Stars> list = starDao.findAllAdopt();
			req.setAttribute("List", list);
			req.setAttribute("type", "yes");
			req.getRequestDispatcher("/Star/list.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
