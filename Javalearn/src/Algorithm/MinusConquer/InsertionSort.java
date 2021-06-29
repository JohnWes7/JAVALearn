package Algorithm.MinusConquer;

import Algorithm.mArr;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12,15,9,20,10,6};
        mArr.PrintArray(arr);
        Sort(arr);
        mArr.PrintArray(arr);
    }

    public static void Sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                arr[j+1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }
}
