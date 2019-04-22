<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.w.vo.*" %>
<%@ page import="cn.w.factory.*" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String insertUrl = basePath + "pages/back/admin/dept/dept_insert.jsp";
	String deleteUrl = basePath + "pages/back/admin/dept/DeptServlet/delete";
	String updatePreUrl = basePath + "pages/back/admin/dept/DeptServlet/updatePre";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link type="text/css" rel="stylesheet" href="css/mldn.css">
    <script type="text/javascript" src="js/mldn.js"></script>
    <title>部门列表</title>
    <script>
	    function go_insert(){
			window.location = "<%=insertUrl%>";
		}
    </script>
  </head>
  
  <body>
   <%
   		 List<Dept> all = (List<Dept>) request.getAttribute("allDepts");
   		  Iterator <Dept> iter = all.iterator();
   %>
   <table border="1" cellpadding="5" cellspacing="0" width="100%" bgcolor="#f2f2f2">
   		<tr onmouseover="changeColor(this,'#ffffff')" onmouseout="changeColor(this,'#f2f2f2')" style="text-align: center">
   			<td width="10%"><input type="checkbox" id="selall" onclick="checkboxSelect(this,'deptno')"></td>
   			<td width="25%">部门编号</td>
   			<td width="25%">部门名称</td>
   			<td width="25%">部门位置</td>
   			<td width="15%">操作</td>
   		</tr>
   		<% 
   			while(iter.hasNext()){
   				Dept vo = iter.next();
   		%>
   		<tr onmouseover="changeColor(this,'#ffffff')" onmouseout="changeColor(this,'#f2f2f2')" style="text-align: center">
   			<td><input type="checkbox" id="deptno" name="deptno" value="<%=vo.getDeptno()%>"></td>
   			<td><%=vo.getDeptno() %></td>
   			<td><%=vo.getDname() %></td>
   			<td><%=vo.getLoc() %></td>
   			<td><a href="<%=updatePreUrl%>?deptno=<%=vo.getDeptno()%>">修改</a></td>
   		</tr>
   		<%
   			}
   		%>   		
   		<tr onmouseover="changeColor(this,'#ffffff')" onmouseout="changeColor(this,'#f2f2f2')" style="text-align: center">
   			<td colspan="5">
   			<input type="button" id="button1" value="删除部门信息" onclick="deleteAll('<%=deleteUrl%>','dno','deptno')">
   			<input type="button" id="button2" value="增加新部门" onclick="go_insert()">
   			</td>
   			<td>
   		</tr>
   </table>
  </body>
</html>
