package com.tdw.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.ScalarDataModel;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.tdw.domain.Cust;
import com.tdw.util.DaoUtils;

public class CustDaoImpl implements CustDao {

	public Cust findUserByName(String name) {
		String sql = "select * from customer where name=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<Cust>(Cust.class), name);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void addCust(Cust cust) {
		String sql = "insert into customer values(null,?,?,?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DaoUtils.getSource());
		try {
			runner.update(sql, cust.getName(), cust.getGender(),
					cust.getBirthday(), cust.getCellphone(), cust.getEmail(),
					cust.getPreference(), cust.getType(), cust.getDescription());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Cust> findAllCust() {
		String sql = "select * from customer";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Cust>(Cust.class));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Cust findUserByID(int id) {
		String sql = "select * from customer where id=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<Cust>(Cust.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void update(Cust cust) {
		String sql = "update customer set name=? ,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql, cust.getName(), cust.getGender(),
					cust.getBirthday(), cust.getCellphone(), cust.getEmail(),
					cust.getPreference(), cust.getType(),
					cust.getDescription(), cust.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void delCustById(String id) {
		String sql = "delete from customer where id=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void delCustByIdWithTrans(Connection conn, String id)
			throws SQLException {
		String sql = "delete from customer where id = ?";
		QueryRunner runner = new QueryRunner();
		runner.update(conn, sql, id);
	}

	public List<Cust> findCustByCond(Cust cust) {

		String sql = "select * from customer where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if (cust.getName() != null && !"".equals(cust.getName())) {
			sql += "and name like ?";
			list.add("%" + cust.getName() + "%");
		}

		if (cust.getGender() != null && !"".equals(cust.getGender())) {
			sql += "and gender=?";
			list.add(cust.getGender());
		}

		if (cust.getType() != null && !"".equals(cust.getType())) {
			sql += "and type=?";
			list.add(cust.getType());
		}

		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			if (list.size() <= 0) {
				return runner.query(sql, new BeanListHandler<Cust>(Cust.class));
			} else {
				return runner.query(sql, new BeanListHandler<Cust>(Cust.class),
						list.toArray());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public int getCountRow() {
		String sql = "select count(*) from customer";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return ((Long) runner.query(sql, new ScalarHandler())).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Cust> getCustByPage(int from, int rowperpage) {
		String sql = "select * from customer limit ?,?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Cust>(Cust.class),
					from, rowperpage);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
