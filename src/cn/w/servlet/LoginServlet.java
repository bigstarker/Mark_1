package cn.w.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	public static final String dbdriver = "com.mysql.cj.jdbc.Driver";
	public static final String url ="jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=GMT%2B8&amp&allowPublicKeyRetrieval=true";
	public static final String user = "root";
	public static final String password = "6260513";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/pages/error.jsp";
		String msg = null;
		String Url = null;
		String Mid = request.getParameter("mid");
    	String Password = request.getParameter("password");
    	System.out.println(Mid + Password);
    		boolean flag = false;
	    	Connection conn = null;
	    	PreparedStatement pstmt = null;
	    	ResultSet rs = null;
	    	try{
		    	Class.forName(dbdriver);
		    	conn = DriverManager.getConnection(url,user,password);
		    	String sql = "select count(mid) from member where mid=? and password=?";
		    	pstmt = conn.prepareStatement(sql);
		    	pstmt.setString(1,Mid);
		    	pstmt.setString(2,Password);
		    	rs = pstmt.executeQuery();
		    	if(rs.next()){
					if(rs.getInt(1) == 1 ){//登陆成功
						System.out.println("登陆成功");
						flag = true;  //修改标记
						msg = "Scuuess";
						Url = "/welcome.jsp";
					}else{
						System.out.println("密码错误");
						msg = "loginerror";
						Url = "/login.jsp";
					}
					path = "/pages/forward.jsp";
		    	}
		    	conn.close();//数据库验证完毕后关闭链接
	    	}catch(Exception e){
	    		e.getStackTrace();
	    	}
    	request.setAttribute("msg",msg);
    	request.setAttribute("url",Url);
	    request.getRequestDispatcher(path).forward(request, response);
	    System.out.println("msg+++"+msg);
	    System.out.println("Url++++"+Url);
		System.out.println("path++++"+path);
		 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
