package homework;

import java.util.Arrays;
import java.util.Scanner;

public class Section8_827 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] m = new double[3][3];

        System.out.println("Enter a 3-by-3 matrix row by row");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = scanner.nextDouble();
            }
        }

        double[][] result = sortColumns(m);

        System.out.println("\nThe column-sorted array is");

        PrintArray(result);

        scanner.close();
    }

    public static double[][] sortColumns(double[][] m) {

        double[][] result = new double[m[0].length][m.length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                result[j][i] = m[i][j];
            }
        }

        // PrintArray(result);

        for (int i = 0; i < result.length; i++) {
            Arrays.sort(result[i]);
        }

        double[][] rresult = new double[m.length][m[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                rresult[j][i] = result[i][j];
            }
        }

        return rresult;
    }

    public static void PrintArray(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}