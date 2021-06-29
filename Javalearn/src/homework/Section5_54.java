package homework;

public class Section5_54 {
    public static void main(String[] args) {

        double scale = 1.609;

        System.out.println("英里\t千米");

        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "\t" + i * scale);
        }
    }
}