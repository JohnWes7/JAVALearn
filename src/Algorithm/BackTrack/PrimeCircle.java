package Algorithm.BackTrack;

public class PrimeCircle {
    public static void main(String[] args) {
        PC(20, 4);
    }

    public static void PC(int n, int length) {
        int arr[] = new int[length];
        int index = 0; // 从第一个位置开始填起
        int count = 0; // 可行解总数

        while (index >= 0) {
            boolean flag = false;

            for (int i = 1; i <= n; i++) {
                arr[index] = i;
                if (Check(index, arr)) {
                    // 判断成功
                    flag = true;
                    break;
                }
            }

            if (index == length - 1 && flag) {
                System.out.print("ans" + count + ":");
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(" " + arr[i]);
                }

                return;
            }

            if (index < length - 1 && flag) {
                index++;
            } else {
                arr[index] = 0;
                index--;
            }
        }

    }

    public static boolean Check(int index, int[] arr) {
        boolean flag = true;

        for (int i = 0; i < index; i++) {
            if (arr[i] == arr[index]) {
                return false;
            }
        }

        if (index != 0) {
            flag = Prime(arr[index] + arr[index - 1]);
            if (index == arr.length - 1) {
                flag = flag && Prime(arr[index] + arr[0]);
            }
        }

        return flag;
    }

    public static boolean Prime(int num) {
        int n = (int) Math.sqrt(num);

        for (int i = 2; i < n; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
