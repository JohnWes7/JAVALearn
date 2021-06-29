package Algorithm;

public class Sum_of_Largest_SubSegment_Problem {
    public static void main(String[] args) {
        int[] arr = { -20, 11, -4, 13, -5, -2 };
        int max = DivideConquer(arr, 0, arr.length - 1);
        System.out.println(max);
    }

    public static int DivideConquer(int[] arr, int right, int left) {
        if (right == left) {
            return arr[right];
        }

        int middle = (left + right) / 2;

        int rightSum = DivideConquer(arr, right, middle);
        int leftSum = DivideConquer(arr, middle + 1, left);

        int s1 = arr[middle];
        int dySum = 0;
        for (int i = middle; i >= right; i--) {
            dySum += arr[i];
            if (dySum > s1) {
                s1 = dySum;
            }
        }

        int s2 = arr[middle + 1];
        dySum = 0;
        for (int i = middle + 1; i <= left; i++) {
            dySum += arr[i];
            if (dySum > s2) {
                s2 = dySum;
            }
        }

        int middleSum = s1 + s2;

        int max = Math.max(Math.max(rightSum, leftSum), middleSum);

        return max;
    }
}
