package Algorithm.GreedyMethod;

public class TSP {
    public static void main(String[] args) {
        int[][] src = { { 0, 3, 3, 2, 6 }, { 3, 0, 7, 3, 2 }, { 3, 7, 0, 2, 5 }, { 2, 3, 2, 0, 3 }, { 6, 2, 5, 3, 0 } };

        System.out.println("des: " + solute1(src, 0));
    }

    // 贪心算法只能得出最优近似解，不一定是最优解
    public static int solute1(int[][] src, int start) {
        int[] flag = new int[src.length];
        int u = start;
        int sum = 0;
        flag[u] = 1;

        System.out.print("path: " + u);

        for (int i = 0; i < flag.length - 1; i++) {
            int min = -1;
            int w = 0;
            for (int j = 0; j < flag.length; j++) {
                if (flag[j] == 0) {
                    if (min == -1) {
                        min = src[u][j];
                        w = j;
                    } else if (src[u][j] < min) {
                        min = src[u][j];
                        w = j;
                    }
                }
            }

            sum += min;
            flag[w] = 1;
            u = w;
            System.out.print(" --> " + w);
        }

        sum += src[u][start];
        System.out.print(" --> " + start + "\n");

        return sum;
    }

    
}
