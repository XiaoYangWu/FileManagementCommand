/**�����û�����İ�������*/
package Command;

import java.sql.Connection;

public class Help {
	 public static void init(String command){
		 String[] temp=command.split(" ");
	    	
	    	if(!temp[0].toLowerCase().equals("help")||temp.length>2){//�ж��û������ʽ�Ƿ���ȷ,������ȷ��ʾ
	    		System.out.println();
	    		
	    		System.out.println("�����������,����һ���ո��������Ͳ�����");
	    		System.out.println();
	    		System.out.println();
	    		System.out.println("help -x");
	    		System.out.println();
	    		System.out.println();
	    		System.out.println("-x    ��ѡ,ָ��Ҫ��ѯ�İ�������");	
	    		System.out.println();
	    		System.out.println();
	    	}
	    	else{
	    		if(temp.length==1)
	    			doCommand();//�û�û���������,��ѯ���������Ҫ��Ϣ
	    		else
	    			doCommand(temp[1]);//�û���ѯĳһ�ض�������ϸ��Ϣ
	    	}
	 }
	
	 public static void doCommand(){
		 
		 System.out.println();
		 System.out.println("�й�ĳ���������ϸ��Ϣ,�����HELP������");
		 System.out.println();
		 System.out.println("LISTTYPE        �ļ����ͳ��");
		 System.out.println("LISTFILE        �ļ�ͳ��");
		 System.out.println("CLEANFILE       �ļ�����");
		 System.out.println("RENFILE         �ļ���У��");
		 System.out.println();
		 System.out.println();
     }
    
	 public static void doCommand(String commandName){
   	      if("listtype".equals(commandName.toLowerCase())){
   	    	 System.out.println();
   	    	 System.out.println("�ļ����ͳ��");
   	    	  System.out.println("�г������ļ���𣬼�ÿһ����µ��ļ��������ܵ��ļ���С����Ϣ�����������TypeName��������ֻ�г�ָ��TypeName�µ��ļ���Ӧ��Ϣ");
   	    	System.out.println();
   	    	  System.out.println("listtype -x");
    		System.out.println();
    		System.out.println("-x    ��ѡ,ָ��Ҫ��ѯ���ļ����");
    		System.out.println();
   	      }
   	      else if("listfile".equals(commandName.toLowerCase())){
   	    	System.out.println();
   	    	System.out.println("�ļ�ͳ��");
   	    	System.out.println("�г�ƥ���ļ�����Ӧ��Ϣ�����ļ������ļ���С���ļ����ȡ����û��ָ�����������г������ļ������ָ����FileName���������г�ָ��FileName���ļ���Ϣ��");
   	    	System.out.println("FileName��֧��ͨ���*������ListFile *.txt���г����к�׺Ϊ.txt���ļ���Ϣ�������ݿ�洢���ļ������ļ�ϵͳʵ���ļ�����һ�µ�����£������ݿ�洢���ļ���Ϊ׼��");
   	    	System.out.println();
   	    	System.out.println("listfile -x");
    		System.out.println();
    		System.out.println("-x    ��ѡ,ָ��Ҫ��ѯ���ļ���");	
    		System.out.println();
   	      }
   	      else if("cleanfile".equals(commandName.toLowerCase())){
   	    	System.out.println();
   	    	System.out.println("�ļ�����");
   	    	System.out.println("����ļ�ϵͳ�е��ļ���һ��������ݿ������Ƿ���ڣ���������ڣ�����ļ�ϵͳ��ɾ�����ļ�����󷵻�ɾ�����ļ�������Ϣ��");
   	    	System.out.println();
   	    	System.out.println("cleanfile");
   	    	
   	    	System.out.println("CleanFile�������κβ���,�ҿɺ��Դ�Сд");
   	    	System.out.println();
	      }
   	      else	if("renfile".equals(commandName.toLowerCase())){
   	    	System.out.println();
   	    	System.out.println("�ļ���У��");
   	    	System.out.println("��һ�ȶ����ݿ��е��ļ������ļ�ϵͳ�е��ļ����Ƿ�һ�£������һ�£����޸��ļ�ϵͳ�е��ļ��������ݿ��¼һ�£�ͬʱ�޸���Ӧ�����ݿ��¼�е������ļ���Ϣ��");
   	    	System.out.println();
   	    	System.out.println("renfile");
   	    	System.out.println("RenFile�������κβ���,�ҿɺ��Դ�Сд");
   	    	System.out.println();
	      }
   	      else{
   		      System.out.println("�����ҵ�������ڣ�");
   		     System.out.println();
   		     System.out.println();
         }
    }
}
