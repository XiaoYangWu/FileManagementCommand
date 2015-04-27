/*用于连接数据库,所有的方法和属性都是静态的,得到Connection对象**/
package Tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//用于连接数据库,所有的方法和属性都是静态的,得到Connection对象
public class ConnectDatabase {
	 private static String url;
	 private static String user;
	 private static String password;
	
	 public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		ConnectDatabase.url = url;
	}
	public static String getUser() {
		return user;
	}
	public static void setUser(String user) {
		ConnectDatabase.user = user;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		ConnectDatabase.password = password;
	}
	
	//加载数据库驱动
	public static void init(){
           
	        String driverClass="com.mysql.jdbc.Driver";
			url="jdbc:mysql://localhost:3306/file_management";
			user="root";
			password="919817113";
			try{
				Class.forName(driverClass);
			}
			catch(ClassNotFoundException ce){
				ce.printStackTrace();
			}
	 }
	 
	//连接数据库,返回Connection对象
	public static Connection connect(){
		Connection conn=null;
		 try{
			conn=DriverManager.getConnection(url,user,password);
	       
	        
	     }
		 catch(SQLException se){se.printStackTrace();}
		 finally{
			 return conn;
		 }
		
	 }
	
	//重载上一个方法,需要设置是否自动提交时使用
	 public static 	Connection connect(boolean bool){
		 Connection conn=null;
		 try{
			conn=DriverManager.getConnection(url,user,password);
			conn.setAutoCommit(bool);
	       
	        
	     }
		 catch(SQLException se){se.printStackTrace();}
		 finally{
			 return conn;
		 }
		
	 }
}
