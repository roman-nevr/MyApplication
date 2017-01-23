package ru.yoursolution.myapplication;

import java.util.Date;
import java.util.Random;

/**
 * Created by Admin on 18.01.2017.
 */

public class WaterWall {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    private int[] wall;
    private long startTime;
    private int width;
    private int height;

    public WaterWall(int[] wall) {
        this.wall = wall;
        startTime = time();
        height = 0;
        for(int i = 0; i < wall.length; i++){
            if(wall[i] > height){
                height = wall[i];
            }
        }
        width = wall.length;
    }

    public WaterWall() {
        wall = new int[WIDTH];
        Random random = new Random(new Date().getTime());
        for (int i = 0; i < WIDTH; i++) {
            wall[i] = random.nextInt(HEIGHT);
        }
        width = WIDTH;
        height = HEIGHT;
    }

    private long time() {
        return new Date().getTime();
    }


    public int calcWater() {
        //System.out.println(toString());
        int leftMaxIndex = findNextMaxIndex(0, wall);
        int volume = 0;
        int i = leftMaxIndex;
        boolean previousIsLower;
        startTime = time();
        while (i < width) {
            int nextMaxIndex = findNextMaxIndex(findNextBottonIndex(i, wall), wall);
            if (nextMaxIndex != -1) {
                volume = volume + calcVolume(i, nextMaxIndex, wall);
                if (wall[nextMaxIndex] >= wall[i] && wall[nextMaxIndex] < wall[leftMaxIndex]){
                    /*int k = nextMaxIndex - 1;
                    while (wall[k] < wall[nextMaxIndex]){
                        volume = volume + (wall[nextMaxIndex] - wall[k]);
                        wall[k] = wall[nextMaxIndex];
                        k--;
                    }*/
                    volume = volume + calcStepVolume2(nextMaxIndex, wall);
                }
                if (wall[nextMaxIndex] >= wall[leftMaxIndex]) {
                    int k = leftMaxIndex;
                    int rightMaxIndex = nextMaxIndex;
                    /*int nextStepIndex = findNextMaxIndex(findNextBottonIndex(k, wall), wall);
                    while (nextStepIndex < rightMaxIndex) {
                        int volumeIncrement = (wall[k] - wall[nextStepIndex]) * (rightMaxIndex - k - 1);
                        if (volumeIncrement < 0) {
                            volumeIncrement = 0;
                        }
                        volume = volume + volumeIncrement;
                        k = nextStepIndex;
                        nextStepIndex = findNextMaxIndex(findNextBottonIndex(k, wall), wall);
                    }*/
                    volume = volume + calcStepVolume(leftMaxIndex, rightMaxIndex, wall);
                    leftMaxIndex = nextMaxIndex;
                }
                i = nextMaxIndex;
            } else {
                return volume;
            }
        }
        return volume;
    }

    private int calcStepVolume2(int to, int[] wall){
        int volume = 0;
        int k = to - 1;
        while (wall[k] < wall[to]){
            volume = volume + (wall[to] - wall[k]);
            wall[k] = wall[to];
            k--;
        }
        return volume;
    }

    private int calcStepVolume(int from, int to, int[] wall){
        int volume = 0;
        int start = from;
        /*int nextStepIndex = findNextMaxIndex(findNextBottonIndex(from, wall), wall);
        while (nextStepIndex < to) {
            int volumeIncrement = (wall[from] - wall[nextStepIndex]) * (to - from - 1);
            if (volumeIncrement < 0) {
                volumeIncrement = 0;
            }
            volume = volume + volumeIncrement;
            from = nextStepIndex;
            nextStepIndex = findNextMaxIndex(findNextBottonIndex(from, wall), wall);
        }
        for(int i = from; i < to; i++){
            wall[i] = wall[start];
        }*/
        int min = getMinInner(from, to, wall);
        for (int i = from; i < to; i++){
            volume = volume + (min - wall[i]);
        }
        return volume;
    }

    private int findNextBottonIndex(int start, int[] wall) {
        int i = start + 1;
        while (i < width - 1) {
            if (wall[i] >= wall[i + 1]) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }

    private int findNextMaxIndex(int start, int[] wall) {
        int i = start;
        while ((i < width - 1) && start != -1) {
            if (wall[i] <= wall[i + 1]) {
                i++;
            } else {
                return i;
            }
            if ((i == width - 1) && wall[i] >= wall[start]) {
                return i;
            }

        }
        return -1;
    }


    private int calcVolume(int from, int to, int[] wall) {
        int volume = 0;
        int min = getMinInner(from, to, wall);
        for (int i = from + 1; i < to; i++) {
            volume = volume + localVolume(min, wall[i]);
            wall[i] = min;//льем воду
        }
        return volume;
    }

    private int localVolume(int max, int i) {
        return max > i ? max - i : 0;
    }

    private int getMinInner(int from, int to, int[] wall) {
        return wall[from] < wall[to] ? wall[from] : wall[to];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int outHeight = 0; outHeight < height; outHeight++) {
            for (int outWidth = 0; outWidth < width; outWidth++) {
                stringBuilder.append(wall[outWidth] >= height - outHeight ? "[x]" : "   ");
            }
            stringBuilder.append("\n");
        }
        for (int i = 0; i < width; i++) {
            stringBuilder.append(" " + i + " ");
        }
        stringBuilder.append("\n");
        for (int i = 0; i < width; i++) {
            stringBuilder.append(" " + wall[i] + ",");
        }
        stringBuilder.append("\ntime: " + (time() - startTime));
        return stringBuilder.toString();
    }

    public int calculateVolume() {

        int land[] = wall;

        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = land.length - 1;
        int volume = 0;

        while(left < right) {
            if(land[left] > leftMax) {
                leftMax = land[left];
            }
            if(land[right] > rightMax) {
                rightMax = land[right];
            }
            if(leftMax >= rightMax) {
                volume += rightMax - land[right];
                right--;
            } else {
                volume += leftMax - land[left];
                left++;
            }
        }
        return volume;
    }
}
