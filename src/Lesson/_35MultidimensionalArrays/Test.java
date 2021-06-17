package Lesson._35MultidimensionalArrays;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[][] a = new int[3][];
        a[0] = new int[]{20,5};
        a[1] = new int[]{10,65,8,4};
        a[2] = new int[]{56,1,89};

        for (int[] is : a) {
            System.out.println(Arrays.toString(is));
        }
    }
}
