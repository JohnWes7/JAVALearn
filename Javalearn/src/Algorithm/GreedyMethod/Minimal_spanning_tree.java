package Algorithm.GreedyMethod;

public class Minimal_spanning_tree {
    public static void main(String[] args) {
        int[][] arc = new int[6][6];

        AddPath(arc, 0, 1, 34);
        AddPath(arc, 0, 2, 46);
        AddPath(arc, 0, 5, 19);

        AddPath(arc, 1, 4, 12);

        AddPath(arc, 2, 3, 17);
        AddPath(arc, 2, 5, 25);

        AddPath(arc, 3, 4, 38);
        AddPath(arc, 3, 5, 25);

        AddPath(arc, 4, 5, 26);

        System.out.println("Smu Lenght: " + Prim(arc, 0));
    }

    public static void AddPath(int[][] arc, int i, int j, int weight) {
        arc[i][j] = weight;
        arc[j][i] = weight;
    }

    public static int Prim(int[][] arc, int start) {
        Edge[] shortEdge = new Edge[arc.length];
        int sum = 0;

        // 初始化
        for (int i = 0; i < arc.length; i++) {
            shortEdge[i] = new Edge(arc[start][i], start);
        }
        shortEdge[start].cost = -1;

        System.out.print("Edges:");
        // 执行一次就会并入一个点进来 所以只需要n-1次
        for (int i = 0; i < arc.length - 1; i++) {
            int min = -1;
            int newRoot = -1;

            for (int j = 0; j < shortEdge.length; j++) {
                if (shortEdge[j].cost != -1 && shortEdge[j].cost != 0) {
                    if (min == -1 || shortEdge[j].cost < min) {
                        min = shortEdge[j].cost;
                        newRoot = j;
                    }
                }
            }

            sum += min;
            shortEdge[newRoot].cost = -1; // 表示这个点已经加入数组了
            System.out.print(" " + (shortEdge[newRoot].root) + "--" + (newRoot));

            // 在生成树增加节点后 调整shortEdge (可以用新的点来连接了)
            for (int j = 0; j < shortEdge.length; j++) {
                if (shortEdge[j].cost != -1 && arc[newRoot][j] != 0) {
                    if (arc[newRoot][j] < shortEdge[j].cost || shortEdge[j].cost == 0) {
                        shortEdge[j].cost = arc[newRoot][j];
                        shortEdge[j].root = newRoot;
                    }
                }
            }
        }
        System.out.println();

        return sum;
    }
}

class Edge {
    public int cost;
    public int root;

    public Edge(int cost, int root) {
        this.cost = cost;
        this.root = root;
    }
}
