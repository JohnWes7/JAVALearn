package Algorithm.DynamicPrograming;

import java.util.ArrayList;

import Algorithm.mArr;

public class Longest_public_subsequence_problem {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 2, 4, 2 };
        int[] b = { 1, 3, 2, 2, 1, 2, 4, 2, 2 };
        System.out.println(LPSP(a, b));
    }

    public static int LPSP(int[] a, int[] b) {
        int[][] l = new int[a.length + 1][b.length + 1];
        int[][] path = new int[a.length + 1][b.length + 1];

        for (int i = 1; i < l.length; i++) {
            for (int j = 1; j < l[i].length; j++) {
                // L(i,j) 表示X0~i与Y0~j的集合中最长的子序列
                // L(i,j) = L(i-1,j-1)+1 Xi = Yj
                if (a[i - 1] == b[j - 1]) {
                    l[i][j] = l[i - 1][j - 1] + 1;
                    path[i][j] = 1;
                }
                // L(i,j) = max{L(i-1,j),L(i,j-1)} Xi!=Yj
                else if (l[i - 1][j] > l[i][j - 1]) {
                    l[i][j] = l[i - 1][j];
                    path[i][j] = 2;
                } else {
                    l[i][j] = l[i][j - 1];
                    path[i][j] = 3;
                }
            }
        }

        System.out.println("l:");
        mArr.PrintArray(l);
        System.out.println("path:");
        mArr.PrintArray(path);

        int i = a.length;
        int j = b.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (i > 0 && j > 0) {
            switch (path[i][j]) {
                case 1:
                    list.add(a[i - 1]);
                    i -= 1;
                    j -= 1;
                    break;
                case 2:
                    i -= 1;
                    break;
                case 3:
                    j -= 1;
                    break;
                default:
                    break;
            }
        }

        System.out.print("element: ");
        for (int k = list.size() - 1; k >= 0; k--) {
            System.out.print(list.get(k) + " ");
        }
        System.out.println();

        return l[a.length][b.length];
    }
}
