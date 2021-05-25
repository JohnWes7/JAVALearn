package Algorithm.Homework;

import java.util.Scanner;

public class Section4_9 {

    public static void main(String[] args) {

        int[] arr = { 1, 5, 9, 10, 60, 89, 410, 680, 999 };
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要在数组中寻找的数字");
        int target = scanner.nextInt();

        System.out.println("\n" + SearchForIndex(arr, target));

        scanner.close();
    }

    public static int SearchForIndex(int[] arr, int target) {
        return Search(arr, target, 0, arr.length - 1);
    }

    public static int Search(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        int ans = -1;
        System.out.println(arr[middle]);
        if (arr[middle] == target) {
            ans = middle;
        } else if (arr[middle] > target) {
            ans = Search(arr, target, left, middle - 1);
        } else if (arr[middle] < target) {
            ans = Search(arr, target, middle + 1, right);
        }

        return ans;
    }
}