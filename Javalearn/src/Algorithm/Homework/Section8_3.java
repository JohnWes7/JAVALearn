package Algorithm.Homework;

public class Section8_3 {
    public static void main(String[] args) {
        int[] a = { 2, 3, 2 };
        int[] b = { 1, 1, 3 };

        System.out.println("lest time: " + machineProcess(a, b));
    }

    public static int machineProcess(int[] a, int[] b) {
        int[] x = new int[a.length + 1];
        int[] suma = new int[a.length + 1];
        int[] sumb = new int[a.length + 1];
        int lest = -1;
        int k = 1;
        while (k >= 1) {
            x[k] += 1;

            while (x[k] <= a.length) {
                // 查重复
                boolean flag = true;
                for (int i = 1; i < k; i++) {
                    if (x[i] == x[k]) {
                        flag = false;
                        break;
                    }
                }

                // 如果没有重复
                if (flag) {
                    suma[k] = suma[k - 1] + a[x[k] - 1];
                    sumb[k] = Math.max(suma[k], sumb[k - 1]) + b[x[k] - 1];

                    // 如果大于已有的最小值 跳过这个 继续遍历
                    if (sumb[k] > lest && lest != -1) {
                        x[k] += 1;
                    } else {
                        break;
                    }
                }
                // 如果重复了
                else {
                    x[k] += 1;
                }
            }

            if (x[k] <= a.length) {
                if (k == a.length) {
                    if (lest == -1 || sumb[k] < lest) {
                        System.out.print("当前最优解:");
                        for (int i = 1; i < x.length; i++) {
                            System.out.print(" " + x[i]);
                        }
                        System.out.println("  time: " + sumb[k]);

                        lest = sumb[k];
                    }
                    x[k] = 0;
                    k--;
                }
                else{
                    k++;
                }
            }
            // 超出了说明该分支完了 回溯
            else {
                x[k] = 0;
                k--;
            }
        }

        return lest;
    }
}
