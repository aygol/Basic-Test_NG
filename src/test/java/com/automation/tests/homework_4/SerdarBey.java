package com.automation.tests.homework_4;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SerdarBey {
    public static void main(String[] args) {


        String name = "mike";
        System.out.println(name);

        String name1 = new String("mike");
        System.out.println(name1);

        char[] name2 = {'s', 'c', 'o', 't', 't'};
        String name3 = new String(name2);
        System.out.println(name3);

        System.out.println(name == name1);

        String name4 = "java";
        //name4.concat("selenium");//stack memory
        name4 = name4.concat("selenium");//heap memory
        System.out.println(name4);
        Integer.parseInt("123");
//it returns an int value converted from String

        Integer.valueOf("123");
        Integer.valueOf(123);
        //it returns an Integer Object by wrapping up the number (String or int)

        String number = "10";
        int result = Integer.parseInt(number);//primitive==>none
        Integer result1 = Integer.parseInt(number);//primitive==>auto-boxing
        System.out.println(result);
        System.out.println(result1);


        String numbers = "25";
        int rslt = Integer.valueOf(numbers);//Wrapper==>unboxing
        Integer rslt1 = Integer.valueOf(numbers);//Wrapper==>none
        System.out.println(rslt);
        System.out.println(rslt1);
        int num = 123;
        String a = Integer.toString(num);
        System.out.println(a);

        int nums = 123456;
        String b = String.valueOf(nums);
        System.out.println(b);
        String az = "java is fun";
        StringBuilder abc = new StringBuilder(az);
//DAIR==> delete appand insert reverse
        System.out.println(abc.reverse());
        System.out.println(abc.append("selenium"));
        System.out.println(abc.delete(0, 1));//substring kullaniyor
        System.out.println(abc.insert(0, "Pyhton"));
        String names = "Selenium is easy for me";
        String reverse = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            reverse += name.charAt(i);
            reverse = name.substring(i + i + 1);
        }
        System.out.println(reverse);

        //remove duplicate
        //first way
        String[] sentence = {"A", "A", "B", "B", "C"};
        Set<String> remdup = new TreeSet<>(Arrays.asList(sentence));
        System.out.println(remdup);

        //second way
        String word = "AAABBBCCCCCCDDDDDDEEEEH";
        String[] arr = word.split("");
        Set<String> remdup2 = new TreeSet<>(Arrays.asList(arr));
        System.out.println(remdup2);

        //third way

        String word1 = "AAABBBCCCCCCDDDDDDEEEEHHHHGGKKKLL";
        String results = "";
        for (int i = 0; i < word1.length(); i++) {
            if (!results.contains(word1.substring(i, i + 1))) {
                results += word1.substring(i, i + 1);
            }
            System.out.println(result);


        }

    }}