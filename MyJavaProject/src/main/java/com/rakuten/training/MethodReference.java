package com.rakuten.training;

import java.util.Arrays;

public class MethodReference {
	public static int compare(String a,String b)
	{
		if (a.charAt(0)=='e' && b.charAt(0)!='e')
			  return -1;
		  else if (a.charAt(0)!='e' && b.charAt(0)=='e')
			  return 1;
		  else
			  return 0;
	}
	 static void build(){
    String[] a= {"eone","four","seven","exylophone"};
    Arrays.sort(a,MethodReference::compare);
    System.out.println(Arrays.asList(a));
  }
	 public static void main(String[] args) {
   build(); 
  }
}

