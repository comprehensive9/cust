package com.tdw.service;

import java.util.List;

import com.tdw.domain.Cust;

public interface CustService {

	/**
	 * 添加客户的方法
	 * @param cust 封装了客户的信息
	 */
	void addCust(Cust cust);

	/**
	 * 获取所有客户信息的集合
	 * @return 封装了客户信息的集合
	 */
	List<Cust> getAllCust();


}
