package ru.yoursolution.myapplication;

/**
 * Created by Admin on 17.01.2017.
 */

public class Lesson3 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int headIndex = 0;
        int headSum = A[headIndex];
        int tailIndex = A.length - 1;
        int tailSum = A[tailIndex];
        while (headIndex + 1 < tailIndex){
            if(Math.abs(headSum + A[headIndex + 1]) < Math.abs(tailSum + A[tailIndex - 1])){
                headIndex++;
                headSum = headSum + A[headIndex];
            }else {
                tailIndex--;
                tailSum = tailSum + A[tailIndex];
            }
        }
        return Math.abs(headSum - tailSum);
    }
}
