package com.my.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
나머지-백준 https://www.acmicpc.net/problem/10430
소요시간 : 5분
체감난이도 : 하
    (A+B)%C는 (A%C + B%C)%C 와 같을까?
    (A×B)%C는 (A%C × B%C)%C 와 같을까?
    세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
*/
public class Math00 {

    static int A,B,C;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str= br.readLine();
        String[] strarr = str.split(" ");
        A = Integer.parseInt(strarr[0]);
        B = Integer.parseInt(strarr[1]);
        C = Integer.parseInt(strarr[2]);
        System.out.println((A+B)%C);
        System.out.println((A%C+B%C)%C);
        System.out.println((A*B)%C);
        System.out.println(((A%C)*(B%C))%C);
    }
}
