package Algorithm.Homework;

public class Section4_5 {
    public static void main(String[] args) {
        int[] arr = { 156, 56, 78, 6, 1, 999, 156, 89, 65, 74, 95, 849, 4 };
        System.out.println(MaxofArray(arr));
    }

    public static int MaxofArray(int[] arr) {
        return DivideArrayMax(arr, 0, arr.length - 1);
    }

    public static int DivideArrayMax(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }

        int middle = (left + right) / 2;
        int leftMax = DivideArrayMax(arr, left, middle);
        int rightMax = DivideArrayMax(arr, middle + 1, right);

        return Math.max(leftMax, rightMax);
    }
}