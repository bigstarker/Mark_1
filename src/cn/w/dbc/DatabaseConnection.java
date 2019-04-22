package cn.w.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 负责数据库连接与关闭
 * @author 唐尼哥
 *
 */
public class DatabaseConnection {
	private static final String dbdriver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/ceo?useSSL=false&serverTimezone=GMT%2B8&amp&allowPublicKeyRetrieval=true";
	private static final String user = "root";
	private static final String password = "6260513";
	private  Connection conn = null;	
	
	/**
	 * 在构造方法里进行conn对象实例化，直接取得数据库的连接
	 * @throws SQLException 
	 */
	public DatabaseConnection(){
		try {
			Class.forName(dbdriver);
			this.conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 取得一个数据库的连接，实例化Connection对象
	 */
	public Connection getConnection(){
		return this.conn;
	}
	
	/**
	 * 关闭数据库连接
	 */
	public void close(){
		if(this.conn!=null){
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
