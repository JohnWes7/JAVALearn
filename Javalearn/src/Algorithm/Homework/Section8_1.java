package Algorithm.Homework;

public class Section8_1 {
    public static void main(String[] args) {
        int[][] arc = new int[5][5];
        addPath(0, 1, arc);
        addPath(0, 4, arc);
        addPath(0, 3, arc);
        addPath(1, 4, arc);
        addPath(1, 2, arc);
        addPath(2, 3, arc);
        addPath(3, 4, arc);

        Coloring(arc);
    }

    public static void addPath(int a, int b, int[][] arc) {
        arc[a][b] = 1;
        arc[b][a] = 1;
    }

    public static void Coloring(int[][] arc) {
        int[] colors = new int[arc.length];

        int k = 0;
        while (k >= 0) {
            colors[k] += 1;

            while (colors[k] <= 3) {
                boolean flag = true;
                for (int i = 0; i < k; i++) {
                    if (arc[k][i] == 1 && colors[k] == colors[i]) {
                        colors[k] += 1;
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    break;
                }
            }

            // 找到可行解 输出 结束
            if (k == arc.length - 1 && colors[k] <= 3) {
                for (int i = 0; i < colors.length; i++) {
                    System.out.print(colors[i] + " ");
                }
                return;
            }

            if (k < arc.length - 1 && colors[k] <= 3) {
                k++;
            } else {
                colors[k] = 0;
                k--;
            }
        }
    }
}
