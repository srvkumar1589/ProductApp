package com.rakuten.training;
import java.io.*;
import java.util.*;
public class Hashset {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public Set<String> buildSet() throws IOException {
    Set<String> s = new HashSet<String>();
    while (true) {
      String g = br.readLine();
      if (g.equalsIgnoreCase("quit")) break;
      else if (!s.add(g))
    	  System.out.println("duplicate element" );      
    }
    return s;
  }
  public void display(Set<String> s)
  {
	  System.out.println(s);
  }
  public Set<String> sorting(Set<String> s)
  {
	  Set<String> g=new TreeSet<>(s);
	  return g;
  }
  public static void main(String[] args)throws IOException {
	Hashset ob=new Hashset();
	Set<String> s=ob.buildSet();
	ob.display(s);
	ob.sorting(s);
	ob.display(s);
}
}

