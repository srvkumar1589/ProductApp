package com.rakuten.training;
import java.util.*;
import java.io.*;


public class HashMap1 {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public Map<String,String> buildMap()
	{
	Map<String,String> h=new HashMap<String,String>();
	h.put("E1234","Steve Jobs");
	h.put("E2345","Bill Gates");
	h.put("E3456","Larry Ellison");
	h.put("E4567","JEFF BEZZOS");
	h.put("E8765","MARK ZUCKERBERG");
	h.put("E6789","LARRY PAGE");
	return h;
	}
	public void getEid(Map<String,String> h)throws IOException
	{
		while(true)
		{
		String n=(br.readLine());
		if (n.equalsIgnoreCase("quit"))
		{
			break;
		}
		else if(h.containsKey(n))
		{
			System.out.println("Employee is "+h.get(n)); 
		}
		else
			System.out.println("key value pair doesnt exist" ); 
		}
		
	}
	public static void main(String[] args)throws IOException {
    HashMap1 ob=new HashMap1();
		Map<String,String> h=ob.buildMap();
		ob.getEid(h);
  }
	/*public void setDemo()
	{
		Set<>
	}*/
}

