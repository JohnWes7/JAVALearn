package Lesson.Base;

import java.util.Scanner;

/**
 * 测试switch
 */
public class TestSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入月份");
        int month = scanner.nextInt();

        switch (month) {

            case 1:
            case 2:
            case 3:
                System.out.println("春季");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("夏季");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("秋季");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("冬季");
                break;
            default:
                break;
        }

        scanner.close();
    }
    
}