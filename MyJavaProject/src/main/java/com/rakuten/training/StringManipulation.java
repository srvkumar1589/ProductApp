package com.rakuten.training;
@FunctionalInterface
interface TwoStringPredicate
{
	boolean isFirstStringBetter(String first,String second);
}
class StringManipulation {
	public static String betterString(String a,String b,TwoStringPredicate tester)
	{
		if (tester.isFirstStringBetter(a, b))
		{
			return a;
		}
		else
			return b;
	}
	public static void main(String[] args) {
    String answer=betterString("Give", "Giveeeee", (a,b)->a.length()>b.length());
    System.out.println(answer);
  }
}
