package ru.yoursolution.myapplication;


import java.util.Arrays;

/**
 * Created by Admin on 16.01.2017.
 */

public class Test1 {
    public int solution(int N) {
        // write your code in Java SE 8
        int current = 0;
        int max = 0;
        if(N == 0){
            return 1;
        }
        while (N % 2 == 0){
            N = N / 2;
        }
        while (N > 0){
            int rest = N % 2;
            if (rest == 0){
                current++;
            }else {
                if (max < current){
                    max = current;
                }
                current = 0;

            }
            N = N / 2;
        }
        return max;
    }

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        K = K % A.length;
        int lenght = A.length - K;
        int[] first = Arrays.copyOf(A, lenght);
        int[] second = Arrays.copyOfRange(A, lenght, A.length);
        System.arraycopy(second, 0, A, 0, second.length);
        System.arraycopy(first, 0, A, second.length, first.length);
        return A;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        for(int i = 0; i < A.length; i++){
            result = result + A[i] - i;
        }
        return result - 1;
    }

    public int solution2(int[] A) {
        // write your code in Java SE 8
        if(A.length == 0){
            return -1;
        }
        if(A.length == 1){
            return 0;
        }
        long sumRight = 0;
        long sumLeft = 0;
        for(int i = 1; i < A.length; i++){
            sumRight = sumRight + A[i];
        }
        for(int i = 0; i < A.length; i++){
            if(sumLeft == sumRight){
                //return i;
                System.out.println(i + " ");
            }
            sumLeft = sumLeft + A[i];
            if(i + 1 == A.length){
                sumRight = 0;
            }else {
                sumRight = sumRight - A[i + 1];
            }
        }
        return -1;
    }
}
