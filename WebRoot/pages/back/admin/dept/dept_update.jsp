<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.w.vo.*" %>
<%@ page import="cn.w.factory.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String updateUrl = basePath + "pages/back/admin/dept/DeptServlet/update";
String listUrl = basePath + "pages/back/admin/dept/DeptServlet/list";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	
    <title>雇员管理</title>
    <base href="<%=basePath %>">
    <link type="text/css" rel="stylesheet" href="css/mldn.css">
    <script type="text/javascript" src="js/mldn.js"></script>
    <script type="text/javascript" src="js/dept.js"></script>
     
    <script>
		function go_list(){
			window.location = "<%=listUrl%>";
		}
		alert("dept_update.jsp");
     </script>
     
  </head>
  
  <body>
  <%
  	//接受地址重写传递而来的部门编号
  	Dept vo = (Dept) request.getAttribute("dept");
  	 if(vo != null){
  %>
    <form action="<%=updateUrl%>" method="post" onsubmit="return validateUpdate()" >
    	 <table border="1.5px solid" width="100%" bgcolor="#f2f2f2">
            <tr onmousemove="changeColor(this,'#ffffff')" onmouseout="changeColor(this,'#f2f2f2')">
                <td colspan="3" style="text-align: center"> <span class="title" >编辑部门信息</span></td>
            </tr>
    		 <tr onmousemove="changeColor(this,'#ffffff')" onmouseout="changeColor(this,'#f2f2f2')" style="text-align: center">
    			<td width="15%">部门编号：</td>
    			<td width="45%"><span class="init" ><%=vo.getDeptno()%></span></td>
    			<td width="40%"><span id="deptnoMsg"></span></td>
    		</tr>
    		 <tr onmousemove="changeColor(this,'#ffffff')" onmouseout="changeColor(this,'#f2f2f2')" style="text-align: center">
    			<td width="15%">部门名称：</td>
    			<td width="45%"><input type="text" name="dname" id="dname" class="init" onblur="validateDname()" value="<%=vo.getDname()%>"></td>
    			<td width="40%"><span id="dnameMsg"></span></td>
    		</tr>
    		 <tr onmousemove="changeColor(this,'#ffffff')" onmouseout="changeColor(this,'#f2f2f2')" style="text-align: center">
    			<td width="15%">部门位置：</td>
    			<td width="45%"><input type="text" name="loc" id="loc" class="init" onblur="validateLoc()" value="<%=vo.getLoc()%>"></td>
    			<td width="40%"><span id="locMsg"></span></td>
    		</tr>
    		 <tr onmousemove="changeColor(this,'#ffffff')" onmouseout="changeColor(this,'#f2f2f2')" style="text-align: center">
    			<td colspan="3" >
    				<input type="hidden" id="deptno" name="deptno" value="<%=vo.getDeptno() %>">
    				<input type="submit" value="修改">
    				<input type="reset" value="重置">
    				<input type="button" onclick="go_list()" value="部门列表" id="button1"> 
    			</td>
    		</tr>
    	</table>
    </form>
   <%
	}
   %> 
  </body>
</html>
