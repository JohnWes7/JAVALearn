package Algorithm.BackTrack;

public class BatchJob {
    public static void main(String[] args) {
        int[] a = { 2, 5, 4 };
        int[] b = { 3, 2, 1 };

        System.out.println("lest: " + BJ(a, b));
    }

    public static int BJ(int[] a, int[] b) {
        int[] x = new int[a.length + 1];
        int[] suma = new int[a.length + 1];
        int[] sumb = new int[a.length + 1];
        // for (int i = 0; i < x.length; i++) {
        // x[i] = -1;
        // }

        int lest = -1;
        int k = 1;
        while (k >= 1) {
            x[k] += 1;
            while (x[k] <= a.length) {
                boolean same = true; // 看是否重复
                for (int i = 1; i < k; i++) {
                    if (x[k] == x[i]) {
                        same = false;
                        break;
                    }
                }

                // 如果没有重复
                if (same) {
                    suma[k] = suma[k - 1] + a[x[k] - 1];
                    sumb[k] = Math.max(suma[k], sumb[k - 1]) + b[x[k] - 1];
                    if (lest != -1 && sumb[k] >= lest) {
                        x[k]++; // 如果已经超过了最小值 增加数字
                    } else {
                        break;
                    }
                }
                // 如果重复了
                else {
                    x[k]++; // 增加数字
                }
            }

            if (x[k] <= a.length && k == a.length) {
                // 得到一个解
                if (sumb[k] < lest || lest == -1) {
                    lest = sumb[k];
                    System.out.print("目前最短安排为:");
                    for (int i = 1; i < x.length; i++) {
                        System.out.print(" " + x[i]);
                    }
                    System.out.println();
                    System.out.println("time: " + lest);
                }
                x[k] = 0;
                k--;
            } else {
                // 如果还没有完 则继续下一位
                if (x[k] <= a.length) {
                    k++;
                }
                // 如果遍历完了 则回溯
                else {
                    x[k] = 0;
                    k--;
                }
            }

        }
        return lest;
    }
}