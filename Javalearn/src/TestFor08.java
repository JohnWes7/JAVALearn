public class TestFor08 {
    public static void main(String[] args) {
        
        char c = 'a';
        for (int i = 0; i < 26; i++) {
            System.out.print((char)(c + i) + " ");
        }

        System.out.println();
        System.out.println();

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (i * j) + " ");
            }
            System.out.println();
        }
    }
}