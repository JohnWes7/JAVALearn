package Algorithm.Homework;

import java.util.ArrayList;

import Algorithm.mArr;

//背包问题
public class Section6_3 {
    public static void main(String[] args) {
        int[] weight = { 3, 2, 1, 4, 5 };
        int[] value = { 25, 20, 15, 40, 50 };

        System.out.println("value: " + PP(weight, value, 6));
    }

    public static int PP(int[] weight, int[] value, int contain) {
        int[][] v = new int[weight.length + 1][contain + 1];

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j <= contain; j++) {
                // 装不下
                if (weight[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                }
                // 装的下
                else {
                    v[i][j] = Math.max(value[i - 1] + v[i - 1][j - weight[i - 1]], v[i - 1][j]);
                }
            }
        }

        mArr.PrintArray(v);

        int i = weight.length;
        int j = contain;
        ArrayList<Integer> collections = new ArrayList<Integer>();

        while (i > 0 && j > 0) {
            if (v[i][j] > v[i - 1][j]) {
                collections.add(i);
                j -= weight[i - 1];
            }
            i--;
        }

        System.out.print("collect:");
        for (int k = 0; k < collections.size(); k++) {
            System.out.print(" " + collections.get(k));
        }
        System.out.println();

        return v[weight.length][contain];
    }
}
