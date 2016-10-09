package com.tdw.service;

import java.util.List;

import com.tdw.domain.Cust;
import com.tdw.domain.Page;

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

	/**
	 * 根据用户id查找用户是否存在
	 * @param id
	 * @return 如果存在则返回用户信息，不存在则返回null
	 */
	Cust findUserById(int id);

	/**
	 * 修改用户信息
	 * @param cust
	 */
	void updateCust(Cust cust);

	/**
	 * 根据客户id删除客户
	 * @param id
	 */
	void delCustById(String id);

	/**
	 * 批量删除客户，通过事务管理
	 * @param ids 批量删除客户的id
	 */
	void batchDel(String[] ids);

	/**
	 * 条件查询客户
	 * @param cust 封装了查询条件的javabean
	 * @return 符合条件的客户
	 */
	List<Cust> findCustByCond(Cust cust);

	/**
	 * 分页查询客户信息
	 * @param thispage 当前查询的页
	 * @param rowperpage 每页显示多少条记录
	 * @return 封装了查询结果数据的javabean
	 */
	Page pageCust(int thispage, int rowperpage);


}
