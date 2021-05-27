package Algorithm.Homework;

import Algorithm.mArr;

public class Section5_3 {
    public static void main(String[] args) {
        int[] arr = { 6, 9, 10, 12, 15, 20 };
        int[] result = BinSerchRange(arr, 6, 6);
        if (result != null) {
            mArr.PrintArray(result);
        }
    }

    public static int[] BinSerchRange(int[] arr, int min, int max) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // 找到其中一个值
            if (arr[mid] <= max && arr[mid] >= min) {

                int ansleft;
                for (ansleft = mid - 1; ansleft >= left && arr[ansleft] <= max && arr[ansleft] >= min; ansleft--) {

                }
                ansleft++;

                int ansright = mid + 1;
                while (ansright <= right && arr[ansright] >= min && arr[ansright] <= max) {
                    ansright++;
                }
                ansright--;

                int[] ans = new int[ansright - ansleft + 1];
                int index = 0;
                for (int i = ansleft; i <= ansright; i++) {
                    ans[index] = arr[i];
                    index++;
                }

                return ans;
            }else if (arr[mid] < min) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return null;
    }
}