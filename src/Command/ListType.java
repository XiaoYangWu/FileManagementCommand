/**�����û��ļ����ͳ������*/
package Command;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListType {
    public static void init(Connection conn,String command){
    	String[] temp=command.split(" ");//���и��û�����������ַ���
    	
    	if(!temp[0].toLowerCase().equals("listtype")||temp.length>2){//�ж��û������ʽ�Ƿ���ȷ,������ȷ��ʾ
    		System.out.println("�����������,����һ���ո��������Ͳ�����");
    		System.out.println();
    		System.out.println();
    		System.out.println("listtype -x");
    		System.out.println();
    		System.out.println();
    		System.out.println("-x    ��ѡ,ָ��Ҫ��ѯ���ļ����");	
    		System.out.println();
    		System.out.println();
    	}
    	else{
    		if(temp.length==1)//���и�󳤶�Ϊһ,�û�û���������,������Ӧ��doCommand����������Ӧ����
    			doCommand(conn);
    		else//����,�и�󳤶�Ϊ2,���û���������������Ϊ��������doCommang����������Ӧ����
    			doCommand(conn,temp[1]);
    	}
    	
    	
    	
    }
	public static void doCommand(Connection conn){//�û�û������������������
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
			if(!rs.next()){//��rsΪ��,���ݿ�������Ϊ��,��ʾ�û�
				System.out.println("ϵͳ��ǰû���ļ����,�뽨���ļ����");
			}
			else{
				rs.beforeFirst();
				System.out.println("�ļ������        �ļ�����          �ļ��ܴ�С(�ֽ�)");//�����ͷ
			    while(rs.next()){//����ÿһ����������Ӧ����
				  String type=rs.getString(1);
				  rs2=stmt2.executeQuery("select path from file where type='"+type+"'");
				  int count=0;
				  int size=0;
				  while(rs2.next()){
					  count++;
					 //������һ����ļ��ܴ�С
				     String  path="D:\\JAVA\\eclipse\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\filemanagement"+rs2.getString(1);
					  File file=new File(path);
				      size+=file.length();
				  }
				  System.out.println(type+"        "+count+"          "+size);//��������Ϣ
				 
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
     public static void doCommand(Connection conn,String typeName){//�û�������������������
    	 System.out.println();
 		System.out.println();
 		Statement stmt=null;
 		
 		ResultSet rs=null;
 		
 		try{
 			stmt=conn.createStatement();
 			
 			rs=stmt.executeQuery("select * from file_type where type='"+typeName+"'");
 			if(!rs.next()){//��rsΪ��,���ݿ�������Ϊ��,��ʾ�û�
 				System.out.println("�����ҵ��ļ���𲻴��ڣ�");
 				System.out.println();
 				System.out.println();
 			}
 			else{
 				System.out.println("�ļ������        �ļ�����          �ļ��ܴ�С(�ֽ�)");//�����ͷ
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
 				  System.out.println(type+"        "+count+"          "+size);//��������Ϣ
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
