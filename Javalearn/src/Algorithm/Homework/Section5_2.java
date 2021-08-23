package Algorithm.Homework;

public class Section5_2 {
    public static void main(String[] args) {
        int[] arr = { 6, 9, 10, 12, 15, 20 };
        System.out.println(BinSerch(arr, 15));
    }

    public static int BinSerch(int[] arr, int target) {
        return BinSerch(arr, 0, arr.length - 1, target);
    }

    public static int BinSerch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (target > arr[mid]) {
            return BinSerch(arr, mid + 1, right, target);
        } else {
            return BinSerch(arr, left, mid - 1, target);
        }
    }
}