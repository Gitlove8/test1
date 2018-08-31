package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.GoodsDao;
import com.domain.Goods;

@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();
//		out.print("Hello Servlet!!!!");
//		request.setCharacterEncoding("utf-8");  
		String action = request.getParameter("action");  
		if("look".equals(action)){
			PrintWriter out = response.getWriter();
			out.print("Hello Servlet!!!!");
}
			GoodsDao dao = new GoodsDao();
			Map<String, Goods> map = dao.query();
			HttpSession session = request.getSession();
			session.setAttribute("map", map); 
			response.sendRedirect("show.jsp");
		
			
	}
}
