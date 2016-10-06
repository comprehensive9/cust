package com.tdw.dao;

import java.util.List;

import com.tdw.domain.Cust;

public interface CustDao {

	/**
	 * 根据用户名查找用户
	 * @param name 用户名
	 * @return 找到的用户，如果找不到返回null
	 */
	Cust findUserByName(String name);

	/**
	 * 添加客户
	 * @param cust 添加客户
	 */
	void addCust(Cust cust);

	/**
	 * 查找所有的客户
	 * @return 查找到所有客户的集合，如果没有则返回一个size为0的集合
	 */
	List<Cust> findAllCust();

}
