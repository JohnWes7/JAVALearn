package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ClosestProblem {
    public static void main(String[] args) {
        Point[] s = new Point[6];
        s[0] = new Point(0, 0);
        s[1] = new Point(1, 1);
        s[2] = new Point(1, 2);
        s[3] = new Point(3, 3);
        s[4] = new Point(9, 1);
        s[5] = new Point(11, 2);

        System.out.println(Closest(s, 0, 4));
    }

    public static double Closest(Point[] s, int low, int high) {
        if (high - low == 1) {
            return Distance(s[low], s[high]);
        }
        if (high - low == 2) {
            double d1 = Distance(s[low], s[low + 1]);
            double d2 = Distance(s[low + 1], s[high]);
            double d3 = Distance(s[low], s[high]);

            double min = Math.min(d1, d2);
            min = Math.min(min, d3);
            return min;
        }

        // 计算中间点
        int mid = (low + high) / 2;
        // 递归求解子问题1
        double d1 = Closest(s, low, mid);
        // 递归求解子问题2
        double d2 = Closest(s, mid + 1, high);

        // 子问题3
        ArrayList<Point> list = new ArrayList<Point>();
        double min = Math.min(d1, d2);
        //剔除掉x大于mind的点
        for (int i = mid; (i >= low) && (s[mid].x - s[i].x < min); i--) {
            list.add(s[i]);
        }
        for (int i = mid + 1; i <= high && (s[i].x - s[mid].x < min); i++) {
            list.add(s[i]);
        }
        //按照y值排序
        Collections.sort(list,new Comparator<Point>(){
           @Override
           public int compare(Point o1, Point o2) {
               if (o1.y < o2.y) {
                   return -1;
               }else{
                   return 1;
               }
           } 
        });
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i).y - list.get(j).y >= min) {
                    break;
                }

                double d3 = Distance(list.get(i), list.get(j));
                min = Math.min(min, d3);
            }
        }


        return min;
    }

    public static double Distance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}

class Point {
    public double x;
    public double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
}
