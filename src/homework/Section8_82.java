package homework;

import java.util.Scanner;

public class Section8_82 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[][] arr = new double[4][4];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextDouble();
            }
        }

        // #region
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[i].length; j++) {
        // System.out.print(arr[i][j]+" ");
        // }
        // System.out.println();
        // }
        // #endregion

        System.out.println("Sum of the elements in the major diagonal is " + sumMajorDiagona(arr));

        scanner.close();
    }

    public static double sumMajorDiagona(double[][] m) {

        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][i];
        }

        return sum;
    }
}