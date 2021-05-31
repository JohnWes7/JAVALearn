package Algorithm.DynamicPrograming;

import java.util.ArrayList;

public class Multi_segment_graph_shortest_path_problem {
    public static void main(String[] args) {

        // ArrayList<Integer> list = new ArrayList<Integer>();
        // System.out.println(list.size());
        // list.add(1);
        // System.out.println(list.size());

        int[][] map = new int[10][10];
        addMap(map, 0, 1, 4);
        addMap(map, 0, 2, 2);
        addMap(map, 0, 3, 3);
        addMap(map, 1, 4, 9);
        addMap(map, 1, 5, 8);
        addMap(map, 2, 4, 6);
        addMap(map, 2, 5, 7);
        addMap(map, 2, 6, 8);
        addMap(map, 3, 5, 4);
        addMap(map, 3, 6, 7);
        addMap(map, 4, 7, 5);
        addMap(map, 4, 8, 6);
        addMap(map, 5, 7, 8);
        addMap(map, 5, 8, 6);
        addMap(map, 6, 7, 6);
        addMap(map, 6, 8, 5);
        addMap(map, 7, 9, 7);
        addMap(map, 8, 9, 3);

        BackPath(map, 9);
    }

    public static void addMap(int[][] map, int i, int j, int weight) {
        map[i][j] = weight;
    }

    public static int BackPath(int[][] map, int destination) {
        ArrayList<Integer> cost = new ArrayList<Integer>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(-1);
        cost.add(0);

        for (int arrive = 1; arrive < map.length; arrive++) {
            for (int start = arrive - 1; start >= 0; start--) {
                // 0表示到不了直接下一个
                if (map[start][arrive] == 0) {
                    continue;
                }

                if (cost.size() > arrive) {
                    if (cost.get(start) + map[start][arrive] < cost.get(arrive)) {
                        cost.set(arrive, cost.get(start) + map[start][arrive]);
                        path.set(arrive, start);
                    }
                } else {
                    cost.add(map[start][arrive] + cost.get(start));
                    path.add(start);
                }

            }
        }

        int i = destination;
        System.out.print("path: " + i);
        while (i > 0) {
            i = path.get(i);
            System.out.print("-->" + i);
        }
        System.out.println();
        System.out.println("cost: " + cost.get(destination));

        return cost.get(destination);
    }
}