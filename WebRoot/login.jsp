<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
   <title>login</title>
   <link rel="stylesheet" type="text/css" href="css/mldn.css"> 
   <script type="text/javascript" src="js/mldn.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
  </head>	
  
  <body>
  <h1 style="text-align: center">用户登陆</h1>
  <% //如果由check.jsp跳转回login.jsp,那么表示用户名密码错误，属于错误信息
  if (request.getParameter("msg") != null){
	  if("dataerror".equals(request.getParameter("msg"))){
		  System.out.println("check"+"数据错误，直接打开check");
   %>
		  <h2 style="text-align: center"> <font color="red"> 数据错误！</font></h2> 
   <%
	  }
	  
   if("Success".equals(request.getAttribute("msg"))){
	 %>
	   <h1><font color=green>登陆成功！</font></h1>
	<%
   }
	if("loginerror".equals(request.getAttribute("msg"))){
		System.out.println("login.jsp"+"用户名或密码错误");
   %>
	<h2 style="text-align: center"><font color="red"> 用户名或密码错误！登陆失败！</font></h2> 
	<%
		}
	}
	%>
  <form action="LoginServlet" method="post" onsubmit = "return Validate()" >
 	<table border=1 cellpadding="5"  cellspacing="0" width="100%" bgcolor="#f2f2f2">
 		<tr  onmousemove="changeColor(this,'#ffffff')" onmouseout="changeColor(this,'#f2f2f2')" >
 			<td width="15%">用户名：</td>
 			<td width="45%"><input type="text" name="mid" id="mid" class="init" onblur="ValidateMid()"></td>
 			<td width="40%"><span name="midMsg" id="midMsg"></span></td>
 		</tr>
 		<tr  onmousemove="changeColor(this,'#ffffff')" onmouseout="changeColor(this,'#f2f2f2')" >
 			<td>密&nbsp;&nbsp;码：</td>
 			<td><input type="password" name="password" id="password" class="init" onblur="ValidatePassWord()"></td>
 			<td><span name="passwordMsg" id="passwordMsg"></span></td>
 		</tr>
 		<tr  onmousemove="changeColor(this,'#ffffff')" onmouseout="changeColor(this,'#f2f2f2')">
 			<td colspan="3" style="text-align: center" >
	 			<input type="submit" value="登陆">
	 			<input type="reset" value="重置">
 			</td>
 		</tr>
 	</table>
  </form>
  </body>
</html>
