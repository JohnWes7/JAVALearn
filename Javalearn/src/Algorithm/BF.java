package Algorithm;

import java.util.ArrayList;

public class BF {
    public static void main(String[] args) {
        String a = "ababaababcb";
        String b = "ababc";

        System.out.println(KMP(a, b));
    }

    public static int KMP(String a, String b) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        //组建next
        list.add(-1);
        for (int i = 1; i < b.length(); i++) {
            int k = 0;
            for (k = i - 1; k >= 1; k--) {

                int j;
                for (j = 0; j < k; j++) {
                    if (b.charAt(j) != b.charAt(i - k + j)) {
                        break;
                    }
                }

                if (j == k) {
                    list.add(k);
                    break;
                }
            }

            if (k < 1) {
                list.add(0);
            }
        }

        // for (int i = 0; i < list.size(); i++) {
        // System.out.print(list.get(i)+" ");
        // }
        
        //通过next数组来回溯下标j
        //如果是到了next[0] 说明从头匹配都不行 所以i++ j++ 从下一个开始匹配
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {

            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                j = list.get(j);
                if (j == -1) {
                    j++;
                    i++;
                }
            }

        }

        if (j == b.length()) {
            return i - b.length() + 1;
        } else {
            return -1;
        }
    }
}
