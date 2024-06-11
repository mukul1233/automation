package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       String s="test12pop34java232python";
       String a[]=s.split("[0-9]+");
        String c[]=s.split("[a-z]+");

       String b[]=new String[a.length];
        System.out.println(Arrays.toString(c));
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<a.length;i++){
            b[i]=reverse(a[i]);
        }
        int counter=1;
        for(int i=0;i<a.length-1;i++){
            sb.append(b[i]);
            sb.append(c[counter]);
            counter++;
        }
        sb.append(b[b.length-1]);

        System.out.println(Arrays.toString((b)));
        System.out.println(sb);
    }

    public static String reverse(String s){
        String res="";
        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
             sb.append(s.charAt(i));
        }
        res=sb.toString();
        return res;
    }
}