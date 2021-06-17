package homework;

public class Section5_524 {
    public static void main(String[] args) {

        double Numerator = 1;
        double Denominator = 3;
        int step = 2;

        double sum = 0;
        for (int i = 0; i < 49; i++) {
            //System.out.println("Numerator: " + Numerator);
            sum += Numerator / Denominator;
            //System.out.println("sum: " + sum);

            Numerator +=step;
            Denominator += step;
        }

        System.out.println("sum: " + sum);
    }
}