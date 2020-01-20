package com.rakuten.training;
import java.io.*;
import java.util.*;
class snum {
	String word1;
	snum(String w)
	{
		this.word1=w;
	}
	public String getvalue()
	{
		return word1;
	}
}
//class gg implements Comparator<snum>

class Sortaccordingtothelengthcomparator
{
	//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args)throws IOException
	{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    ArrayList<snum> l=new ArrayList<>();
    while(true)
    {
    	String pop=br.readLine();
    	if (pop.equalsIgnoreCase("quit"))
    	{
    		break;
    	}
    l.add(new snum(pop));
    }
    Collections.sort(l,new Comparator<snum>()
    		
    {
    	@Override
    	public int compare(snum a,snum b)
    	{
    		return (a.word1.length()-b.word1.length());
    	}
    }
    		);
    for(snum i:l)
    {
    	System.out.println(" "+i.getvalue()+" "); 
    }
  }
}