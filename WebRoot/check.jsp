<%@ page language="java" import="java.sql.*" pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<html>
  <head>
    <title>ckeck</title>
  </head>
  <body>
    <%!
    	public static final String dbdriver = "com.mysql.cj.jdbc.Driver";
    	public static final String url ="jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=GMT%2B8&amp&allowPublicKeyRetrieval=true";
    	public static final String user = "root";
    	public static final String password = "6260513";
    %>
    <%//接受参数
    	String Mid = request.getParameter("mid");
    	String Password = request.getParameter("password");
    	if(Mid == null || Password ==null){//如果直接打开check.jsp显示数据错误
    %>
    		<jsp:forward page="login.jsp">
        		<jsp:param name="error" value="dataerror"/>
        	</jsp:forward>
   	<% 
    	}else{
    		boolean flag = false;
    %>
    <%
	    	Connection conn = null;
	    	PreparedStatement pstmt = null;
	    	ResultSet rs = null;
	    	Class.forName(dbdriver);
	    	conn = DriverManager.getConnection(url,user,password);
	    	String sql = "select count(mid) from member where mid=? and password=?";
	    	pstmt = conn.prepareStatement(sql);
	    	pstmt.setString(1,Mid);
	    	pstmt.setString(2,Password);
	    	rs = pstmt.executeQuery();
	    	if(rs.next()){
				if(rs.getInt(1) == 1 ){//登陆成功
					flag = true;  //修改标记
				}
	    	}
	    	conn.close();//数据库验证完毕后关闭链接
    %>
    <%
    	if(flag){//如果	登陆成功 跳转到Welcome.jsp
    %>
    <jsp:forward page="welcome.jsp"/>
   <%  	
   		 }else{//表示失败
    %>
   		 <jsp:forward page="login.jsp">
    		<jsp:param name="error" value="loginerror"/>
    	</jsp:forward>
  <%
 		}
    }
   %> 
  </body>
</html>
