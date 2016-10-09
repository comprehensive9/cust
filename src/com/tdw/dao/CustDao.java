package com.tdw.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tdw.domain.Cust;

public interface CustDao {

	/**
	 * 根据用户名查找用户
	 * 
	 * @param name
	 *            用户名
	 * @return 找到的用户，如果找不到返回null
	 */
	Cust findUserByName(String name);

	/**
	 * 添加客户
	 * 
	 * @param cust
	 *            添加客户
	 */
	void addCust(Cust cust);

	/**
	 * 查找所有的客户
	 * 
	 * @return 查找到所有客户的集合，如果没有则返回一个size为0的集合
	 */
	List<Cust> findAllCust();

	/**
	 * 根据用户id查找用户
	 * 
	 * @param id
	 *            用户id
	 * @return 如果存在则返回一个用户对象，否则返回null
	 */
	Cust findUserByID(int id);

	/**
	 * 修改客户信息
	 * 
	 * @param cust
	 */
	void update(Cust cust);

	/**
	 * 根据客户id删除客户
	 * 
	 * @param id
	 */
	void delCustById(String id);

	/**
	 * 根据客户批量id删除用户，事务管理
	 * 
	 * @param id
	 */
	void delCustByIdWithTrans(Connection conn, String id) throws SQLException;

	/**
	 * 条件查询客户
	 * 
	 * @param cust
	 *            封装了查询条件的javabean
	 * @return 符合条件的客户
	 */
	List<Cust> findCustByCond(Cust cust);

	/**
	 * 查询总共有多少条客户信息
	 * 
	 * @return 共有多少条客户记录数
	 */
	int getCountRow();

	/**
	 * 查询每页客户的数据集
	 * 
	 * @param from
	 *            查询的起始记录
	 * @param rowperpage
	 *            每页多少条记录
	 * @return 当前一页的客户数据集
	 */
	List<Cust> getCustByPage(int from, int rowperpage);

}
