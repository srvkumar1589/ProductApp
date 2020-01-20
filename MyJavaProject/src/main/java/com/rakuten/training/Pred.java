package com.rakuten.training;

import java.util.function.Predicate;
import java.util.*;
public class Pred {
	static <T> List<T> allMatches(List<T> l,Predicate<T> p)
	{	
		List<T> temp=new ArrayList<>();
		for(T i:l)
		{
			if (p.test(i))
			{
				temp.add(i);
			}
			/*else
			{
				it
			}*/
			
		}
		return temp;
	}
	public static void main(String[] args) {
		List<String> master=new ArrayList<String>();
		master.add("sourav");
		master.add("satyajeet");
		master.add("Das");
		master.add("amitrajeet");
		List<String> temp=new ArrayList<String>(master);
		List<String> temp2=new ArrayList<String>(master);
		//System.out.println(master);
		List<String> shortWords = allMatches(master, s -> s.length() < 4); 
		List<String> wordsWithB = allMatches(temp, s -> s.contains("b"));
		List<String> evenLengthWords = allMatches(temp2, s -> (s.length() % 2) == 0);
		List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000);
		System.out.println(nums ); 
		List<Integer> bigNums =allMatches(nums,n->n>500);
		System.out.println(shortWords );
		System.out.println(wordsWithB );
		System.out.println(evenLengthWords );
		System.out.println(bigNums );
  }
}
