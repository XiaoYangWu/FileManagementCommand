/**处理用户文件统计命令*/
package Command;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListFile {
	 public static void init(Connection conn,String command){
		 String[] temp=command.split(" ");
	    	
	    	if(!temp[0].toLowerCase().equals("listfile")||temp.length>2){//判断用户输入格式是否正确,若不正确提示
	    		System.out.println("命令输入错误,请用一个空格分离命令和参数！");
	    		System.out.println();
	    		System.out.println();
	    		System.out.println("listfile -x");
	    		System.out.println();
	    		System.out.println();
	    		System.out.println("-x    可选,指定要查询的文件名");	
	    		System.out.println();
	    		System.out.println();
	    	}
	    	else{
	    		if(temp.length==1||"*".equals(temp[1]))//用户查询所有文件
	    			doCommand(conn);
	    		else
	    			doCommand(conn,temp[1]);//用户查询某一特定文件
	    	}
	    }
	public static void doCommand(Connection conn){
		System.out.println();
		System.out.println();
		Statement stmt=null;
		ResultSet rs=null;
		
		try{
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from file");
			if(!rs.next()){//若rs为空,数据库中文件表为空,提示用户
				System.out.println("系统当前没有文件,请先上传文件！");
			}
			else{
				int number=1;
				rs.beforeFirst();
				System.out.println("序号                文件名                    上传用户                   文件路径                            文件类型                  文件大小(字节)");//输出表头
			    while(rs.next()){
			      String filename=rs.getString(3);//获取文件名
			      String id=rs.getString(2);//获取上传用户学号
			      String path=rs.getString(4);//获取文件相对工程根目录的路径
				  String type=rs.getString(5);//获取文件类型
				  long size=0;
				  //文件在服务器端完整路径
				  String  serverPath="D:\\JAVA\\eclipse\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\filemanagement"+path;
				  File file=new File(serverPath);
				  size=file.length();//获取文件大小
				  
				  System.out.println(number+"        "+filename+"     "+id+"      "+path+"        "+type+"            "+size);//输出类别信息
				  number++;
			   }
			    System.out.println();
			    System.out.println();
			}
		}catch(SQLException se){se.printStackTrace();}
		finally{
			if(rs!=null){
        		try{
        			rs.close();
        		}
        		catch(SQLException se){
        			se.printStackTrace();
        		}
        		rs=null;
        	}
        	
        	
        	if(stmt!=null){
        		try{
        			stmt.close();
        		}
        		catch(SQLException se){
        			se.printStackTrace();
        		}
        		stmt=null;
        	}
		}
		
    }
    public static void doCommand(Connection conn,String typeName){
    	System.out.println();
		System.out.println();
		Statement stmt=null;
		ResultSet rs=null;
		
		try{
			stmt=conn.createStatement();
			if(!typeName.contains("*"))
			     rs=stmt.executeQuery("select * from file where name='"+typeName+"'");
			else{
				typeName=typeName.replace('*', '%');
				rs=stmt.executeQuery("select * from file where name like '"+typeName+"'");
			}
			if(!rs.next()){//若rs为空,数据库中文件表为空,提示用户
				System.out.println("您查找的文件不存在！");
			}
			else{
				int number=1;
				rs.beforeFirst();
				System.out.println("序号                文件名                    上传用户                   文件路径                            文件类型                  文件大小(字节)");//输出表头
			    while(rs.next()){
			      String filename=rs.getString(3);//获取文件名
			      String id=rs.getString(2);//获取上传用户学号
			      String path=rs.getString(4);//获取文件相对工程根目录的路径
				  String type=rs.getString(5);//获取文件类型
				  long size=0;
				  //文件在服务器端完整路径
				  String  serverPath="D:\\JAVA\\eclipse\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\filemanagement"+path;
				  File file=new File(serverPath);
				  size=file.length();//获取文件大小
				  
				  System.out.println(number+"        "+filename+"     "+id+"      "+path+"        "+type+"            "+size);//输出类别信息
				  number++;
			   }
			    System.out.println();
			    System.out.println();
			}
		}catch(SQLException se){se.printStackTrace();}
		finally{
			if(rs!=null){
        		try{
        			rs.close();
        		}
        		catch(SQLException se){
        			se.printStackTrace();
        		}
        		rs=null;
        	}
        	
        	
        	if(stmt!=null){
        		try{
        			stmt.close();
        		}
        		catch(SQLException se){
        			se.printStackTrace();
        		}
        		stmt=null;
        	}
		}
    }
}
