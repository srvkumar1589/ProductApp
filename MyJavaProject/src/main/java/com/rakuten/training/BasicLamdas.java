package com.rakuten.training;

import java.util.*;

public class BasicLamdas {

  static String[] sort_length() {
    String[] s = {"eone", "efour", "xylophone", "telephoneeeee"};
    Arrays.parallelSort(s, (a, b) -> a.length() - b.length());
    System.out.println(Arrays.asList(s));
    return s;
  }

  static void sort_reverselength(String[] s) {
	  Arrays.sort(s,(a,b)->b.length()-a.length());
	  System.out.println(Arrays.asList(s));
  }
  static void sort_alphafirstletter(String s[])
  {
	  Arrays.sort(s,(a,b)->a.substring(0,1).compareTo(b.substring(0,1)));
	  System.out.println(Arrays.asList(s));
  }
  static void sort_e(String[] s)
  {
	  Arrays.sort(s,(a,b)->{
		  if (a.charAt(0)=='e' && b.charAt(0)!='e')
			  return -1;
		  else if (a.charAt(0)!='e' && b.charAt(0)=='e')
			  return 1;
		  else
			  return 0;
	  });
	  System.out.println(Arrays.asList(s));
  }
  public static void main(String[] args) {
	String s[]=sort_length();
	sort_reverselength(s);
	sort_alphafirstletter(s);
	sort_e(s);
}
}
