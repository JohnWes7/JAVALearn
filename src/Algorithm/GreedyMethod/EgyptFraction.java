package Algorithm.GreedyMethod;

public class EgyptFraction {
    public static void main(String[] args) {
        int a = 5;
        int b = 8;

        EPF(a, b);
    }

    public static void EPF(int a, int b) {
        System.out.print(a + "/" + b + " =");

        while (a > 1) {
            int e = b / a + 1;

            // ae/be - b/be = (ae - b)/be
            a = a * e - b;
            b = b * e;

            // 打印
            System.out.print(" " + "1/" + e + " +");

            // 约分
            int f = MaxCommFactor(a, b);
            if (f > 1) {
                a /= f;
                b /= f;
            }
        }

        // 打印
        System.out.print(" " + "1/" + b);

        System.out.println();
    }

    public static int MaxCommFactor(int a, int b) {
        return (a % b == 0) ? b : MaxCommFactor(b, a % b);
    }
}
