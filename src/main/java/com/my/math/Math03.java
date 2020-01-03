package com.my.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Math03 {
/*
 소요시간 : 3:00
 체감 난이도 : 중하
 GCD합-백준 https://www.acmicpc.net/problem/9613
 양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.
 */
    //GCD:최대공약수 , LCM :최소공배수
    static int BIG,SMALL,NMG;
    static long SUM = 0;
    static List<Long> list = new ArrayList<>();

    public static void Gcds(int [] intArr,int curval,int limit){
        if(curval==limit-1){
            return;
        }

        for(int i=curval+1;i<limit;i++){
            SUM+=Gcd(intArr[curval],intArr[i]);
        }

        Gcds(intArr,curval+1,limit);
    }

    public static int Gcd(int a,int b){
        if(a>b){
            BIG=a;
            SMALL=b;
        }else{
            BIG=b;
            SMALL=a;
        }
        while(true){
            NMG = BIG%SMALL;
            if(NMG==0) {
                return SMALL;
            }
            BIG=SMALL;
            SMALL=NMG;
        }

    }

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        for(int i=0;i<cnt;i++){
            int num = sc.nextInt();
            int [] intArr= new int[num];
            for(int j=0;j<num;j++){
                intArr[j]=sc.nextInt();
            }

            Gcds(intArr,0,num);
            list.add(SUM);
            SUM=0;

        }
        sc.close();
        for(long sum : list){
                System.out.println(sum);
            }
    }
}
