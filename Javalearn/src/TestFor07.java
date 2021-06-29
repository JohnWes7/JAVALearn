public class TestFor07 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if ((i+j)%2 == 0) {
                    System.out.print("* ");
                }
                else{
                    System.out.print("# ");
                }
            }
            System.out.println();
        }

        System.out.println();

        while (true) {
            int r = (int)(Math.random() * 100);
            System.out.println(r);
            if (r == 88) {
                break;
            }
        }

        System.out.println();

        int count = 0;
        for (int i = 100; i <= 150; i++) {

            if (i % 3 == 0) {
                continue;
            }

            System.out.print(i + "  ");
            count++;

            if (count == 5) {
                System.out.println();
                count = 0;
            }
        }
    }
}