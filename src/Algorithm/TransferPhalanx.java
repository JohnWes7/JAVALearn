package Algorithm;

public class TransferPhalanx {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        Full(arr, 0, arr.length, 1);
        PrintArr(arr);
    }

    public static void Full(int[][] arr, int begin, int size, int number) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            arr[begin][begin] = number;
            return;
        }

        int i = begin;
        int j = begin;

        for (int k = 0 ; k < size - 1; k++) {
            arr[i][j] = number;
            number++;
            i++;
        }

        for (int k = 0 ; k < size - 1; k++) {
            arr[i][j] = number;
            number++;
            j++;
        }

        for (int j2 = 0; j2 < size -1; j2++) {
            arr[i][j] = number;
            number++;
            i--;
        }

        for (int j2 = 0; j2 < size -1; j2++) {
            arr[i][j] = number;
            number++;
            j--;
        }

        Full(arr, begin + 1, size - 2, number);
    }

    public static void PrintArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}