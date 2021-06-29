package homework;

public class Section5_57 {
    public static void main(String[] args) {
        int origin = 10000;
        double IncreasePercentage = 1.05;

        int fee10 = (int)(origin * Math.pow(IncreasePercentage, 10));
        System.out.println("十年后学费: " + fee10);
        
        int sumFee = 0;
        for (int i = 1; i <= 4; i++) {
            sumFee += (int)(fee10 * Math.pow(IncreasePercentage, i));
        }
        System.out.println("十年后4年总学费：" + sumFee);
    }
}