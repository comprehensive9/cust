package com.tdw.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tdw.domain.Page;
import com.tdw.factory.BasicFactory;
import com.tdw.service.CustService;

public class PageCustServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取当前要显示的页和每页要显示的记录条数
		int thispage = Integer.parseInt(request.getParameter("thispage"));
		int rowperpage = 5;
		//2.调用service中分页查询客户的方法，查找出客户信息
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		Page page = service.pageCust(thispage,rowperpage);
		//3.存入request域中，带到pageList.jsp页面去显示
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pageList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
