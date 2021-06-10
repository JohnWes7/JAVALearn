package Algorithm.Homework;

import java.util.ArrayList;

public class Section6_4 {
    public static void main(String[] args) {
        String a = "xzyzzyx";
        String b = "zxyyzxz";

        System.out.println("longest lenght: " + LongestSubString(a, b));
    }

    public static int LongestSubString(String a, String b) {
        int[][] l = new int[a.length() + 1][b.length() + 1];
        int[][] path = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i < l.length; i++) {
            for (int j = 1; j < l[i].length; j++) {
                // match
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    l[i][j] = l[i - 1][j - 1] + 1;
                    path[i][j] = 1;
                }
                // not match
                else if (l[i][j - 1] > l[i - 1][j]) {
                    l[i][j] = l[i][j - 1];
                    path[i][j] = 2;
                } else {
                    l[i][j] = l[i - 1][j];
                    path[i][j] = 3;
                }
            }
        }

        ArrayList<Character> collects = new ArrayList<Character>();
        int i = a.length();
        int j = b.length();
        while (i > 0 && j > 0) {
            switch (path[i][j]) {
                case 1:
                    collects.add(a.charAt(i - 1));
                    i--;
                    j--;
                    break;
                case 2:
                    j--;
                    break;
                case 3:
                    i--;
                    break;
                default:
                    break;
            }
        }

        System.out.print("collects:");
        for (int j2 = collects.size() - 1; j2 >= 0; j2--) {
            System.out.print(" " + collects.get(j2));
        }
        System.out.println();

        return l[a.length()][b.length()];
    }
}
