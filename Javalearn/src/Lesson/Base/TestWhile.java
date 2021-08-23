package Lesson.Base;

public class TestWhile {

    public static void main(String[] args) {

        // int i = 1;

        // while (i <= 100) {
        // System.out.println(i);
        // i++;
        // }

        int sum = 0;
        int i = 1;

        // while (i <= 100) {
        // sum += i;
        // i++;
        // }

        for (; i <= 100; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}