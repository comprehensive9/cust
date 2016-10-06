package com.tdw.service;

import java.util.List;

import com.tdw.dao.CustDao;
import com.tdw.domain.Cust;
import com.tdw.factory.BasicFactory;

public class CustServiceImpl implements CustService {

	CustDao dao = BasicFactory.getFactory().getInstance(CustDao.class);

	@Override
	public void addCust(Cust cust) {
		// 1.检查用户名是否存在
		if (dao.findUserByName(cust.getName()) != null) {
			throw new RuntimeException("用户名已经存在！");
		}
		// 2.调用dao中的方法增加用户
		dao.addCust(cust);
	}

	@Override
	public List<Cust> getAllCust() {
		return dao.findAllCust();
	}

}
