package com.tdw.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.tdw.domain.Cust;
import com.tdw.factory.BasicFactory;
import com.tdw.service.CustService;

public class AddCustServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 1.封装数据，校验数据
		Cust cust = new Cust();
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		try {
			BeanUtils.populate(cust, request.getParameterMap());
			//单独处理爱好
			String[] prefs = request.getParameterValues("preference");
			StringBuffer buffer = new StringBuffer();
			for(String pref : prefs){
				buffer.append(pref+",");
			}
			String pref = buffer.substring(0, buffer.length()-1);
			cust.setPreference(pref);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		// 2.调用service方法中的添加客户方法
		service.addCust(cust);
		// 3.重定向回到主页
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
