/**�����û��ļ�ͳ������*/
package Command;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListFile {
	 public static void init(Connection conn,String command){
		 String[] temp=command.split(" ");
	    	
	    	if(!temp[0].toLowerCase().equals("listfile")||temp.length>2){//�ж��û������ʽ�Ƿ���ȷ,������ȷ��ʾ
	    		System.out.println("�����������,����һ���ո��������Ͳ�����");
	    		System.out.println();
	    		System.out.println();
	    		System.out.println("listfile -x");
	    		System.out.println();
	    		System.out.println();
	    		System.out.println("-x    ��ѡ,ָ��Ҫ��ѯ���ļ���");	
	    		System.out.println();
	    		System.out.println();
	    	}
	    	else{
	    		if(temp.length==1||"*".equals(temp[1]))//�û���ѯ�����ļ�
	    			doCommand(conn);
	    		else
	    			doCommand(conn,temp[1]);//�û���ѯĳһ�ض��ļ�
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
			if(!rs.next()){//��rsΪ��,���ݿ����ļ���Ϊ��,��ʾ�û�
				System.out.println("ϵͳ��ǰû���ļ�,�����ϴ��ļ���");
			}
			else{
				int number=1;
				rs.beforeFirst();
				System.out.println("���                �ļ���                    �ϴ��û�                   �ļ�·��                            �ļ�����                  �ļ���С(�ֽ�)");//�����ͷ
			    while(rs.next()){
			      String filename=rs.getString(3);//��ȡ�ļ���
			      String id=rs.getString(2);//��ȡ�ϴ��û�ѧ��
			      String path=rs.getString(4);//��ȡ�ļ���Թ��̸�Ŀ¼��·��
				  String type=rs.getString(5);//��ȡ�ļ�����
				  long size=0;
				  //�ļ��ڷ�����������·��
				  String  serverPath="D:\\JAVA\\eclipse\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\filemanagement"+path;
				  File file=new File(serverPath);
				  size=file.length();//��ȡ�ļ���С
				  
				  System.out.println(number+"        "+filename+"     "+id+"      "+path+"        "+type+"            "+size);//��������Ϣ
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
			if(!rs.next()){//��rsΪ��,���ݿ����ļ���Ϊ��,��ʾ�û�
				System.out.println("�����ҵ��ļ������ڣ�");
			}
			else{
				int number=1;
				rs.beforeFirst();
				System.out.println("���                �ļ���                    �ϴ��û�                   �ļ�·��                            �ļ�����                  �ļ���С(�ֽ�)");//�����ͷ
			    while(rs.next()){
			      String filename=rs.getString(3);//��ȡ�ļ���
			      String id=rs.getString(2);//��ȡ�ϴ��û�ѧ��
			      String path=rs.getString(4);//��ȡ�ļ���Թ��̸�Ŀ¼��·��
				  String type=rs.getString(5);//��ȡ�ļ�����
				  long size=0;
				  //�ļ��ڷ�����������·��
				  String  serverPath="D:\\JAVA\\eclipse\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\filemanagement"+path;
				  File file=new File(serverPath);
				  size=file.length();//��ȡ�ļ���С
				  
				  System.out.println(number+"        "+filename+"     "+id+"      "+path+"        "+type+"            "+size);//��������Ϣ
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
