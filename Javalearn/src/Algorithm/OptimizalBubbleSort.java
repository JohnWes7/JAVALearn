package Algorithm;

public class OptimizalBubbleSort {
    public static void main(String[] args) {
        int[] arr = { 6, 9, 5, 1, 3, 7, 20, 15 };

        PrintArr(arr);
        BubbleSort(arr);
        PrintArr(arr);
    }

    public static int[] BubbleSort(int[] arr) {
        int boune = 0;
        int exchange = arr.length - 1;

        while (exchange != 0) {
            boune = exchange;
            exchange = 0;

            for (int i = 0; i < boune; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                    exchange = i;
                }
            }
        }

        return arr;
    }

    public static void PrintArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }
}