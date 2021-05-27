package Algorithm.MinusConquer;

public class MedianProblem {
    public static void main(String[] args) {
        int[] a = { 11, 13, 15, 17, 19 };
        int[] b = { 2, 4, 10, 15, 20 };
        System.out.println(SearchMidian(a, b));
    }

    public static int SearchMidian(int[] a, int[] b) {
        int aleft = 0;
        int aright = a.length - 1;
        int bleft = 0;
        int bright = b.length - 1;

        while (aleft < aright && bleft < bright) {
            int aMidindex = (aleft + aright) / 2;
            int bMidindex = (bleft + bright) / 2;
            int aMid = a[aMidindex];
            int bMid = b[bMidindex];
            System.out.println(aMid + " " + bMid);
            System.out.println("a: " + aleft + " " + aright +" b: " + bleft+" "+bright);
            if (aMid == bMid) {
                return aMid;
            }
            if (aMid > bMid) {
                aright = aMidindex;
                if ((bleft + bright) % 2 == 0) {
                    bleft = bMidindex;
                } else {
                    bleft = bMidindex + 1;
                }
            }
            if (aMid < bMid) {
                bright = bMidindex;
                if ((aleft + aright) % 2 == 0) {
                    aleft = aMidindex;
                } else {
                    aleft = aMidindex + 1;
                }
            }
        }

        return Math.min(a[aleft], b[bleft]);
    }
}