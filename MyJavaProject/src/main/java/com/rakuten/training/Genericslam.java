package com.rakuten.training;
@FunctionalInterface
interface TwoElementPredicate<T>
{
	boolean isFirstBetter(T o1,T o2);
}
class Genericslam {
	public static <T> T betterElement(T a,T b,TwoElementPredicate<T> tester)
	{
		if (tester.isFirstBetter(a, b))
		{
			return a;
		}
		else
			return b;
	}
	public static void main(String[] args) {
    String answer=betterElement("Give", "Giveeeee", (a,b)->a.length()>b.length());
    System.out.println(answer);
  }
}
