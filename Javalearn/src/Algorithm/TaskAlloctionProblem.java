package Algorithm;

public class TaskAlloctionProblem {
    static int minCost = -1;
    static int[] arrange;

    public static void main(String[] args) {
        int[][] costTable = { { 9, 2, 7 }, { 6, 4, 3 }, { 5, 8, 1 } };

        PrintAnswer();
        TaskAlloction(costTable);
        PrintAnswer();
    }

    public static void TaskAlloction(int[][] costTable) {
        int[] arr = new int[costTable[0].length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int[] flag = new int[arr.length];
        int[] ans = new int[arr.length];

        AllArrangement(arr, flag, 0, ans, costTable);
    }

    public static void AllArrangement(int[] arr, int[] flag, int index, int[] ans, int[][] costTable) {
        if (index == arr.length) {
            int cost = 0;
            System.out.print("arrange: ");

            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] + " ");
                cost += costTable[ans[i] - 1][i];
            }

            System.out.println("\tcost: " + cost);

            if (cost < minCost || minCost == -1) {
                minCost = cost;
                arrange = ans.clone();
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (flag[i] == 0) {
                    flag[i] = 1;
                    ans[index] = arr[i];
                    AllArrangement(arr, flag, index + 1, ans, costTable);
                    flag[i] = 0;
                }
            }
        }
    }

    public static void PrintAnswer(){
        if (arrange == null) {
            System.out.println("haven't calculate");
            return;
        }

        System.out.print("\n最佳arrange: ");

        for (int i = 0; i < arrange.length; i++) {
            System.out.print(arrange[i] + " ");
        }

        System.out.println("\tcost: " + minCost);
    }
}