/*�����������ݿ�,���еķ��������Զ��Ǿ�̬��,�õ�Connection����**/
package Tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//�����������ݿ�,���еķ��������Զ��Ǿ�̬��,�õ�Connection����
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
	
	//�������ݿ�����
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
	 
	//�������ݿ�,����Connection����
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
	
	//������һ������,��Ҫ�����Ƿ��Զ��ύʱʹ��
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
