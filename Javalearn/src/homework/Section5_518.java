package homework;

public class Section5_518 {

    public static void main(String[] args) {
        image1();
        System.out.println();
        image2();
        System.out.println();
        image3();
        System.out.println();
        image4();
    }

    public static void image1() {
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void image2() {
        for (int i = 6; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void image3() {
        for (int i = 1; i <= 6; i++) {
            for (int j = 6; j >= 1; j--) {

                if (j > i) {
                    System.out.print("  ");
                } else {
                    System.out.print(j + " ");
                }

            }
            System.out.println();
        }
    }

    public static void image4(){
        for (int i = 6; i >= 1; i--) {
            int num = 1;
            for (int j = 6; j >= 1; j--) {

                if ( j > i) {
                    System.out.print("  ");
                } else {
                    System.out.print(num++ + " ");
                }

            }
            System.out.println();
        }
    }
}