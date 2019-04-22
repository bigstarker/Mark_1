package cn.w.factory;

import java.sql.Connection;

import cn.w.dao.IDeptDAO;
import cn.w.dao.impl.DeptDAOImpl;

public class DAOFactory {
	public static IDeptDAO getIDepaDAOInstance(Connection conn){
		return new DeptDAOImpl(conn);
	}
}
