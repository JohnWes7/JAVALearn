package Algorithm.BackTrack;

public class Coloring {
    public static void main(String[] args) {
        int[][] arc = new int[5][5];

        AddPath(0, 1, arc);
        AddPath(0, 2, arc);
        AddPath(1, 2, arc);
        AddPath(1, 3, arc);
        AddPath(1, 4, arc);
        AddPath(2, 4, arc);
        AddPath(3, 4, arc);

        ColorGragh(arc, 3);
    }

    public static void AddPath(int a, int b, int[][] arc) {
        arc[a][b] = 1;
        arc[b][a] = 1;
    }

    public static void ColorGragh(int[][] arc, int m) {
        int[] color = new int[arc.length];
        int index = 0;
        boolean flag = true;

        while (index >= 0) {
            for (int i = color[index] + 1; i <= m; i++) {
                color[index] = i;
                flag = true;

                for (int j = 0; j < index; j++) {
                    if (arc[index][j] == 1 && color[index] == color[j]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    break;
                }
            }

            if (index == color.length - 1 && flag) {
                System.out.print("ans:");
                for (int i = 0; i < color.length; i++) {
                    System.out.print(" " + color[i]);
                }
                System.out.println();
                return;
            }
    
            if (index < color.length - 1 && flag) {
                index++;
            } else {
                color[index] = 0;
                index--;
            }
        }

        
    }
}
