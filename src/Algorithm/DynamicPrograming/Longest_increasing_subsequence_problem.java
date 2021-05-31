package Algorithm.DynamicPrograming;

public class Longest_increasing_subsequence_problem {
    public static void main(String[] args) {
        int[] arr1 = { 8, 9, 6, 3, 1, 2, 4, 5, 6, 10 };
        LISP(arr1);
    }

    public static void LISP(int[] arr) {
        int[] l = new int[arr.length];
        int[][] collection = new int[arr.length][arr.length];

        for (int i = 0; i < collection.length; i++) {
            l[i] = 1;
            collection[i][0] = arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int max = 1;// arr[i]可以以该点为结尾的最大长度

            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && l[j] + 1 > max) {
                    max = l[j] + 1;
                    l[i] = max;

                    // 填写集合
                    for (int j2 = 0; j2 < max - 1; j2++) {
                        collection[i][j2] = collection[j][j2];
                    }
                    collection[i][max - 1] = arr[i];
                }
            }
        }

        int index = 0;
        for (int i = 0; i < l.length; i++) {
            if (l[i] > l[index]) {
                index = i;
            }
        }
        
        System.out.println("longest lenght: " + l[index]);
        System.out.print("collection: ");
        for (int i = 0; i < l[index]; i++) {
            System.out.print(collection[index][i] + " "); 
        }
        System.out.println();
    }
}