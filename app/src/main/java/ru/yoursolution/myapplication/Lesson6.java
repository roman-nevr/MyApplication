package ru.yoursolution.myapplication;

import java.util.Arrays;

/**
 * Created by Admin on 19.01.2017.
 */

public class Lesson6 {

    private int[] buffer;

    public int solution(int[] A) {
        buffer = new int[A.length];
        if(A.length <= 1){
            return A.length;
        }
        sort(A, 0, A.length);
        int number = A[0];
        int sum = 1;
        for (int i = 1; i < A.length; i++){
            if(A[i] != number){
                sum++;
                number = A[i];
            }
        }
        return sum;
    }

    public void sort(int[] a, int from, int to) {
        int div = (from + to) / 2;
        if (to - from > 1) {
            sort(a, from, div);
            sort(a, div, to);
            System.arraycopy(a, from, buffer, from, to - from);
            int l = from, r = div;
            int i = from;
            while (i < to) {
                if (buffer[l] > buffer[r]) {
                    a[i] = buffer[r];
                    r++;
                    if(r == to && (i + 1 < to)){
                        System.arraycopy(buffer, l, a, i + 1, to - i - 1);
                        i = to;
                    }
                } else {
                    a[i] = buffer[l];
                    l++;
                    if(l == div && (i + 1 < to)){
                        System.arraycopy(buffer, r, a, i + 1, to - i - 1);
                        i = to;
                    }
                }
                i++;
            }
        }
    }

    public void qsort(int[] a){
        qsortPivot(a, 0, a.length);
        //doSort(a, 0, a.length - 1);
    }

    private void qsortPivot(int[] a, int from, int to){
        if(to - from > 2){
            int middle = (to + from) / 2;
            //int pivot = a[(to + from) / 2];
            int pivot = (a[from] + a[to - 1] + a[middle]) / 3;
            int l = from;
            int r = to - 1;
            //System.out.println("from: " + from + ", to: " + to + ", pivot: " + pivot);
            //printRange(a, from, to);
            while (l < r){
                while (a[l] <= pivot && l < r){
                    l++;
                }
                while (a[r] > pivot && r > l){
                    r--;
                }
                if(l < r){
                    swap(a, l, r);
                }
            }
            qsortPivot(a, from, l);
            qsortPivot(a, l, to);
        }else {
            if(to - from == 2){
                if(a[from] > a[to - 1]){
                    swap(a, from, to - 1);
                }
            }
        }
    }

    private void printRange(int[] a, int from, int to) {
        for(int i = 0; i < a.length; i++){
            if(i == from ){
                System.out.print("[");
            }else
                System.out.print(" ");
            System.out.print(a[i]);
            if(i == to - 1){
                System.out.print("]");
            }else
                System.out.print(" ");
        }
        System.out.println("");
    }

    private void swap(int[] a, int l, int r){
        //swapPrint(a,l,r);
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
        //swapPrint(a,l,r);
    }

    private void swapPrint(int[] a, int l, int r){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i<a.length;i++){
            if(i == l || i == r){
                builder.append("[" + a[i] + "]");
            }else {
                builder.append(" " + a[i] + " ");
            }
            if (i != a.length - 1){
                builder.append(", ");
            }
        }
        System.out.println(builder.toString() + "]");
    }

    public void bsort(int[] a){
        for(int i = 0; i < a.length; i++){
            for(int j = i; j < a.length; j++){
                if(a[j] < a[i]){
                    swap(a, i, j);
                }
            }
        }
    }

    public void doSort(int[] array, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(array, start, cur);
        doSort(array, cur+1, end);
    }


}
