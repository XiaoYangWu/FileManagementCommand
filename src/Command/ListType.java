/**处理用户文件类别统计命令*/
package Command;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListType {
    public static void init(Connection conn,String command){
    	String[] temp=command.split(" ");//先切割用户输入的命令字符串
    	
    	if(!temp[0].toLowerCase().equals("listtype")||temp.length>2){//判断用户输入格式是否正确,若不正确提示
    		System.out.println("命令输入错误,请用一个空格分离命令和参数！");
    		System.out.println();
    		System.out.println();
    		System.out.println("listtype -x");
    		System.out.println();
    		System.out.println();
    		System.out.println("-x    可选,指定要查询的文件类别");	
    		System.out.println();
    		System.out.println();
    	}
    	else{
    		if(temp.length==1)//若切割后长度为一,用户没有输入参数,调用相应的doCommand函数进行相应处理
    			doCommand(conn);
    		else//否则,切割后长度为2,将用户输入的命令参数作为参数交给doCommang函数进行相应处理
    			doCommand(conn,temp[1]);
    	}
    	
    	
    	
    }
	public static void doCommand(Connection conn){//用户没有输入命令参数的情况
		System.out.println();
		System.out.println();
		Statement stmt=null;
		Statement stmt2=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		try{
			stmt=conn.createStatement();
			stmt2=conn.createStatement();
			rs=stmt.executeQuery("select * from file_type");
			if(!rs.next()){//若rs为空,数据库中类别表为空,提示用户
				System.out.println("系统当前没有文件类别,请建立文件类别！");
			}
			else{
				rs.beforeFirst();
				System.out.println("文件类别名        文件数量          文件总大小(字节)");//输出表头
			    while(rs.next()){//遍历每一个类别进行相应操作
				  String type=rs.getString(1);
				  rs2=stmt2.executeQuery("select path from file where type='"+type+"'");
				  int count=0;
				  int size=0;
				  while(rs2.next()){
					  count++;
					 //计算这一类别文件总大小
				     String  path="D:\\JAVA\\eclipse\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\filemanagement"+rs2.getString(1);
					  File file=new File(path);
				      size+=file.length();
				  }
				  System.out.println(type+"        "+count+"          "+size);//输出类别信息
				 
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
        	if(rs2!=null){
        		try{
        			rs2.close();
        		}
        		catch(SQLException se){
        			se.printStackTrace();
        		}
        		rs2=null;
        	}
        	if(stmt2!=null){
        		try{
        			stmt2.close();
        		}
        		catch(SQLException se){
        			se.printStackTrace();
        		}
        		stmt2=null;
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
     public static void doCommand(Connection conn,String typeName){//用户输入了命令参数的情况
    	 System.out.println();
 		System.out.println();
 		Statement stmt=null;
 		
 		ResultSet rs=null;
 		
 		try{
 			stmt=conn.createStatement();
 			
 			rs=stmt.executeQuery("select * from file_type where type='"+typeName+"'");
 			if(!rs.next()){//若rs为空,数据库中类别表为空,提示用户
 				System.out.println("您查找的文件类别不存在！");
 				System.out.println();
 				System.out.println();
 			}
 			else{
 				System.out.println("文件类别名        文件数量          文件总大小(字节)");//输出表头
 				  String type=rs.getString(1);
 				  rs=stmt.executeQuery("select path from file where type='"+type+"'");
 				  int count=0;
 				  int size=0;
 				  while(rs.next()){
 					  count++;
 					 
 				     String  path="D:\\JAVA\\eclipse\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\filemanagement"+rs.getString(1);
 					  File file=new File(path);
 				      size+=file.length();
 				  }
 				  System.out.println(type+"        "+count+"          "+size);//输出类别信息
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
