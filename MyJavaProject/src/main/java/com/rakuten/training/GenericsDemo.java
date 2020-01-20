package com.rakuten.training;
import java.util.*;
public class GenericsDemo {
	/*generic methods where returm type depends upon the arguments*/
	public <T> T add(T arg1,T arg2)
	{
		return null;
	}
	public static void printAll(List<?> l)//unbounded wildcard
	{
		for(Object o:l)
		{
			System.out.println(o); 
		}
		//l.add("abc"); not allowed
	}
	public static double sumCollection(Collection<? extends Number> numCollection)
	{double sum=0;
	for (Number o:numCollection)
	{
		sum+=o.doubleValue();
	}
	//numCollection.add(123);
	//adding is not allowed
		return sum;
	}
  public static void main(String[] args) {
    // TODO Auto-generated method stub
	  List<Double> l=new ArrayList<>();
	  l.add(1234.0);
	  l.add(8766.0);
	  List<Integer> iList=new ArrayList<>();
	  double sum=sumCollection(l);
	  double sum2=sumCollection(iList);
	  System.out.println(sum);
	  System.out.println(sum2);
	  
	  
	  String[] strs= {"one","four","xylophone","ten"};
	  //List<String> sList=new ArrayList<>(Arrays.asList(strs));
	  List<String> sList=Arrays.asList(strs);
	  Collections.sort(sList);//changes the array itself.Because behaviour of Arrays.asList
	  System.out.println(sList);
  }
}
