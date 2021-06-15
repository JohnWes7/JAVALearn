package Algorithm.GreedyMethod;

import java.util.ArrayList;

public class Multi_machine_scheduling {
    public static void main(String[] args) {
        int[] time = { 16, 14, 6, 5, 4, 3, 2 };
        int[] index = { 4, 2, 5, 6, 3, 7, 1 };

        MMS(time, index, 3);
    }

    public static void MMS(int[] time, int[] index, int machineNum) {
        int[] endTime = new int[machineNum];
        ArrayList<ArrayList<Integer>> schedul = new ArrayList<ArrayList<Integer>>();

        // 初始化 每一个填入一个最大的作为初始值
        for (int i = 0; i < machineNum; i++) {
            schedul.add(new ArrayList<Integer>());
            schedul.get(i).add(i); // 每个机器计入第一个任务
            endTime[i] = time[i]; // 计入完成时间
        }

        for (int i = machineNum; i < index.length; i++) {
            // 找到最先完成的机器
            int machine = 0;
            for (int j = 1; j < machineNum; j++) {
                if (endTime[j] < endTime[machine]) {
                    machine = j;
                }
            }

            // 加入任务
            endTime[machine] += time[i];
            schedul.get(machine).add(i);
        }

        for (int i = 0; i < machineNum; i++) {
            System.out.print("machine " + i + " :");
            for (int j = 0; j < schedul.get(i).size(); j++) {
                System.out.print(" " + index[schedul.get(i).get(j)] + ":" + time[schedul.get(i).get(j)]);
            }
            System.out.println();
        }
    }
}
