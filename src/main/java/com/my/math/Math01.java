package com.my.math;

import java.io.*;
//백준 2609
public class Math01 {

     static int S ,B,nmg,GB,GY;

    public static void Gbgy(int a, int b){

//   최대공약수 b,s
//    while(true){
//    b%s = nmg
//    if(nmg==0)
//    최대공약수 = b
//    }
//    최소공배수 = 최대공약수 * b * s
//
      if(a<b){
          B= b;
          S = a;
      }else{
          B=a;
          S=b;
      }

       GY = gy(B,S);
       GB = (a*b)/GY;

        System.out.println(GY);
        System.out.println(GB);
    }

    public static int gy(int a, int b){
        if(b==0)
            return a;
        return gy(b,a%b);
    }

     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String str = br.readLine();
         String [] strarr = str.split(" ");
         int a = Integer.parseInt(strarr[0]);
         int b = Integer.parseInt(strarr[1]);
        Gbgy(a,b);
        br.close();
     }

}
