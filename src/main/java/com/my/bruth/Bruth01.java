package com.my.bruth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 부르트 포스 01 백준 2309 백설공주와 일곱난장이
    소요시간 : 2
    체감 난이도 : 중

 */
public class Bruth01 {
    static int NINESUM;
    static final int TALLSUM = 100;

    //0~8중 두개골라서 더한걸 빼도록해자
    public static void pickTwo (List<Integer> ninetall , int cur ,int limit){
        if(cur==limit){
            return;
        }
        for(int i=cur+1;i<limit+1;i++){
            if(isAnswer(ninetall.get(cur),ninetall.get(i))){
                int a = ninetall.get(cur);
                int b = ninetall.get(i);
//                List<Integer> removeList = new ArrayList<Integer>();
//                removeList.add(ninetall.get(cur));
//                removeList.add(ninetall.get(i));
//                ninetall.removeAll(removeList);
                ninetall.removeIf(n->(n==a));
                ninetall.removeIf(n->(n==b));
                Collections.sort(ninetall);
                printarr(ninetall);
                return;
            }
        }
        pickTwo(ninetall,cur+1,limit);
    }

    public static boolean isAnswer (int i, int j){
        if(NINESUM-i-j==TALLSUM)
            return true;
        return false;
    }

    public static void printarr(List<Integer> sevenTall){
     Iterator it = sevenTall.iterator();
        while(it.hasNext()==true){
            System.out.println(it.next());
        }
    }

    public static void main(String[] args)throws IOException {
    int cnt = 0;
    List<Integer> ninetall = new ArrayList<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(cnt!=9) {
            int num=Integer.parseInt(br.readLine());
            NINESUM+=num;
            ninetall.add(num);
            cnt++;
        }
    pickTwo(ninetall,0,8);
    }

}
