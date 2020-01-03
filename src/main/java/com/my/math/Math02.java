package com.my.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
소요시간 : 5:40~6:20
난이도 : 하
최소공배수-백준 https://www.acmicpc.net/problem/1934
두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다. 이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다. 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.

두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
 */
public class Math02 {

    static int SMALL,BIG,GY,GB,NMG;
    static List<Integer> list = new ArrayList<Integer>();

    public static void smgb(int a, int b) {
        if(a>b){
            SMALL=b;
            BIG=a;
        }else{
            SMALL=a;
            BIG=b;
        }
        while(true){
            NMG=BIG%SMALL;
            if(NMG==0){
                GY=SMALL;
                break;
            }
            BIG=SMALL;
            SMALL=NMG;
        }
        GB = (a*b)/GY;
        list.add(GB);


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        for(int i=0;i<cnt;i++){
            String str = br.readLine();
            String[] strarr = str.split(" ");
            int a = Integer.parseInt(strarr[0]);
            int b = Integer.parseInt(strarr[1]);
            smgb(a,b);
        }
        for(int a : list){
            System.out.println(a);
        }
    }
}
