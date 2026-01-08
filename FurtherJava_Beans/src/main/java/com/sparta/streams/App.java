package com.sparta.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>(List.of(1,4,3,2,7,8,10)); // even numbers

        int sum = 0;

        ArrayList<String> beatles = new ArrayList<>(List.of("John", "Paul", "George", "Ringo"));
        beatles.stream().filter(name -> name.startsWith("J")).forEach(System.out::println);
        System.out.println(beatles.stream().filter(name -> name.startsWith("J")).count());
//        System.out.println(filteredBeatles);

        ArrayList<String> filteredBeatles2 = new ArrayList<>();
        for(String name : beatles){
            if(name.startsWith("J")){
                filteredBeatles2.add(name);
            }
        }
        System.out.println(filteredBeatles2);


        for(int n : ints){
            if(isEven(n)){
                sum += n;
            }
        }
        System.out.println(sum);
    }
    public static boolean isEven(int n){

        return n % 2==0;
    }
}
