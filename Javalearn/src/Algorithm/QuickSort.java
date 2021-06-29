package Algorithm;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 0, 16, 4895, 65, 3548, 356, 17, 6, 1598, 64, 51, 22, 894, 1, 999, 87, 666, 87, 996, 1000 };
        mArr.PrintArray(arr);
        QSort(arr, 0, arr.length - 1);
        mArr.PrintArray(arr);
    }

    public static void QSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int middle = Partition(arr, left, right);
        QSort(arr, left, middle - 1);
        QSort(arr, middle + 1, right);
    }

    public static int Partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;

        while (i < j) {

            while (i < j) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    break;
                }
                j--;
            }

            while (i < j) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j--; 
                    break;
                }
                i++;
            }
        }

        return i;
    }
}