package ru.yoursolution.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Lesson4 test = new Lesson4();
        Test1 test1 = new Test1();
        int[] a = {6, 6, 6, 6, 6, 4, 4};

        int[] b = {-1,3,-4,5,1,-6,2,1};
        test.solution2(5, a);

        Lesson5 lesson5 = new Lesson5();
        System.out.println(lesson5.solution(101, 123456789, 10000));
        System.out.println(lesson5.solution(11, 345, 17));
        System.out.println(lesson5.solution(6, 20, 10));
        System.out.println(lesson5.solution(0,0, 11));*/
        //System.out.println(test.solution(a));
        //waterWallTest();
        //cars();
        //minAvgSlice();
        //dnaTest();
        sorttest();
    }


    private void sorttest() {
        Lesson6 lesson6 = new Lesson6();
        int[] a = {2, 1, 1, 2, 3, 1};
        int[] b = new int[M];
        int[] c = new int[M];
        Date date = new Date();
        b = getP();
        System.arraycopy(b,0,c,0,M);
        //printArray(b);
        long startime = time();
        //Arrays.sort(c);
        lesson6.doSort(c, 0, c.length - 1);
        System.out.println("qsort");
        long javaTime = time();
        lesson6.qsort(b);
        long myqtime = time();
        //lesson6.bsort(b);
        //System.out.println(Arrays.toString(b));
        System.out.println("bubble: " + (time() - myqtime) + ", my qtime: " + (myqtime - javaTime) + ", qsort:" + (javaTime - startime));
        if(!Arrays.equals(c, b)){
            System.out.println("fail (");
            printArray(b, c);
        }
        //lesson6.sort(b, 0, b.length);
        //printArray(b, c);
        /*lesson6.qsort(b, 0, b.length);
        System.out.println(Arrays.toString(b));*/

        int i = 1;
    }

    private long time(){
        return new Date().getTime();
    }

    private void dnaTest() {
        Lesson5 lesson5 = new Lesson5();
        String s = "A";
        int[] p = {0};
        int[] q = {0};
        int[] P = lesson5.getP();
        int[] Q = lesson5.getQ(P);
        String dna = lesson5.getDna();
        long time = new Date().getTime();
        //lesson5.solution(dna, P, Q);
        printArray(lesson5.solution(s, p, q));
        System.out.println(new Date().getTime() - time);
        System.out.println("end");
    }

    private void minAvgSlice() {
        Lesson5 lesson5 = new Lesson5();
        int[] a = {4, 2, 2, 5, 1, 5, 8};
        System.out.println(lesson5.solution_slice(a));
    }

    private void cars() {
        Lesson5 lesson5 = new Lesson5();
        int[] a = {0, 1, 0, 1, 1};
        System.out.println(lesson5.solution(a));
    }

    private void waterWallTest() {
        int[] a = {8, 6, 7, 11, 6, 4, 5, 3, 11, 2, 3, 1, 5, 4, 3, 8};
        //int[] a = {3, 4, 0, 2, 4, 3, 6, 8, 0, 1};
        for(int i = 0; i < 10; i++){
            WaterWall waterWall = new WaterWall();
            System.out.println(waterWall.toString());
            //waterWall.calcWater();
            System.out.println(waterWall.calculateVolume());

            System.out.println("my: " + waterWall.calcWater());
        }
        System.out.println("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void printArray(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }

    private void printArray(int[] a, int[] b){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " : " + b[i]);
            if(a[i] == b[i]){
                System.out.println("");
            }else {
                System.out.println("<----here");
            }
        }
    }



    private static final int M = 3000;

    public int[] getP(){
        int[] res = new int[M];
        Random random = new Random(new Date().getTime());
        for(int i = 0; i < M; i++){
            res[i] = random.nextInt(M);
        }
        return res;
    }
}
