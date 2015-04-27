/**处理用户输入的帮助命令*/
package Command;

import java.sql.Connection;

public class Help {
	 public static void init(String command){
		 String[] temp=command.split(" ");
	    	
	    	if(!temp[0].toLowerCase().equals("help")||temp.length>2){//判断用户输入格式是否正确,若不正确提示
	    		System.out.println();
	    		
	    		System.out.println("命令输入错误,请用一个空格分离命令和参数！");
	    		System.out.println();
	    		System.out.println();
	    		System.out.println("help -x");
	    		System.out.println();
	    		System.out.println();
	    		System.out.println("-x    可选,指定要查询的帮助命令");	
	    		System.out.println();
	    		System.out.println();
	    	}
	    	else{
	    		if(temp.length==1)
	    			doCommand();//用户没有输入参数,查询所有命令概要信息
	    		else
	    			doCommand(temp[1]);//用户查询某一特定命令详细信息
	    	}
	 }
	
	 public static void doCommand(){
		 
		 System.out.println();
		 System.out.println("有关某个命令的详细信息,请键入HELP命令名");
		 System.out.println();
		 System.out.println("LISTTYPE        文件类别统计");
		 System.out.println("LISTFILE        文件统计");
		 System.out.println("CLEANFILE       文件清理");
		 System.out.println("RENFILE         文件名校对");
		 System.out.println();
		 System.out.println();
     }
    
	 public static void doCommand(String commandName){
   	      if("listtype".equals(commandName.toLowerCase())){
   	    	 System.out.println();
   	    	 System.out.println("文件类别统计");
   	    	  System.out.println("列出所有文件类别，及每一类别下的文件数量，总的文件大小等信息。如果给出了TypeName参数，则只列出指定TypeName下的文件相应信息");
   	    	System.out.println();
   	    	  System.out.println("listtype -x");
    		System.out.println();
    		System.out.println("-x    可选,指定要查询的文件类别");
    		System.out.println();
   	      }
   	      else if("listfile".equals(commandName.toLowerCase())){
   	    	System.out.println();
   	    	System.out.println("文件统计");
   	    	System.out.println("列出匹配文件的相应信息，如文件名、文件大小、文件类别等。如果没有指定参数，则列出所有文件，如果指定了FileName参数，则列出指定FileName的文件信息。");
   	    	System.out.println("FileName需支持通配符*，比如ListFile *.txt，列出所有后缀为.txt的文件信息。在数据库存储的文件名与文件系统实际文件名不一致的情况下，以数据库存储的文件名为准。");
   	    	System.out.println();
   	    	System.out.println("listfile -x");
    		System.out.println();
    		System.out.println("-x    可选,指定要查询的文件名");	
    		System.out.println();
   	      }
   	      else if("cleanfile".equals(commandName.toLowerCase())){
   	    	System.out.println();
   	    	System.out.println("文件清理");
   	    	System.out.println("针对文件系统中的文件逐一检查在数据库表格中是否存在，如果不存在，则从文件系统中删除此文件，最后返回删除的文件名等信息。");
   	    	System.out.println();
   	    	System.out.println("cleanfile");
   	    	
   	    	System.out.println("CleanFile命令无任何参数,且可忽略大小写");
   	    	System.out.println();
	      }
   	      else	if("renfile".equals(commandName.toLowerCase())){
   	    	System.out.println();
   	    	System.out.println("文件名校对");
   	    	System.out.println("逐一比对数据库中的文件名和文件系统中的文件名是否一致，如果不一致，则修改文件系统中的文件名与数据库记录一致，同时修改相应的数据库记录中的物理文件信息。");
   	    	System.out.println();
   	    	System.out.println("renfile");
   	    	System.out.println("RenFile命令无任何参数,且可忽略大小写");
   	    	System.out.println();
	      }
   	      else{
   		      System.out.println("您查找的命令不存在！");
   		     System.out.println();
   		     System.out.println();
         }
    }
}
