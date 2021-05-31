package Algorithm.DynamicPrograming;

import Algorithm.mArr;

public class Longest_public_subsequence_problem {
    public static void main(String[] args) {
        int[] a = {1,2,3,2,4,2};
        int[] b = {1,3,2,2,1,2,4,2,2};
        System.out.println(LPSP(a, b));
    }

    public static int LPSP(int[] a, int[] b) {
        int[][] l = new int[a.length + 1][b.length + 1];
        for (int i = 1; i < l.length; i++) {
            for (int j = 1; j < l[i].length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    l[i][j] = l[i - 1][j - 1] + 1;
                } else if (l[i - 1][j] > l[i][j - 1]) {
                    l[i][j] = l[i - 1][j];
                } else {
                    l[i][j] = l[i][j-1];
                }
            }
        }

        mArr.PrintArray(l);
        return l[a.length][b.length];
    }
}
