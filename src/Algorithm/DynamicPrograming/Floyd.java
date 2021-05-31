package Algorithm.DynamicPrograming;

import Algorithm.mArr;

public class Floyd {
    public static void main(String[] args) {
        int[][] src1 = { { 0, 4, 11 }, { 6, 0, 2 }, { 3, 1000, 0 } };
        int[][] dist1 = new int[3][3];
        FloydAm(src1, dist1);
        mArr.PrintArray(dist1);

        
    }

    public static void srcInIt(int[][] src) {
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[i].length; j++) {
                if (i == j) {
                    src[i][j] = 0;
                } else {
                    src[i][j] = 1000;
                }
            }
        }
    }

    public static void FloydAm(int[][] src, int[][] dist) {
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[i].length; j++) {
                dist[i][j] = src[i][j];
            }
        }

        for (int k = 0; k < dist.length; k++) {
            for (int i = 0; i < dist.length; i++) {
                for (int j = 0; j < dist.length; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}