package cn.w.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.w.factory.ServiceFactory;
import cn.w.vo.Dept;

@SuppressWarnings("serial")
public class DeptServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = "/pages/error.jsp";
		String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		 if(status != null){
			 if("insert".equals(status)){
				 path = this.insert(request);
			 }else if("delete".equals(status)){
				 path = this.delete(request);
			 }else if("update".equals(status)){
				 path = this.update(request);
			 }else if("updatePre".equals(status)){
				 path = this.updatePre(request);
			 }else if("list".equals(status)){
				 path = this.list(request);
			 }
		 }
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	public String insert(HttpServletRequest request){
		Dept vo = new Dept();
	  	vo.setDeptno(Integer.parseInt(request.getParameter("deptno")));
	  	vo.setDname(request.getParameter("dname"));
	  	vo.setLoc(request.getParameter("loc"));
	  	String msg = "部门信息增加失败";
	  	try {
			if(ServiceFactory.getIDeptServiceInstance().insert(vo)){
				msg = "部门信息增加成功";  		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	request.setAttribute("msg",msg);//forward.jsp主要进行信息提示
	  	request.setAttribute("url", "/pages/back/admin/dept/dept_insert.jsp");
		return "/pages/forward.jsp";
	}
	public String list(HttpServletRequest request){
		try {
			request.setAttribute("allDepts", ServiceFactory.getIDeptServiceInstance().list());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/pages/back/admin/dept/dept_list.jsp";
	}
	public String delete(HttpServletRequest request){
	  	String dno = request.getParameter("dno");   //元数据使用"|"分割
	    String msg = "部门信息删除失败";
	  	if(!(dno == null || "".equals(dno))){		//dno有数据
	  		String  result [] = dno.split("\\.") ;
		  	Set<Integer> ids = new HashSet<Integer>();
		  	for(int x = 0 ; x < result.length; x++){
		  		ids.add(Integer.parseInt(result[x]));
		  	}try {
				if(ServiceFactory.getIDeptServiceInstance().delete(ids)){
					msg = "部门信息删除成功";  		
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	  	}
	  	request.setAttribute("msg", msg);
	  	request.setAttribute("url", "/pages/back/admin/dept/DeptServlet/list");
		return "/pages/forward.jsp";
	}
	public String updatePre(HttpServletRequest request){
		int deptno = Integer.parseInt(request.getParameter("deptno"));
	  	try {
			request.setAttribute("dept",ServiceFactory.getIDeptServiceInstance().updatePre(deptno));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/pages/back/admin/dept/dept_update.jsp";
	}
	public String update(HttpServletRequest request){ 
		Dept vo = new Dept();
	  	vo.setDeptno(Integer.parseInt(request.getParameter("deptno")));
	  	vo.setDname(request.getParameter("dname"));
	  	vo.setLoc(request.getParameter("loc"));
	  	String msg = "部门信息修改失败";
	  	try {
			if(ServiceFactory.getIDeptServiceInstance().update(vo)){
				msg = "部门信息修改成功";  		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	request.setAttribute("msg", msg);
	  	request.setAttribute("url", "/pages/back/admin/dept/DeptServlet/list");
		return "/pages/forward.jsp";
	}
}
