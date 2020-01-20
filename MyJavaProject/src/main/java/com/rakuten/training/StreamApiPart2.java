package com.rakuten.training;
import java.util.*;
import java.util.stream.DoubleStream;
public class StreamApiPart2 {
	static void randomDoubleArray()
	{
		int size=1000;double sum=0;
		double a[]=new Random().doubles(size).toArray();
		for (double i:a)
		{
			sum+=i*i;
		}
		System.out.println( sum); 
		System.out.println( DoubleStream.of(a).map(e->e*e).reduce(0,Double::sum));
	}
	public static void main(String[] args) {
    randomDoubleArray();
  }
}
