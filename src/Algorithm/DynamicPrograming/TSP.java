package Algorithm.DynamicPrograming;

import java.util.ArrayList;

import Algorithm.mArr;

public class TSP {
    public static void main(String[] args) {
        int[][] src = { { 0, 3, 6, 7 }, { 5, 0, 2, 3 }, { 6, 4, 0, 2 }, { 3, 7, 5, 0 } };
        ArrayList<Integer> d = new ArrayList<Integer>();
        d.add(1);
        d.add(2);
        d.add(3);
        mArr.PrintArray(src);
        System.out.println(TSPProblem(src, 0, 0, d));
        System.out.println();
        System.out.println(TSPProblem(src));

    }
    
    @SuppressWarnings("unchecked")
    public static int TSPProblem(int[][] src, int destination, int start, ArrayList<Integer> d) {

        if (d.size() == 0) {
            return src[start][destination];
        }
        
        ArrayList<Integer> jh = (ArrayList<Integer>) d.clone();
        jh.remove(0);
        int min = TSPProblem(src, destination, d.get(0), jh) + src[start][d.get(0)];

        for (int i = 1; i < d.size(); i++) {
            jh = (ArrayList<Integer>) d.clone();
            jh.remove(i);
            int temp = TSPProblem(src, destination, d.get(i), jh) + src[start][d.get(i)];
            if (temp < min) {
                min = temp;
            }
        }

        return min;
    }

    public static int TSPProblem(int[][] src) {
        // 用位来代表集合中的元素
        int collects = (1 << (src.length - 1)) - 1;

        int[][] d = new int[src.length][collects + 1];

        for (int i = 1; i < d.length; i++) {
            d[i][0] = src[i][0];
        }

        for (int j = 1; j < collects; j++) {
            for (int i = 1; i < src.length; i++) {
                // 集合v[j]中不含i
                if (((1 << (i - 1)) & j) == 0) {
                    int min = -1;

                    for (int k = 1; k < src.length; k++) {
                        // 集合中含有k
                        if (((1 << (k - 1)) & j) != 0) {
                            // 计算把k剔除之后 也就是i到k k经过v[j]中的元素各一遍然后到0的路程
                            int temp = src[i][k] + d[k][j - (1 << (k - 1))];

                            // 取最短保存
                            if (min == -1) {
                                min = temp;
                            } else if (temp < min) {
                                min = temp;
                            }
                        }
                    }

                    d[i][j] = min;
                }
            }
        }

        int min = src[0][1] + d[1][collects - 1];
        for (int i = 2; i < src.length; i++) {
            int temp = src[0][i] + d[i][collects - (1 << (i - 1))];
            if (temp < min) {
                min = temp;
            }
        }
        d[0][collects] = min;

        mArr.PrintArray(d);

        return d[0][collects];
    }
}