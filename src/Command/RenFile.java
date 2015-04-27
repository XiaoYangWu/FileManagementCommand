/**�����û��ļ���У������*/
package Command;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RenFile {
	 public static void init(Connection conn,String command){
		 if("renfile".equals(command.toLowerCase()))//���û�����ľ���renfile(���Դ�Сд),�����doCommand����������Ӧ����		
		     doCommand(conn);
	    else{
	    	//�û�����renfile֮����������������,���û����renfile��ʽ��ʾ��Ϣ
	    	System.out.println();
	    	System.out.println("�����������,RenFile�������κβ�����");
    		System.out.println();
    		System.out.println("��ȷ��ʽΪ:(�ɺ��Դ�Сд)");
    		System.out.println("renfile");
    		System.out.println();
    		System.out.println();
 
	    }
	   }
	public static void doCommand(Connection conn){//����renfile����
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
			   //���ļ��߼��ļ����������ļ�����һ��ʱ
			   if(!fileName.equals(serverFileName)){
				   //�޸����ݿ��м�¼
				   pstmt.setString(1, "/upload/"+fileName);
				   pstmt.setString(2, fileName);
				   pstmt.executeUpdate();
				   
				   //�޸��ļ�ϵͳ���ļ���
				   File file=new File("D:\\JAVA\\eclipse\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\filemanagement\\upload\\"+serverFileName);
			       File dest=new File("D:\\JAVA\\eclipse\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\filemanagement\\upload\\"+fileName);
			       file.renameTo(dest);
			   }
		   }
		   
		   System.out.println();
		   System.out.println("�ļ���У�Գɹ���");
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
