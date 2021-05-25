package Algorithm;

public class KnapasackProblem {
    static int maxValue;
    static int[] a;
    static int currentWeight;

    public static void main(String[] args) {
        int[] weight = { 7, 3, 4, 5 };
        int[] value = { 42, 12, 40, 25 };

        Knapasack(weight, value);

        PrintAnswer();
    }

    public static void Knapasack(int[] weight, int[] value) {
        int[] flag = new int[4];
        allSubset(weight, value, flag, 0);
    }

    public static void allSubset(int[] weight, int[] value, int[] flag, int index) {
        if (index == weight.length) {
            int sumVal = 0;
            int sumWeight = 0;

            System.out.print("子集：");

            for (int i = 0; i < weight.length; i++) {
                if (flag[i] == 1) {
                    sumVal += value[i];
                    sumWeight += weight[i];
                    System.out.print((i + 1) + " ");
                }
            }

            System.out.print("\tweight: " + sumWeight + " value: " + sumVal + "\n");

            if (sumWeight <= 10 && sumVal > maxValue) {
                maxValue = sumVal;
                currentWeight = sumWeight;
                a = flag.clone();
            }

        } else {
            flag[index] = 0;
            allSubset(weight, value, flag, index + 1);
            flag[index] = 1;
            allSubset(weight, value, flag, index + 1);
        }
    }

    public static void PrintAnswer() {
        System.out.print("\n最优解：");
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println("weight: " + currentWeight + " value: " + maxValue);
    }
}