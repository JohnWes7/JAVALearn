package Algorithm.Homework;

import java.util.Arrays;
import java.util.Comparator;

public class Section4_1 {
    public static void main(String[] args) {
        Item[] items = new Item[7];
        int[] weight = { 2, 3, 5, 7, 1, 4, 1 };
        int[] value = { 10, 5, 15, 7, 6, 18, 3 };

        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(weight[i], value[i], i);
        }

        System.out.println("max value: " + Package(items, 15));
    }

    public static double Package(Item[] items, int contain) {
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if ((double) o1.value / o1.weight < (double) o2.value / o2.weight) {
                    return 1;
                }
                return -1;
            }
        });

        int c = contain;
        double sum = 0;

        System.out.print("collects:");
        for (int i = 0; i < items.length; i++) {
            if (items[i].weight < c) {
                sum += items[i].value;
                c -= items[i].weight;
                System.out.print(" " + items[i].weight + ":" + items[i].value);
            } else {
                double temp = (double) c / items[i].weight * items[i].value;
                sum += temp;
                c -= items[i].weight;
                System.out.print(" " + items[i].weight + ":" + temp);
                break;
            }
        }
        System.out.println();

        return sum;
    }
}

class Item {
    int weight;
    int value;
    int index;

    public Item(int weight, int value, int index) {
        this.weight = weight;
        this.value = value;
        this.index = index;
    }
}
