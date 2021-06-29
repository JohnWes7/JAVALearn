package Lesson._35MultidimensionalArrays;

import java.util.Arrays;

public class ObjectArray {
    public static void main(String[] args) {
        Object[] a0 = { 1001, "wada", 18, "programmer", "2021-4-15" };
        Object[] a1 = { 1002, "wdaa", 19, "teacher", "2021-4-10" };
        Object[] a2 = { 1003, "dwa", 20, "hr", "2021-3-10" };

        Object[][] emps = new Object[3][];
        emps[0] = a0;
        emps[1] = a1;
        emps[2] = a2;

        for (Object[] objects : emps) {
            System.out.println(Arrays.toString(objects));
        }
    }
}
