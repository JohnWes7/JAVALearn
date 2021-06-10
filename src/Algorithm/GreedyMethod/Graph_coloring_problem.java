package Algorithm.GreedyMethod;

import Algorithm.mArr;

public class Graph_coloring_problem {
    public static void main(String[] args) {
        int[][] gragh = new int[5][5];

        AddPath(gragh, 0, 1);
        AddPath(gragh, 1, 2);
        AddPath(gragh, 1, 3);
        AddPath(gragh, 2, 4);
        AddPath(gragh, 3, 4);

        ColorGragh(gragh);
    }

    public static void AddPath(int[][] gragh, int i, int j) {
        gragh[i][j] = 1;
        gragh[j][i] = 1;
    }

    public static void ColorGragh(int[][] gragh) {
        int color = 0;
        boolean flag = true;
        int[] colors = new int[gragh.length];

        while (flag) {
            color++;
            flag = false;

            for (int i = 0; i < colors.length; i++) {
                if (colors[i] == 0) {
                    if (isRight(i, color, colors, gragh)) {
                        colors[i] = color;
                    } else {
                        flag = true;
                    }
                }
            }
        }

        mArr.PrintArray(colors);
    }

    public static boolean isRight(int index, int color, int[] colors, int[][] gragh) {
        for (int i = 0; i < gragh.length; i++) {
            if (gragh[index][i] == 1 && color == colors[i]) {
                return false;
            }
        }

        return true;
    }
}
