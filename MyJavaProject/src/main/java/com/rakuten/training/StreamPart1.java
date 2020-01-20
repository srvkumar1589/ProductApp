package com.rakuten.training;
import java.util.*;
public class StreamPart1 {
	static void prints_onASeperateLine(List<String> l)
	{
		l.stream().forEach(e->System.out.println("  "+e));
	}
	static void prints_usingMethodReference(List<String> l)
	{
		l.parallelStream().forEach(System.out::println);
	}
	static void transformListUsingApi(List<String> l)
	{
		//l.stream().map(e->e+"!").forEach(System.out::println);;
		//l.stream().map(e->e.replace("i","eye")).forEach(System.out::println);
		//l.stream().filter(e->e.length()<4).forEach(System.out::println);
		//l.stream().filter(e->e.contains("v")).forEach(System.out::println);
		//l.stream().filter(e->(e.length())%2==0).forEach(System.out::println);
		Optional<String> temp=l.stream().reduce((x,y)->x.toUpperCase().concat(y.toUpperCase()));
		System.out.println(temp ); 
		temp=l.stream().map(e->e.toUpperCase()).reduce((x,y)->x.concat(y));
		System.out.println(temp ); 
		System.out.println( l.stream().reduce((x,y)->x+","+y));
		
	}
	
	public static void main(String[] args) {
    List<String> s=Arrays.asList("sourav","kumar","hi");
    //prints_onASeperateLine(s);
    //prints_usingMethodReference(s);
    transformListUsingApi(s);
  }
}
