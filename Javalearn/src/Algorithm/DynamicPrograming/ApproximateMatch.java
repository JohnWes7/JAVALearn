package Algorithm.DynamicPrograming;

import Algorithm.mArr;

public class ApproximateMatch {
    public static void main(String[] args) {
        String p = "happy";
        String t = "happay";

        System.out.println(ASM(p, t));
    }

    public static int ASM(String p, String t) {
        int[][] D = new int[p.length() + 1][t.length() + 1];

        // 初始数字
        for (int i = 1; i <= p.length(); i++) {
            D[i][0] = i;
        }
        for (int i = 1; i <= t.length(); i++) {
            D[0][i] = i;
        }

        for (int i = 1; i < D.length; i++) {
            for (int j = 1; j < D[i].length; j++) {
                int min;

                if (p.charAt(i - 1) == t.charAt(j - 1)) {
                    min = D[i - 1][j - 1];
                } else {
                    min = D[i - 1][j - 1] + 1;
                }

                min = Math.min(min, D[i - 1][j] + 1);
                min = Math.min(min, D[i][j - 1] + 1);

                D[i][j] = min;
            }
        }

        mArr.PrintArray(D);

        return D[p.length()][t.length()];
    }
}
