/**处理用户清理文件命令*/
package Command;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CleanFile {
	 public static void init(Connection conn,String command){
	    if("cleanfile".equals(command.toLowerCase()))//若用户输入的就是cleanfile(忽略大小写),则调用doCommand函数进行相应操作	
		     doCommand(conn);
	    else{
	    	//用户输入cleanfile之后还输入了其他内容,向用户输出cleanfile格式提示信息
	    	System.out.println();
	    	System.out.println("命令输入错误,CleanFile命令无任何参数！");
    		System.out.println();
    		System.out.println("正确形式为:(可忽略大小写)");
    		System.out.println("cleanfile");
    		System.out.println();
    		System.out.println();
 
	    }
	    }
	public static void doCommand(Connection conn){//处理CleanFile命令
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//获取文件系统地址及所有文件
		File dir=new File("D:\\JAVA\\eclipse\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\filemanagement\\upload");
		File[] files=dir.listFiles();
		
		boolean flag=true;//作为标记使用,第一次需要删除文件时打印表头,且可用来判断有无删除过文件
		
		try{
		pstmt=conn.prepareStatement("select path from file where path=?");//因为要频繁查询数据库,使用PreparedStatement提高效率
		for(File file:files){//遍历文件系统每一个文件并进行相应操作
			String fileName=file.getName();
			String path="/upload/"+fileName;//转换为相对于网站工程根目录的路径表示,数据库中是这么存储的
		    pstmt.setString(1, path);
		    rs=pstmt.executeQuery();
		    if(!rs.next()){//若查询的结果集中没有这个文件,则删除之
		    	if(flag){//若是删除的第一个文件,输出表头,并把flag置为false
		    		System.out.println();
		    		System.out.println("清理的文件为:");
		    		flag=false;
		    	}
		    	System.out.println(fileName);
		    	file.delete();//删除文件系统中对应文件
		    	
		    }
		    
		}
		if(flag)
		{    //若遍历完文件flag还是为true，说明没有需要删除的文件,提示用户
			System.out.println("没有需要删除的文件！");
			
		}
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
        	
        	
        	if(pstmt!=null){
        		try{
        			pstmt.close();
        		}
        		catch(SQLException se){
        			se.printStackTrace();
        		}
        		pstmt=null;
        	}
		}
    }
	
}
