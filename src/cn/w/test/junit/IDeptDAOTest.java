package cn.w.test.junit;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import cn.w.factory.ServiceFactory;
import cn.w.vo.Dept;
import junit.framework.TestCase;

public class IDeptDAOTest {

	@Test
	public void testDoCreate() {
		Dept vo = new Dept();
		vo.setDeptno(3);
		vo.setDname("sj");
		vo.setLoc("bj");
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().insert(vo));
		}catch(Exception e) {
			 e.printStackTrace();
		}
	}

	@Test
	public void testDoUpdate() {
		Dept vo = new Dept();
		vo.setDeptno(5);
		vo.setDname("j1");
		vo.setLoc("jj");
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().update(vo));
		}catch(Exception e) {
			 e.printStackTrace();
		}
	}

	@Test
	public void testDoRemoveBatch() {
		Set<Integer> ids = new HashSet<Integer>();
		ids.add(3);
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().delete(ids));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFindById() {
		try {
			TestCase.assertNotNull(ServiceFactory.getIDeptServiceInstance().updatePre(5));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFindAll() {
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().list().size() > 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
