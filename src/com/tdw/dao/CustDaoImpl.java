package com.tdw.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tdw.domain.Cust;
import com.tdw.util.DaoUtils;

public class CustDaoImpl implements CustDao {

	@Override
	public Cust findUserByName(String name) {
		String sql = "select * from customer where name=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<Cust>(Cust.class), name);

		} catch (SQLException e) {
			e.printStackTrace();
			new RuntimeException(e);
			return null;
		}
	}

	@Override
	public void addCust(Cust cust) {
		String sql = "insert into customer values(null,?,?,?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DaoUtils.getSource());
		try {
			runner.update(sql, cust.getName(), cust.getGender(), cust.getBirthday(), cust.getCellphone(),
					cust.getEmail(), cust.getPreference(), cust.getType(), cust.getDescription());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Cust> findAllCust() {
		String sql = "select * from customer";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Cust>(Cust.class));

		} catch (SQLException e) {
			e.printStackTrace();
			new RuntimeException(e);
			return new ArrayList<Cust>();
		}
	}

}
