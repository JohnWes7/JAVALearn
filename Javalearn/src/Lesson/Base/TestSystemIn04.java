package Lesson.Base;

import java.util.Scanner;

public class TestSystemIn04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("请输入用户Index");
        int index = scanner.nextInt();

        System.out.println("请输入用户名");
        String str = scanner.nextLine();
        str = scanner.nextLine();
        
        System.out.println("请输入月薪");
        double salary = scanner.nextDouble();

        System.out.println("=========录入信息如下=========");
        System.out.println("Index:" + index);
        System.out.println("username:" + str);
        System.out.println("yearSalary:" + (salary * 12));

        long pump = 80L * 60L * 24 * 365 * 80; 
        System.out.println("total pump:" + pump);

        scanner.close();
    }
}