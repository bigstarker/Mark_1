package cn.w.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.w.dao.IDeptDAO;
import cn.w.vo.Dept;

public class DeptDAOImpl implements IDeptDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	public DeptDAOImpl(Connection conn){
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Dept vo) throws Exception {
		String sql = "insert into dept(deptno,dname,loc) values (?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getDeptno());
		this.pstmt.setString(2,vo.getDname());
		this.pstmt.setString(3, vo.getLoc());
		return this.pstmt.executeUpdate() > 0;
	}


	@Override
	public boolean doUpdate(Dept vo) throws Exception {
		String sql = "update dept set dname=?,loc=? where deptno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getDname());
		this.pstmt.setString(2, vo.getLoc());
		this.pstmt.setInt(3, vo.getDeptno());
		return this.pstmt.executeUpdate() > 0;
	}
	
	
	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		if(ids == null ||ids.size() == 0) {//没有要删的数据
			return false;
		}
		StringBuffer sql = new StringBuffer();
		sql.append("delete from dept where deptno  in (");
		Iterator<Integer> iter = ids.iterator();
		while(iter.hasNext()) {
			sql.append(iter.next()).append(",");
		}
		sql.delete(sql.length()-1, sql.length()).append(")");
		this.pstmt = this.conn.prepareStatement(sql.toString());
		return this.pstmt.executeUpdate() == ids.size() ;
	}

	@Override
	public Dept findById(Integer id) throws Exception {
		Dept vo = null;
		String sql = "select deptno,dname,loc from dept where deptno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()) {
			vo = new Dept();
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setLoc(rs.getString(3));
		}
		return  vo; 
	}
	
	@Override
	public List<Dept> findAll() throws Exception {
		List<Dept> all = new ArrayList<Dept>();
		String sql = "select deptno,dname,loc from dept";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()) {
			Dept vo = new Dept();
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setLoc(rs.getString(3));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Dept> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
			throws Exception {
		throw new Exception("under building!");
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		throw new Exception("under building!");
	}

}
