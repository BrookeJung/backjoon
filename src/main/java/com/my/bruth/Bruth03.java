package com.my.bruth;

import java.util.Scanner;

public class Bruth03 {
/*
    기초 브루트포스 테트로미노 14500 https://www.acmicpc.net/problem/14500
    난이도 : 중하
    소요시간 : 1

    정사각형 4개를 이어놓은걸 테트로미노라고하고 5가지가있다.

    N*M 의 종이 위에 테트로미노 하나를 놓을때 , 놓인 칸 수의 합이 최대가 되게 하는 프로그램을 작성하시오.

    입력 :
    첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)
    둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다.
     입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.
     ****  **
           **
     *  *
     *  **  ***
     **  *   *

     1) 90'돌리는방법으로 2가지 *+++ 기준점으로 한다면 기준점을 잡아 행열에 대해서 도형을 다음과같이 표현할 수 있다.
      {(0,1),(0,2),(0,3)},{(1,0),(2,0),(3,0)}
     2) 1가지
      {(0,1),(0,1),(1,1)}
     3) 90'씩 4가지 *2 =8가지
      {(),(),()}
     4) 90'씩 4가지
     5) 90'씩 4가지
     총 19가지가 있다.
     5 5
1 2 3 4 5
5 4 3 2 1
2 3 4 5 6
6 5 4 3 2
1 2 1 2 1
 */
    static int SUM=Integer.MIN_VALUE;
    static int[][] ARR;
    static int [][][] TETROMINO = {
            {{0,1}, {0,2}, {0,3}},
            {{1,0}, {2,0}, {3,0}},
            {{1,0}, {1,1}, {1,2}},
            {{0,1}, {1,0}, {2,0}},
            {{0,1}, {0,2}, {1,2}},
            {{1,0}, {2,0}, {2,-1}},
            {{0,1}, {0,2}, {-1,2}},
            {{1,0}, {2,0}, {2,1}},
            {{0,1}, {0,2}, {1,0}},
            {{0,1}, {1,1}, {2,1}},
            {{0,1}, {1,0}, {1,1}},
            {{0,1}, {-1,1}, {-1,2}},
            {{1,0}, {1,1}, {2,1}},
            {{0,1}, {1,1}, {1,2}},
            {{1,0}, {1,-1}, {2,-1}},
            {{0,1}, {0,2}, {-1,1}},
            {{0,1}, {0,2}, {1,1}},
            {{1,0}, {2,0}, {1,1}},
            {{1,0}, {2,0}, {1,-1}},
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ARR = new int [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ARR[i][j]=sc.nextInt();
            }
        }
    getBiggerst(n,m);
    }

    public static void getBiggerst(int n,int m) {
        Boolean outOfIndex = false;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int t=0;t<19;t++){
                    int sum =0;
                    sum += ARR[i][j];
                   int[][] block = TETROMINO[t]; //{{0,0}{0,0}{0,0}};
                    for(int idx=0;idx<3;idx++) {
                        int x = i + block[idx][0];
                        int y = j + block[idx][1];
                        if (x < n && x >= 0 && y < m && y >= 0) {
                            sum += ARR[x][y];
                        } else {
                            sum = 0;
                            break;
                        }
                    }
                    if(sum!=0&&sum>SUM){
                        SUM=sum;
                    }
                }
            }
        }
        System.out.println(SUM);
    }
}
