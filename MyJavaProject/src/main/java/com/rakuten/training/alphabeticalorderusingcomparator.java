package com.rakuten.training;
import java.io.*;
import java.util.*;
class snum1 {
	String word1;
	snum1(String w)
	{
		this.word1=w;
	}
	public String getvalue()
	{
		return word1;
	}
}
public class alphabeticalorderusingcomparator {
	public static void main(String[] args)throws IOException
	{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> l=new ArrayList<>();
    while(true)
    {
    	String pop=br.readLine();
    	if (pop.equalsIgnoreCase("quit"))
    	{
    		break;
    	}
    l.add(pop);
    }
    Collections.sort(l);
    for(String i:l)
    {
    	System.out.println(" "+i+" "); 
    }
  }
}
