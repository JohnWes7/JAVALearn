package Algorithm.DynamicPrograming;

import Algorithm.mArr;

public class OptimalBinarySearchTree {
    public static void main(String[] args) {
        double[] p = { 0.1, 0.2, 0.4, 0.3 };

        System.out.println(OBST(p));
    }

    public static double OBST(double[] p) {
        double[][] c = new double[p.length + 2][p.length + 1];  //值矩阵
        int[][] r = new int[p.length + 1][p.length + 1];        //根矩阵

        // 赋初始值 C(i,i) = p[i-1];
        for (int i = 1; i < c[i].length; i++) {
            c[i][i] = p[i - 1];
            r[i][i] = i;
        }

        // 从最初的子问题开始填表 也就是C(1,2) C(2,3)...
        for (int d = 1; d < p.length; d++) {
            for (int i = 1; i + d <= p.length; i++) {
                int j = i + d;

                // 第一个先暂时存为最小值 也就是k=i的时候
                double min = c[i][i - 1] + c[i + 1][j];
                r[i][j] = i;
                // min(c(i,k-1) + c(k+1,j) + sum(i~j))
                double sum = p[i - 1];
                for (int k = i + 1; k <= j; k++) {
                    double temp = c[i][k - 1] + c[k + 1][j];
                    sum += p[k - 1];
                    if (temp < min) {
                        min = temp;
                        r[i][j] = k;
                    }
                }

                c[i][j] = min + sum;
            }
        }

        mArr.PrintArray(c);
        mArr.PrintArray(r);

        return c[1][p.length];
    }
}
