package Lesson._36排序算法;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 6, 2, 9, 0, 7, 4, 8, 5 };
        System.out.println(Arrays.toString(arr));

        Sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void Sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"趟: "+Arrays.toString(arr));

            if (flag) {
                break;
            }
        }
    }
}
