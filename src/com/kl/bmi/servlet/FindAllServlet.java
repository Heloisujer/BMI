package com.kl.bmi.servlet;

import java.util.List;
import com.kl.bmi.pojo.Record;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kl.bmi.pojo.Record;
import com.kl.bmi.service.RecordService;
import com.kl.bmi.service.impl.RecordServiceImpl;

@WebServlet("/servlet/FindAllServlet")
public class FindAllServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//…Ë÷√±‡¬ÎŒ Ã‚
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		RecordService recordService = new RecordServiceImpl();
		List<Record> records = recordService.findAll();
		request.getSession().setAttribute("records", records);
		HttpSession session = request.getSession();
		session.setAttribute("index", "1");
		session.setMaxInactiveInterval(5);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



