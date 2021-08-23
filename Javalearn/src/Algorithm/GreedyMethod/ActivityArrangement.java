package Algorithm.GreedyMethod;

import java.util.Arrays;
import java.util.Comparator;

public class ActivityArrangement {
    public static void main(String[] args) {
        Activity[] activities = new Activity[11];

        activities[0] = new Activity(1, 4);
        activities[1] = new Activity(3, 5);
        activities[2] = new Activity(0, 6);
        activities[3] = new Activity(5, 7);
        activities[4] = new Activity(3, 8);
        activities[5] = new Activity(5, 9);
        activities[6] = new Activity(6, 10);
        activities[7] = new Activity(8, 11);
        activities[8] = new Activity(8, 12);
        activities[9] = new Activity(2, 13);
        activities[10] = new Activity(12, 14);

        AA(activities);
    }

    public static void AA(Activity[] activities) {
        Arrays.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                if (o1.endTime < o2.endTime) {
                    return -1;
                }

                return 1;
            }
        });

        int endTime = activities[0].endTime;
        System.out.print("activity: 0");
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].startTime >= endTime) {
                endTime = activities[i].endTime;
                System.out.print(" " + (i + 1));
            }
        }
    }

}

class Activity {
    int startTime;
    int endTime;

    public Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
