package com.my.bruth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Bruth02 {
    /*
    기초 브루트포스 1476
    날짜계산 https://www.acmicpc.net/problem/1476

    이상한 나라에서 수 3개로 연도를 나타내는데 E(지구),S(태양),M(달)을 의미한다.
    1<=E<=15
    1<=S<=28
    1<=M<=19

    연도에 각 1 을 빼면
    0<=E<=14
    0<=S<=27
    0<=M<=18
    각 15, 28 ,19의 나머지 값계산으로 해결할 수 있다.

    1 1 1 이 1 년이고 1 년이 지날 때마다, 세수 모두 1 씩 증가한다. 수가 범위를 넘어가면 1 이된다.
    예를들어 15년은 15 15 15 지만 16년이 되면 1 16 16 이 된다.
    이나라의 E S M 년이 우리가 아는 연도로 몇년인지 구하는 프로그램을 작성하시오

    예제입력 1 16 16
    출력 16

    소요시간 : 2
    체감 난이도 : 중

    분석
    E : 15*a + E 년  즉 , 15로 나눈 나머지가 E 이면서
    S : 28*b + S 년   28로 나눈 나머지가 S 이고
    M : 19*c + M 년   19로 나눈 나머지가 M 인 수를 브루트 포스로 구한다.

    총 경우의 수는 15*28*19 =7980 로 브루트 포스가 가능하다 .

     */
    static int E =15; static int S=28; static int M=19;
    static int nmgForE,nmgForS,nmgForM;
    static int MAXYEAR = 7980;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String [] arr = str.split(" ");
        nmgForE = Integer.parseInt(arr[0])-1;
        nmgForS = Integer.parseInt(arr[1])-1;
        nmgForM = Integer.parseInt(arr[2])-1;
        getYear();
    }

    public static void getYear() {
        for(int y=0;y<MAXYEAR;y++){
            if((y%E==nmgForE)&&(y%S==nmgForS)&&(y%M==nmgForM)) {
                System.out.println(y+1);
                return;
            }
        }
    }
}
