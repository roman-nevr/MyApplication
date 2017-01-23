package ru.yoursolution.myapplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Admin on 17.01.2017.
 */

public class Lesson4 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++){
            set.add(A[i]);
        }
        int missing = 1;
        while (set.contains(missing++)){}
        return missing - 1;
    }

    public int solution(int X, int[] A) {
        HashSet<Integer> set = new HashSet<>(X);
        for(int i = 1; i < X + 1; i++){
            set.add(i);
        }

        int time = 0;
        while (!set.isEmpty() && time < A.length){
            set.remove(A[time]);
            time++;
        }
        if(set.isEmpty()){
            return time - 1;
        }else {
            return -1;
        }
    }
    public int solution2(int[] A) {
        // write your code in Java SE 8
        HashSet<Integer> set = new HashSet<>(A.length);
        for(int i = 0; i < A.length; i++){
            set.add(i + 1);
        }
        for(int i = 0; i < A.length; i++){
            set.remove(A[i]);
        }
        if(set.isEmpty()){
            return 1;
        }else {
            return 0;
        }
    }

    public int[] solution2(int N, int[] A) {
        // write your code in Java SE 8
        int max = 0;
        boolean maximized = true;
        int[] counters = new int[N];
        for(int i = 0; i < A.length; i++){
            if(A[i] == N+1){
                if(!maximized){
                    maximaze(counters, max);
                    maximized = true;
                }
            }else {
                counters[A[i] - 1]++;
                if(max < counters[A[i] - 1]){
                    max = counters[A[i] - 1];
                    maximized = false;
                }
            }
        }
        return counters;
    }

    private void maximaze(int[] counters, int max) {
        for(int i = 0; i < counters.length; i++){
            counters[i] = max;
        }
    }

}
