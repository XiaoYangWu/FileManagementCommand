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
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));//获取从键盘读取字符串的输入流
        String line = null;
		
        Connection conn=null;
        ConnectDatabase.init();
        conn=ConnectDatabase.connect();
        
		while((line=bufr.readLine())!=null){//根据用户输入内容执行相应操作
			if("over".equals(line)){//输入over结束操作
				try{
				conn.close();
				}
				catch(SQLException se){se.printStackTrace();}
				
				break;
			}
			else if(line.toLowerCase().startsWith("listtype")){//执行文件类别统计命令
				ListType.init(conn,line);
			}
			else if(line.toLowerCase().startsWith("listfile")){//执行文件统计命令
				ListFile.init(conn,line);
			}
			else if(line.toLowerCase().startsWith("cleanfile")){//执行文件清理命令
				CleanFile.init(conn,line);
			}
			else if(line.toLowerCase().startsWith("renfile")){//执行文件名校对命令
				RenFile.init(conn,line);
			}
			else if(line.toLowerCase().startsWith("help")){//执行帮助命令
				Help.init(line.toLowerCase());
			}
			else{
				System.out.println("您运行的命令不存在！");
			}
			
		}
	}

}
