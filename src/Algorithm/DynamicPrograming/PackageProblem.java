package Algorithm.DynamicPrograming;

import Algorithm.mArr;

public class PackageProblem {
    public static void main(String[] args) {
        int[] weight = { 2, 2, 6, 5, 4 };
        int[] value = { 6, 3, 5, 4, 6 };
        int v = PP(weight, value, 10);
        System.out.println(v);
    }

    public static int PP(int[] weight, int[] value, int contain) {
        int[][] tabel = new int[weight.length + 1][contain + 1];

        for (int i = 1; i < tabel.length; i++) {
            for (int j = 0; j < tabel[i].length; j++) {
                if (j >= weight[i - 1]) {
                    tabel[i][j] = Math.max(tabel[i - 1][j - weight[i - 1]] + value[i - 1], tabel[i - 1][j]);
                } else {
                    tabel[i][j] = tabel[i - 1][j];
                }
            }
        }

        mArr.PrintArray(tabel);

        System.out.print("element: ");
        int i = weight.length;
        int j = contain;
        while (i > 0) {
            if (tabel[i][j] > tabel[i - 1][j]) {
                System.out.print(i + " ");
                j -= weight[i - 1];
            }
            i--;
        }
        System.out.println();

        return tabel[weight.length][contain];
    }
}
