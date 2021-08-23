package Lesson._37BinarySearch;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 30, 20, 50, 10, 80, 9, 7, 12, 100, 40, 8 };
        int target = 210;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(target + ": " + Search(target, arr));
    }

    public static int Search(int num, int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

}
