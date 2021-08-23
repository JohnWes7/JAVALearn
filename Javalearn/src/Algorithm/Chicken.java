package Algorithm;

public class Chicken {
    public static void main(String[] args) {
        ChickenQuestion();
    }

    public static void ChickenQuestion() {
        int cock = 0;
        int hen = 0;
        int count = 0;

        for (cock = 0; cock <= 20; cock++) {
            for (hen = 0; hen <= 33; hen++) {
                int chick = 100 - cock - hen;
                if ((chick % 3) == 0 && (cock * 5 + hen * 3 + chick / 3) == 100) {
                    count++;
                    System.out.println("cock:" + cock + "  hen:" + hen + "  chick:" + chick);
                }
            }
        }

        if (count == 0) {
            System.out.println("none answer");
        }
        else{
            System.out.println(count + " answers in total");
        }
    }
}