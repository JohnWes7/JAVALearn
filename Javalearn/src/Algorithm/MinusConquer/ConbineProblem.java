package Algorithm.MinusConquer;

public class ConbineProblem {
    public static void main(String[] args) {
        // 2的k次方个队伍
        System.out.println(DivideCompetition(8));
        System.out.println(MinuCompetition(8));
    }

    public static int DivideCompetition(int teamNum) {
        if (teamNum == 2) {
            return 1;
        } else {
            return 2 * DivideCompetition(teamNum / 2) + 1;
        }
    }

    public static int MinuCompetition(int teamNum) {
        int sum = 0;

        while (teamNum > 1) {
            teamNum /= 2;
            sum += teamNum;
        }

        return sum;
    }
}