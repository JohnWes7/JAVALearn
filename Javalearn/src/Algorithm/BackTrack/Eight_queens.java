package Algorithm.BackTrack;

public class Eight_queens {
    public static void main(String[] args) {
        solution(4);

        solution1(4);
    }

    public static void solution(int n) {
        int k = 0;
        int[] table = new int[n];

        while (k >= 0) {
            table[k]++;
            while (table[k] <= n) {
                if (check(k, table)) {
                    break;
                } else {
                    table[k]++;
                }
            }

            if (k == n - 1 && table[k] <= n) {
                PrintChess(table);
                return;
            }

            if (k < n - 1 && table[k] <= n) {
                k++;
            } else {
                table[k] = 0;
                k--;
            }
        }
    }

    public static void solution1(int n){
        int[] table = new int[n];

        ReCallSolution(0, table);
    }

    public static void ReCallSolution(int index, int[] table) {
        if (index == table.length) {
            PrintChess(table);
            return;
        }

        for (int i = 1; i <= table.length; i++) {
            table[index] = i;
            if (check(index, table)) {
                ReCallSolution(index + 1, table);
            }
        }

        table[index] = 0;
    }

    public static boolean check(int index, int[] table) {
        for (int i = 0; i < index; i++) {
            if (table[i] == table[index] || index - i == Math.abs(table[i] - table[index])) {
                return false;
            }
        }

        return true;
    }

    public static void PrintChess(int[] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 1; j < table[i]; j++) {
                System.out.print("X");
            }
            System.out.print("Q");
            for (int j = table[i] + 1; j <= table.length; j++) {
                System.out.print("X");
            }
            System.out.println();
        }
        System.out.println();
    }

}
