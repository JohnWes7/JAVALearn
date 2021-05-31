package Algorithm.DynamicPrograming;

import java.util.ArrayList;

public class TSP {
    public static void main(String[] args) {
        int[][] src = {{0,3,6,7},{5,0,2,3},{6,4,0,2},{3,7,5,0}};
        ArrayList<Integer> d = new ArrayList<Integer>();
        d.add(1);
        d.add(2);
        d.add(3);
        System.out.println(TSPProblem(src, 0, 0, d));
    }

    public static int TSPProblem(int[][] src, int destination, int start, ArrayList<Integer> d){

        if (d.size() == 0) {
            return src[start][destination];
        }

        ArrayList<Integer> jh = (ArrayList<Integer>)d.clone();
        jh.remove(0);
        int min = TSPProblem(src, destination, d.get(0), jh) + src[start][d.get(0)];

        for (int i = 1; i < d.size(); i++) {
            jh = (ArrayList<Integer>)d.clone();
            jh.remove(i);
            int temp = TSPProblem(src, destination, d.get(i), jh) + src[start][d.get(i)];
            if (temp < min) {
                min = temp;
            }
        }

        return min;
    }
}