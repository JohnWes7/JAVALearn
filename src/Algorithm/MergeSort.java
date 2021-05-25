package Algorithm;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 51, 68, 151, 15, 354, 74, 65, 1, 68, 99, 36, 888, 16, 1, 10 };
        MSort(arr, 0, arr.length - 1);
        mArr.PrintArray(arr);
    }

    public static void Merge(int[] r, int r1[], int s, int m, int t) {
        int i = s;
        int j = m + 1;
        int k = s;
        while (i <= m && j <= t) {
            if (r[i] < r[j]) {
                r1[k] = r[i];
                i++;
                k++;
            } else {
                r1[k] = r[j];
                j++;
                k++;
            }
        }

        while (i <= m) {
            r1[k] = r[i];
            k++;
            i++;
        }

        while (j <= t) {
            r1[k] = r[j];
            k++;
            j++;
        }

    }

    public static void MSort(int[] r, int s, int t) {
        if (s == t) {
            return;
        }

        int m = (s + t) / 2;
        int[] r1 = new int[1000];

        MSort(r, s, m);
        MSort(r, m + 1, t);
        Merge(r, r1, s, m, t);

        for (int i = s; i <= t; i++) {
            r[i] = r1[i];
        }
    }
}