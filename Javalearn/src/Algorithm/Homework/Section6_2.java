package Algorithm.Homework;

import java.util.ArrayList;

import Algorithm.mArr;

//分步骤最短距离问题
public class Section6_2 {
    public static void main(String[] args) {
        int[][] map = new int[13][13];
        map[0][1] = 5;
        map[0][2] = 3;

        map[1][3] = 1;
        map[1][4] = 3;
        map[1][5] = 6;

        map[2][4] = 8;
        map[2][5] = 7;
        map[2][6] = 6;

        map[3][7] = 6;
        map[3][8] = 8;

        map[4][7] = 3;
        map[4][8] = 5;

        map[5][8] = 3;
        map[5][9] = 3;

        map[6][8] = 8;
        map[6][9] = 4;

        map[7][10] = 3;
        map[7][11] = 5;

        map[8][10] = 5;
        map[8][11] = 2;

        map[9][10] = 6;
        map[9][11] = 6;

        map[10][12] = 4;

        map[11][12] = 3;

        System.out.println(ShotestPath(map));
    }

    public static int ShotestPath(int[][] map) {
        int[] l = new int[map.length];
        int[] path = new int[map.length];

        for (int i = 1; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] == 0) {
                    continue;
                }

                int des = map[j][i] + l[j];

                if (l[i] == 0) {
                    l[i] = des;
                    path[i] = j;
                } else {
                    if (des < l[i]) {
                        l[i] = des;
                        path[i] = j;
                    }
                }
            }
        }

        mArr.PrintArray(l);
        mArr.PrintArray(path);

        int i = map.length - 1;
        ArrayList<Integer> plist = new ArrayList<Integer>();
        while (i > 0) {
            plist.add(i);
            i = path[i];
        }
        plist.add(0);

        System.out.print("path: " + plist.get(plist.size() - 1));
        for (int j = plist.size() - 2; j >= 0; j--) {
            System.out.print(" -> " + plist.get(j));
        }
        System.out.println();

        return l[map.length - 1];
    }
}
