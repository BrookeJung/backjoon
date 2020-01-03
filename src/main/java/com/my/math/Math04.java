package com.my.math;

import java.util.Scanner;

/*
 소요시간 : 10분
 체감 난이도 : 하
 소수 찾기-백준 https://www.acmicpc.net/problem/1978
 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 */
public class Math04 {

    public static boolean isPrime(int num){
       double limit = Math.sqrt(num);
       if(num==1)
           return false;
       for(int i=2;i<=limit;i++){
            if(num%i==0)
                return false;
       }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int sum=0;
        for(int i=0;i<cnt;i++){
           sum+= (isPrime(sc.nextInt())==true)? 1:0;
        }
        System.out.println(sum);

    }
}
