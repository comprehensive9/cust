package com.tdw.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.tdw.domain.Cust;
import com.tdw.factory.BasicFactory;
import com.tdw.service.CustService;

public class UpdateCustServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			// 1.封装数据
			Cust cust = new Cust();
			CustService service = BasicFactory.getFactory().getInstance(
					CustService.class);
			BeanUtils.populate(cust, request.getParameterMap());
			// 单独处理爱好
			String[] prefs = request.getParameterValues("preference");
			StringBuffer buffer = new StringBuffer();
			for (String pref : prefs) {
				buffer.append(pref + ",");
			}
			String pref = buffer.substring(0, buffer.length() - 1);
			cust.setPreference(pref);
			// 2.调用service中的方法修改用户信息
			service.updateCust(cust);
			// 3.请求转发到listCust.jsp页面
			request.getRequestDispatcher("/servlet/ListCustServlet").forward(
					request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
