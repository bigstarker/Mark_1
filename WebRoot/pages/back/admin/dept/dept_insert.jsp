<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String insertUrl = basePath + "pages/back/admin/dept/DeptServlet/insert";
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
     </script>
     
  </head>
  
  <body>
    <form action="<%=insertUrl%>" method="post" onsubmit="return validateInsert()" >
    	 <table border="1.5px solid" width="100%" bgcolor="#f2f2f2">
            <tr onmousemove="changeColor(this,'#ffffff')" onmouseout="changeColor(this,'#f2f2f2')">
                <td colspan="3" style="text-align: center"> <span class="title" >增加部门信息</span></td>
            </tr>
    		 <tr onmousemove="changeColor(this,'#ffffff')" onmouseout="changeColor(this,'#f2f2f2')" style="text-align: center">
    			<td width="15%">部门编号：</td>
    			<td width="45%"><input type="text" name="deptno" id="deptno" class="init" onblur="validateDeptno()"></td>
    			<td width="40%"><span id="deptnoMsg"></span></td>
    		</tr>
    		 <tr onmousemove="changeColor(this,'#ffffff')" onmouseout="changeColor(this,'#f2f2f2')" style="text-align: center">
    			<td width="15%">部门名称：</td>
    			<td width="45%"><input type="text" name="dname" id="dname" class="init" onblur="validateDname()"></td>
    			<td width="40%"><span id="dnameMsg"></span></td>
    		</tr>
    		 <tr onmousemove="changeColor(this,'#ffffff')" onmouseout="changeColor(this,'#f2f2f2')" style="text-align: center">
    			<td width="15%">部门位置：</td>
    			<td width="45%"><input type="text" name="loc" id="loc" class="init" onblur="validateLoc()"></td>
    			<td width="40%"><span id="locMsg"></span></td>
    		</tr>
    		 <tr onmousemove="changeColor(this,'#ffffff')" onmouseout="changeColor(this,'#f2f2f2')" style="text-align: center">
    			<td colspan="3" >
    				<input type="submit" value="增加">
    				<input type="reset" value="重置">
    				<input type="button" onclick="go_list()" value="部门列表" id="button1"> 
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
