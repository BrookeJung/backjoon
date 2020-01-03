package com.my.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 소요시간 : 1:40
 체감 난이도 : 중하
 골드바흐의 추측-백준 https://www.acmicpc.net/problem/6588
 1742년, 독일의 아마추어 수학가 크리스티안 골드바흐는 레온하르트 오일러에게 다음과 같은 추측을 제안하는 편지를 보냈다.

4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
예를 들어 8은 3 + 5로 나타낼 수 있고, 3과 5는 모두 홀수인 소수이다. 또, 20 = 3 + 17 = 7 + 13, 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.

이 추측은 아직도 해결되지 않은 문제이다.

백만 이하의 모든 짝수에 대해서, 이 추측을 검증하는 프로그램을 작성하시오.
 */
public class Math05 {
    static final int MAX = 1000000;
    static List<String> list ;
    static List<Integer> prime ;
    static boolean[] isPrimeArr; // true : 소수x false: 소수

    public static void getAns(int num){
        for(int i=1;i<prime.size();i++){
            int p = prime.get(i);
            if(isPrimeArr[num-p]==false){
                StringBuilder sb = new StringBuilder();
                sb.append(num);
                sb.append(" = ");
                sb.append(p);
                sb.append(" + ");
                sb.append(num-p);
                list.add(sb.toString());
                break;
            }
        }
    }


    public static void main(String[] args) {
        list = new ArrayList<String>();
        prime = new ArrayList<Integer>();
        isPrimeArr = new boolean[MAX+1];
        isPrimeArr[0]= isPrimeArr[1] = true; // 0,1은 소수가아님
        for(int i=2;i<=Math.sqrt(MAX+1);i++){
            if(isPrimeArr[i]==true){
                continue;
            }
            prime.add(i);
            for(int j=i*i; j<MAX+1; j+=i){
                isPrimeArr[j]=true;
            }
        }
        Scanner sc = new Scanner(System.in);
        while(true){
            int a = sc.nextInt();
            if(a==0){
                for(String str : list){
                    System.out.println(str);
                }
                break;
            }
            getAns(a);

        }

    }
}
