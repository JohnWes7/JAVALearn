package Lesson._35MultidimensionalArrays;

import java.util.Arrays;

public class AfterWork {
    public static void main(String[] args) {
        Item[] items = new Item[5];
        items[0] = new Item(1, "百战鼠标", "BZ_001", 99.21, 0.9);
        items[1] = new Item(2, "玩偶", "WO_102", 403.00, 0.7);
        items[2] = new Item(3, "Java程序设计", "BK_001", 89.00, 0.8);
        items[3] = new Item(4, "西装", "GQ_XF_12", 700.00, 0.5);
        items[4] = new Item(5, "手机", "DM_PH_13", 900.00, 0.3);

        System.out.println(Arrays.toString(items) + "\n");

        Item.searchOverPrice(200, items);
    }
}

class Item {
    private int id;
    private String name;
    private String type;
    private double price;
    private double offscale;

    public Item(int id, String name, String type, double price, double offscale) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.offscale = offscale;
    }

    @Override
    public String toString() {
        return "item" + id + ": " + name + " " + type + " " + price + " " + offscale + "\n";
    }

    public static void searchOverPrice(double price, Item[] items) {
        int count = 0;
        int[] flag = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            if (items[i].price * items[i].offscale > price) {
                flag[i] = 1;
                count += 1;
            }
        }

        if (count == 0) {
            System.out.println("没有商品大于" + price);
        } else {
            System.out.println("大于" + price + "的商品有：");
        }

        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == 1) {
                System.out.println(items[i].name + " price:" + items[i].price * items[i].offscale);
            }
        }
    }

}
