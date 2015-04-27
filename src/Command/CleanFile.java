/**�����û������ļ�����*/
package Command;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CleanFile {
	 public static void init(Connection conn,String command){
	    if("cleanfile".equals(command.toLowerCase()))//���û�����ľ���cleanfile(���Դ�Сд),�����doCommand����������Ӧ����	
		     doCommand(conn);
	    else{
	    	//�û�����cleanfile֮����������������,���û����cleanfile��ʽ��ʾ��Ϣ
	    	System.out.println();
	    	System.out.println("�����������,CleanFile�������κβ�����");
    		System.out.println();
    		System.out.println("��ȷ��ʽΪ:(�ɺ��Դ�Сд)");
    		System.out.println("cleanfile");
    		System.out.println();
    		System.out.println();
 
	    }
	    }
	public static void doCommand(Connection conn){//����CleanFile����
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//��ȡ�ļ�ϵͳ��ַ�������ļ�
		File dir=new File("D:\\JAVA\\eclipse\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\filemanagement\\upload");
		File[] files=dir.listFiles();
		
		boolean flag=true;//��Ϊ���ʹ��,��һ����Ҫɾ���ļ�ʱ��ӡ��ͷ,�ҿ������ж�����ɾ�����ļ�
		
		try{
		pstmt=conn.prepareStatement("select path from file where path=?");//��ΪҪƵ����ѯ���ݿ�,ʹ��PreparedStatement���Ч��
		for(File file:files){//�����ļ�ϵͳÿһ���ļ���������Ӧ����
			String fileName=file.getName();
			String path="/upload/"+fileName;//ת��Ϊ�������վ���̸�Ŀ¼��·����ʾ,���ݿ�������ô�洢��
		    pstmt.setString(1, path);
		    rs=pstmt.executeQuery();
		    if(!rs.next()){//����ѯ�Ľ������û������ļ�,��ɾ��֮
		    	if(flag){//����ɾ���ĵ�һ���ļ�,�����ͷ,����flag��Ϊfalse
		    		System.out.println();
		    		System.out.println("������ļ�Ϊ:");
		    		flag=false;
		    	}
		    	System.out.println(fileName);
		    	file.delete();//ɾ���ļ�ϵͳ�ж�Ӧ�ļ�
		    	
		    }
		    
		}
		if(flag)
		{    //���������ļ�flag����Ϊtrue��˵��û����Ҫɾ�����ļ�,��ʾ�û�
			System.out.println("û����Ҫɾ�����ļ���");
			
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
