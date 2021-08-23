package Algorithm;

public class StringMacthing {
    public static void main(String[] args) {
        String a = "ababcabccabcacbab";
        String b = "abcac";

        System.out.println(BF(a, b));
    }

    public static int BF(String a, String b) {
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                i = ++index;
                j = 0;
            }
        }

        if (j == b.length()) {
            return j;
        } else {
            return -1;
        }
    }
}
