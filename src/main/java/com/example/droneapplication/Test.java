package com.example.droneapplication;

public class Test {

    public static void main(String args[]){
        //String st=new StringBuilder("hi").reverse().toString();
       // System.out.println(st);
        String str="(()";
        int a=0;
        int b=0;
        int remain=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                a++;
            }
            else if(str.charAt(i)==')'){
                    b++;
                }
            }

        remain=a-b;
        System.out.println(remain);

    }
}
