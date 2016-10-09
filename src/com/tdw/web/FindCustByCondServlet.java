package com.tdw.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.tdw.domain.Cust;
import com.tdw.factory.BasicFactory;
import com.tdw.service.CustService;

public class FindCustByCondServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("utf-8");
			//1.获取条件查询的数据，并封装成javabean
			Cust cust = new Cust();
			BeanUtils.populate(cust, request.getParameterMap());
			//2.调用service中的条件查询方法
			CustService service = BasicFactory.getFactory().getInstance(CustService.class);
			List<Cust> list = service.findCustByCond(cust);
			//3.将查询到的结果存到request域中，并转发到listCust.jsp页面
			request.setAttribute("list", list);
			request.getRequestDispatcher("/listCust.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
