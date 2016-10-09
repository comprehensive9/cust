package com.tdw.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tdw.domain.Cust;
import com.tdw.factory.BasicFactory;
import com.tdw.service.CustService;

public class CustInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustService service = BasicFactory.getFactory().getInstance(
				CustService.class);
		// 1.获取携带过来的id
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		// 2.根据id查找用户是否存在
		Cust cust = service.findUserById(id);
		if(cust==null){
			throw new RuntimeException("要修改的用户不存在哦，亲~~~");
		}
		// 3.如果存在，则将用户信息放到request域中
		request.setAttribute("cust", cust);
		// 4.转发到updateCust.jsp页面
		request.getRequestDispatcher("/updateCust.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
