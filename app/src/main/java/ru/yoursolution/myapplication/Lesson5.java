package ru.yoursolution.myapplication;

import java.util.Date;
import java.util.Random;

/**
 * Created by Admin on 17.01.2017.
 */

public class Lesson5 {
    public int solution(int A, int B, int K){
        /*if (A % K == 0){
            return (B - A) / K + 1;
        }else {
            int temp = A / K + K;
            if(temp < B){
                return (B - A - A % K) / K + 1;
            }else {
                return 0;
            }
        }*/
        //return (B - A - A % K) / K + 1;
        if(A == B){
            if((A % K == 0)){
                return 1;
            }
        }else {
            if(A % K == 0){
                return (B - A) / K + 1;
            }else {
                return (B - A - (K - A % K)) / K + 1;
            }
        }
        return 0;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int sum = 0;
        int number = 0;
        boolean tooMany = false;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 0){
                number++;
            }
            if (A[i] == 1){
                sum = sum + number;
                if (sum > 1000_000_000){
                    return -1;
                }
            }
        }
        if(tooMany){
            return -1;
        }
        return sum;
    }

    private int position;
    private float min;

    public int solution_slice(int[] A) {
        // write your code in Java SE 8
        min = (A[A.length - 3] + A[A.length - 2] + A[A.length - 1]) / 3.0f;
        position = A.length - 3 ;

        for (int i = 0; i < A.length - 3; i++){
            float two = (A[i] + A[i + 1]) / 2.0f;
            checkAndDecide(i, two);
            float three = (A[i] + A[i + 1] + A[i + 2]) / 3.0f;
            checkAndDecide(i, three);
            float four = (A[i] + A[i + 1] + A[i + 2] + A[i + 3]) / 4.0f;
            checkAndDecide(i, four);
        }

        float two = (A[A.length - 2] + A[A.length - 1]) / 2.0f;
        checkAndDecide(A.length - 2, two);

        two = (A[A.length - 3] + A[A.length - 2]) / 2.0f;
        checkAndDecide(A.length - 3, two);
        return position;
    }

    private void checkAndDecide(int position, float num){
        if(min > num){
            this.position = position;
            min = num;
        }
    }

    final static int N = 100000;
    final static int M = 50000;
    public String getDna(){
        Random random = new Random(new Date().getTime());
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < N; i++){
            switch (random.nextInt(4)){
                case 0:{builder.append("A");break;}
                case 1:{builder.append("C");break;}
                case 2:{builder.append("G");break;}
                case 3:{builder.append("T");break;}
            }
            //builder.append("G");
        }
        return builder.toString();
    }
    public int[] getP(){
        int[] res = new int[M];
        Random random = new Random(new Date().getTime());
        for(int i = 0; i < M; i++){
            res[i] = random.nextInt(M);
        }
        return res;
    }
    public int[] getQ(int[] P){
        int[] res = new int[M];
        Random random = new Random(new Date().getTime());
        for(int i = 0; i < M; i++){
            int num = random.nextInt(M);
            while (num < P[i]){
                num = random.nextInt(M);
            }
            res[i] = num;
        }
        return res;
    }
    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int[][] indexArray = new int[S.length()][4];
        indexArray = createIndex(S);
        int[] result = new int[P.length];
        for(int quieryNumber = 0; quieryNumber < P.length; quieryNumber++){
            result[quieryNumber] = getNearest(P[quieryNumber], Q[quieryNumber], indexArray) + 1;
        }
        return result;
    }

    private int getNearest(int from, int to, int[][] indexArray) {
        for(int i = 0; i < 4; i++){
            if(indexArray[from][i] <= to){
                return i;
            }
        }
        return -1;
    }

    private int[][] createIndex(String s) {
        int[][] index = new int[s.length() + 1][4];
        index[s.length()] = new int[]{s.length(), s.length(), s.length(), s.length()};
        for (int i = s.length() - 1; i >= 0; i--){
            System.arraycopy(index[i + 1], 0, index[i], 0, 4);
            index[i][factorOfChar(s.charAt(i)) - 1] = i;
        }
        return index;
    }

    //A,C,G,T
    private int factorOfChar(int i) {
        switch (i){
            case 65: return 1;//A
            case 67: return 2;//C
            case 71: return 3;//G
            case 84: return 4;//T
            default: {
                System.out.println(i);
                throw new IllegalArgumentException();}
        }
    }
}
