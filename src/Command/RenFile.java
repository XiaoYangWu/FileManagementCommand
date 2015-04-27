/**处理用户文件名校对命令*/
package Command;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RenFile {
	 public static void init(Connection conn,String command){
		 if("renfile".equals(command.toLowerCase()))//若用户输入的就是renfile(忽略大小写),则调用doCommand函数进行相应操作		
		     doCommand(conn);
	    else{
	    	//用户输入renfile之后还输入了其他内容,向用户输出renfile格式提示信息
	    	System.out.println();
	    	System.out.println("命令输入错误,RenFile命令无任何参数！");
    		System.out.println();
    		System.out.println("正确形式为:(可忽略大小写)");
    		System.out.println("renfile");
    		System.out.println();
    		System.out.println();
 
	    }
	   }
	public static void doCommand(Connection conn){//处理renfile命令
		Statement stmt=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		
		try{
			pstmt=conn.prepareStatement("update file set path=? where name=?");
		    stmt=conn.createStatement();
			rs=stmt.executeQuery("select name,path from file");
		   while(rs.next()){
			   String fileName=rs.getString(1);
			   String serverFileName=rs.getString(2).split("/")[2];
			   //当文件逻辑文件名和物理文件名不一致时
			   if(!fileName.equals(serverFileName)){
				   //修改数据库中记录
				   pstmt.setString(1, "/upload/"+fileName);
				   pstmt.setString(2, fileName);
				   pstmt.executeUpdate();
				   
				   //修改文件系统中文件名
				   File file=new File("D:\\JAVA\\eclipse\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\filemanagement\\upload\\"+serverFileName);
			       File dest=new File("D:\\JAVA\\eclipse\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\filemanagement\\upload\\"+fileName);
			       file.renameTo(dest);
			   }
		   }
		   
		   System.out.println();
		   System.out.println("文件名校对成功！");
		   System.out.println();
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
