package com.rakuten.training;
//import java.io.*;
import java.util.*;
public class CreateCircle {
	//List<Circle> aCircle=new ArrayList<>();
	public static void buildCircle(List<Circle> aCircle)
	{
		//List<Circle> aCircle=new ArrayList<>();
		while(true)
		{
			double n=Math.random();
			if (n<0.01)
				break;
			else
			{
				Circle c=new Circle(n);
				aCircle.add(c);
			}
		}
		System.out.println("before number is "+aCircle.size());
	}
	public static void changeCircle(List<Circle> circles)
	{
		Iterator<Circle> it=circles.iterator();
		while(it.hasNext())
		{
			if (it.next().getRadius()<0.5)
			{
				it.remove();
			}
		}
		System.out.println("after number is "+circles.size());
	}
	public static void main(String[] args) {
		List<Circle> aCircle=new ArrayList<>();
		buildCircle(aCircle);
		changeCircle(aCircle);
	}
}
