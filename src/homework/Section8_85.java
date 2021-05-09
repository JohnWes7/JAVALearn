package homework;

import java.util.Scanner;

public class Section8_85 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[][] a = new double[3][3];
        double[][] b = new double[3][3];

        System.out.println("Enter matrix1: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Enter matrix2: ");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                b[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("The matrix are added as follows");

        double[][] result = addMatrix(a, b);

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }

            if (i == a.length / 2) {
                System.out.print(" +  ");
            } else {
                System.out.print("    ");
            }

            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }

            if (i == a.length / 2) {
                System.out.print(" =  ");
            } else {
                System.out.print("    ");
            }

            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static double[][] addMatrix(double[][] a, double[][] b) {

        double[][] result = new double[a.length][a.length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result;
    }
}