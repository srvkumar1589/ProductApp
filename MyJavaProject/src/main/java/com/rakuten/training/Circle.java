package com.rakuten.training;
//import java.util.*;
public class Circle {
	double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	public double area()
	{
		return Math.PI*radius*radius;
	}
	public double getRadius() {
		return radius;
	}
}
 