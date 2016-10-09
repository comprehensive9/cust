package com.tdw.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tdw.factory.BasicFactory;
import com.tdw.service.CustService;

public class BatchDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		// 1.获取批量删除的id
		String[] ids = request.getParameterValues("delId");
		if(ids==null){
			throw new RuntimeException("没有可以删除的用户了哦，亲~~~");
		}
		// 2.调用service中的方法批量删除客户
		service.batchDel(ids);
		// 3.转发到ListCustServlet
		request.getRequestDispatcher("/servlet/ListCustServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
