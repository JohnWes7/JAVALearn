package Lesson._34Array;

import java.util.Arrays;

public class TestArrays {
    public static void main(String[] args) {
        int[] arr = { 26, 6, 84, 2, 565, 12 };

        // 可以直接打印数组
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));

        // 排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 查找
        System.out.println(Arrays.binarySearch(arr, 84));
        System.out.println(Arrays.binarySearch(arr, 666)); // 不存在返回负数

        // 填充
        int[] d = new int[10];
        Arrays.fill(d, 33);
        System.out.println(Arrays.toString(d));

        int[] b = { 200, 100, 90, 65, 156 };
        for (int i : b) {
            if (i > 100) {
                System.out.print(i + " ");
            }
        }
    }
}
