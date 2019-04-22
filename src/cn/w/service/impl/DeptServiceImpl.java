package cn.w.service.impl;

import java.util.List;
import java.util.Set;

import cn.w.dbc.DatabaseConnection;
import cn.w.factory.DAOFactory;
import cn.w.service.IDeptService;
import cn.w.vo.Dept;

public class DeptServiceImpl implements IDeptService {
	private DatabaseConnection dbc = new DatabaseConnection();
	
	@Override
	public boolean insert(Dept vo) throws Exception {
		try{
			if(DAOFactory.getIDepaDAOInstance(this.dbc.getConnection()).findById(vo.getDeptno()) == null){
				return DAOFactory.getIDepaDAOInstance(this.dbc.getConnection()).doCreate(vo);
			}
			return false;
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public boolean update(Dept vo) throws Exception {
		try{
			return DAOFactory.getIDepaDAOInstance(this.dbc.getConnection()).doUpdate(vo);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		try{
			return DAOFactory.getIDepaDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public List<Dept> list() throws Exception {
		try{
			return DAOFactory.getIDepaDAOInstance(this.dbc.getConnection()).findAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public Dept updatePre(Integer id) throws Exception {
		try{
			return DAOFactory.getIDepaDAOInstance(this.dbc.getConnection()).findById(id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
}
