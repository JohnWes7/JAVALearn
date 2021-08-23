package Algorithm.MinusConquer;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 7, 14, 18, 21, 23, 29, 31, 35, 38 };
        System.out.println(Search(arr, 38));
    }

    public static int Search(int[] arr, int target) {
        int right = arr.length - 1;
        int left = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}