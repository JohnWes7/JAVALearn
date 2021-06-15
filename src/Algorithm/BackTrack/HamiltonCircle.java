package Algorithm.BackTrack;

public class HamiltonCircle {
    public static void main(String[] args) {
        int[][] arc = new int[5][5];

        AddPath(0, 1, arc);
        AddPath(0, 3, arc);
        AddPath(1, 2, arc);
        AddPath(1, 4, arc);
        AddPath(2, 3, arc);
        AddPath(2, 4, arc);
        AddPath(3, 4, arc); 

        hc(arc);
    }

    public static void AddPath(int a, int b, int[][] arc) {
        arc[a][b] = 1;
        arc[b][a] = 1;
    }


    public static void hc(int[][] arc){
        int[] path = new int[arc.length];
        int[] flag = new int[arc.length];

        flag[0] = 1;
        int k =1;

        while (k>=1) {
            path[k]++;
            while(path[k] < arc.length){
                if (flag[path[k]]==0&&arc[path[k]][path[k-1]]==1) {
                    break;
                }else{
                    path[k]++;
                }
            }

            if (path[k]<arc.length && k == arc.length - 1 && arc[path[k]][0] == 1) {
                System.out.print("ans:");
                for (int i = 0; i < path.length; i++) {
                    System.out.print(" "+path[i]);
                }
                System.out.println();
                return;
            }

            if (k<arc.length-1 && path[k]<arc.length) {
                flag[path[k]] = 1;
                k++;
            }else{
                flag[path[k-1]] = 0;
                path[k] = 0;
                k--;
            }
        }
    }
}
