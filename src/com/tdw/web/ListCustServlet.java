package com.tdw.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tdw.domain.Cust;
import com.tdw.factory.BasicFactory;
import com.tdw.service.CustService;

public class ListCustServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		//1.调用service中的查询所有用户方法
		List<Cust> list = service.getAllCust();
		//2.将查询到的结果存到request域中
		request.setAttribute("list", list);
		//3.请求转发到listCust.jsp
		request.getRequestDispatcher("/listCust.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}

}
