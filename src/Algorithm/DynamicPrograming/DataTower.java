package Algorithm.DynamicPrograming;

public class DataTower {
    public static void main(String[] args) {
        int[][] data = { { 8, 0, 0, 0, 0 }, 
                         { 12, 15, 0, 0, 0 }, 
                         { 3, 9, 6, 0, 0 }, 
                         { 8, 10, 5, 12, 0 },
                         { 16, 4, 18, 10, 9 } };
        DataTowerProblem(data);
    }

    public static void DataTowerProblem(int[][] data) {
        int length = data.length;
        int[][] maxTable = new int[data.length][data[0].length];
        int[][] path = new int[data.length][data[0].length];

        // 最下面一排初始化
        for (int i = 0; i < length; i++) {
            maxTable[length - 1][i] = data[length - 1][i];
        }

        // 计算选择
        for (int i = length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (maxTable[i + 1][j] > maxTable[i + 1][j + 1]) {
                    maxTable[i][j] = data[i][j] + maxTable[i + 1][j];
                    path[i][j] = j;
                } else {
                    maxTable[i][j] = data[i][j] + maxTable[i + 1][j + 1];
                    path[i][j] = j + 1;
                }
            }
        }

        System.out.print("路径为：" + data[0][0]);
        int next = path[0][0];
        for (int i = 1; i < path.length; i++) {
            System.out.print("-->" + data[i][next]);
            next = path[i][next];
        }
        System.out.println();

        System.out.println("max: " + maxTable[0][0]);
    }
}