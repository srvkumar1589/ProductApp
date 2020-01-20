package com.rakuten.training;

import java.util.function.*;
import java.util.*;
public class GenericsFunctionClass {
 public static <R, T> List<R> transformedList(List<T> l, Function<T, R> map) {
    List<R> temp = new ArrayList<>();
    for (T i : l) {
      temp.add((map.apply(i)));
    }
    return temp;
  }
  public static void main(String[] args) {
	List <String> words =new ArrayList<String>();
	words.add("sourav");
	words.add("kum");
	words.add("I");
	words.add("am");
    List<String> excitingWords = transformedList(words, s -> s + "!");
    List<String> eyeWords = transformedList(words, s -> s.replace("I", "eye"));
  List<String> upperCaseWords = transformedList(words, String::toUpperCase);
  List<Integer> wordLengths = transformedList(words, String::length);
    System.out.println(excitingWords);
    System.out.println(eyeWords);
    System.out.println(upperCaseWords);
    System.out.println(wordLengths);
  }
}
