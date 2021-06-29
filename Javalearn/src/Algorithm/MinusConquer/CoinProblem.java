package Algorithm.MinusConquer;

public class CoinProblem {
    public static void main(String[] args) {
        int[] arr = {2,2,2,1,2,2,2,2,2,2,2,2,2,2};
        System.out.println(FindCoin(arr, 0, arr.length - 1));
    }

    public static int FindCoin(int[] arr){
        return FindCoin(arr, 0, arr.length - 1);
    }

    public static int FindCoin(int[] arr, int left, int right) {

        if (left == right) {
            return left;
        }

        int lenght = right - left + 1;
        int n1, n2;

        // 分成3组
        if (lenght % 3 == 0) {
            n1 = n2 = lenght / 3;
        } else {
            n1 = n2 = lenght / 3 + 1;
        }

        // 计算一组质量
        int weight1 = 0;
        for (int i = left; i < left + n1; i++) {
            weight1 += arr[i];
        }

        // 计算二组质量
        int weight2 = 0;
        for (int i = left + n1; i < left + n1 + n2; i++) {
            weight2 += arr[i];
        }

        // 比较递归
        if (weight1 == weight2) {
            return FindCoin(arr, left + n1 + n2, right);
        } else if (weight1 < weight2) {
            return FindCoin(arr, left, left + n1 - 1);
        } else {
            return FindCoin(arr, left + n1, left + n1 + n2 - 1);
        }
    }
}