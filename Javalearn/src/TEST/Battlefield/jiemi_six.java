package TEST.Battlefield;

import java.util.Scanner;

public class jiemi_six {
    public static void main(String[] args) {
        String ab = E2A_T2B();
        System.out.println("AB长度：" + ab.length());
        System.out.println("目标长度：95");
        System.out.println(ab);
    }

    public static String E2A_T2B() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("输入ET字符串");
        String et = scanner.nextLine();
        System.out.println("源长度：" + et.length());
        scanner.close();

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < et.length(); i++) {
            if (et.charAt(i) == 'E') {
                ans.append('A');
            } else if (et.charAt(i) == 'T') {
                ans.append('B');
            } else if (et.charAt(i) == 'N') {
                ans.append("BA");
            } else if (et.charAt(i) == 'I') {
                ans.append("AA");
            }
        }

        String strans = ans.toString();

        if (strans.length() == et.length()) {
            System.out.println("长度验算一致");
        } else {
            System.out.println("长度验算出错");
        }

        return strans;
    }
}
