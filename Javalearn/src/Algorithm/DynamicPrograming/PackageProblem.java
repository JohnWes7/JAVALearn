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
                //如果装的下第i个 则判断装入后和不装入的比较 比较哪个value更大
                if (j >= weight[i - 1]) {
                    tabel[i][j] = Math.max(tabel[i - 1][j - weight[i - 1]] + value[i - 1], tabel[i - 1][j]);
                }
                //如果整个背包大小装不下 则直接等于这个不装的value值 也就是上一行table[i-1][j]
                 else {
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
