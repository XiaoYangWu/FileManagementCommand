package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import Tool.ConnectDatabase;
import Command.CleanFile;
import Command.Help;
import Command.ListFile;
import Command.ListType;
import Command.RenFile;

public class ManageFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));//��ȡ�Ӽ��̶�ȡ�ַ�����������
        String line = null;
		
        Connection conn=null;
        ConnectDatabase.init();
        conn=ConnectDatabase.connect();
        
		while((line=bufr.readLine())!=null){//�����û���������ִ����Ӧ����
			if("over".equals(line)){//����over��������
				try{
				conn.close();
				}
				catch(SQLException se){se.printStackTrace();}
				
				break;
			}
			else if(line.toLowerCase().startsWith("listtype")){//ִ���ļ����ͳ������
				ListType.init(conn,line);
			}
			else if(line.toLowerCase().startsWith("listfile")){//ִ���ļ�ͳ������
				ListFile.init(conn,line);
			}
			else if(line.toLowerCase().startsWith("cleanfile")){//ִ���ļ���������
				CleanFile.init(conn,line);
			}
			else if(line.toLowerCase().startsWith("renfile")){//ִ���ļ���У������
				RenFile.init(conn,line);
			}
			else if(line.toLowerCase().startsWith("help")){//ִ�а�������
				Help.init(line.toLowerCase());
			}
			else{
				System.out.println("�����е�������ڣ�");
			}
			
		}
	}

}
