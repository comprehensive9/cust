package com.tdw.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tdw.factory.BasicFactory;
import com.tdw.service.CustService;

public class DelCustServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		//1.获取客户的id
		String id = request.getParameter("id");
		//2.调用service中的方法删除客户
		service.delCustById(id);
		//3.转发到ListCustServlet页面
		request.getRequestDispatcher("/servlet/ListCustServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
