package homework;

import java.util.Scanner;

public class Section8_828 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] a = new int[3][3];
        System.out.println("Enter list1: ");
        scanIntoArray(a, scanner);

        int[][] b = new int[3][3];
        System.out.println("Enter list2: ");
        scanIntoArray(b, scanner);

        boolean judge = equals(a, b);
        if (judge) {
            System.out.println("The two arrays are strictly identical");
        } else {
            System.out.println("The two arrays are not strictly identical");
        }

        scanner.close();
    }

    public static boolean equals(int[][] m1, int[][] m2) {
        boolean condition = true;

        for (int i = 0; i < m1.length; i++) {

            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    condition = false;
                    break;
                }
            }

            if (!condition) {
                break;
            }
        }

        return condition;
    }

    public static void scanIntoArray(int[][] m, Scanner scanner) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = scanner.nextInt();
            }
        }

    }
}
