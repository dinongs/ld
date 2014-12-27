package com.example.shundeud;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTool {
	
	public static int  getInputType(String text)
	{
		 Pattern p = Pattern.compile("[0-9]*"); 
	     Matcher m = p.matcher(text); 
	     if(m.matches() ){
	     return 0;
	      } 
	     p=Pattern.compile("[a-zA-Z]");
	     m=p.matcher(text);
	     if(m.matches()){
	      return 1;
	     }
	     p=Pattern.compile("[\u4e00-\u9fa5]");
	     m=p.matcher(text);
	     if(m.matches()){
	      return 2;
	     }
	     
	     return -1;
	}

}
