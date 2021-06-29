package Lesson._48存储二维表格信息;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StoreTable {
    public static void main(String[] args) {
        ListMap();
        ListJavaBean();
    }

    public static void ListMap() {
        Map<String, Object> m1 = new HashMap<>();
        m1.put("id", 1001);
        m1.put("title", "emp");
        m1.put("creatDate", "2021.6.1");
        m1.put("time", 400);

        Map<String, Object> m2 = new HashMap<>();
        m2.put("id", 1002);
        m2.put("title", "ads");
        m2.put("creatDate", "2021.5.15");
        m2.put("time", 300);

        Map<String, Object> m3 = new HashMap<>();
        m3.put("id", 1003);
        m3.put("title", "edd");
        m3.put("creatDate", "2021.4.1");
        m3.put("time", 350);

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);

        System.out.println("id\ttitle\tcreateDate\ttime");
        for (Iterator<Map<String, Object>> iterator = list.iterator(); iterator.hasNext();) {
            Map<String, Object> temp = iterator.next();
            System.out.println(
                    temp.get("id") + "\t" + temp.get("title") + "\t" + temp.get("creatDate") + "\t" + temp.get("time"));
        }
        System.out.println();
    }

    public static void ListJavaBean(){
        Info info1 = new Info(1001, "emp", "2021.6.1", 400);
        Info info2 = new Info(1002, "ads", "2021.5.15", 300);
        Info info3 = new Info(1003, "edd", "2021.4.1", 3600);
        List<Info> list = new ArrayList<>();

        list.add(info1);
        list.add(info2);
        list.add(info3);

        System.out.println("id\ttitle\tcreateDate\ttime");
        for (Info info : list) {
            System.out.println(info.toString());
        }
        System.out.println();
    }
}

class Info {

    private int id;
    private String title;
    private String createDate;
    private int time;

    public Info(int id, String title, String creatDate, int time) {
        this.id = id;
        this.title = title;
        this.createDate = creatDate;
        this.time = time;
    }

    @Override
    public String toString() {
        return this.getId() + "\t" + this.getTitle() + "\t" + this.getCreateDate() + "\t" + this.getTime();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getTime() {
        StringBuilder stringBuilder = new StringBuilder();
        int h = time / 3600;
        int m = (time - h * 3600) / 60;
        int s = time - h * 3600 - m * 60;
        
        if (h>0) {
            stringBuilder.append(h+"h ");
        }
        if (m>0) {
            stringBuilder.append(m+"m ");
        }
        if (s>0) {
            stringBuilder.append(s+"s ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }
}