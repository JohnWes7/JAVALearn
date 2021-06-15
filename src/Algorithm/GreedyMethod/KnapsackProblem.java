package Algorithm.GreedyMethod;

import java.util.Arrays;
import java.util.Comparator;

public class KnapsackProblem {
    public static void main(String[] args) {
        Item[] items = new Item[3];

        items[0] = new Item(20, 60);
        items[1] = new Item(30, 120);
        items[2] = new Item(10, 50);

        System.out.println("max value: " + Kp(50, items));
    }

    public static int Kp(int contain, Item[] items) {
        // 按照价值比排序
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if ((double) o1.value / o1.weight > (double) o2.value / o2.weight) {
                    return -1;
                }
                return 1;
            }
        });

        int sum = 0;
        int c = contain;

        for (int i = 0; i < items.length; i++) {
            if (c > items[i].weight) {
                c -= items[i].weight;
                sum += items[i].value;
            } else {
                sum += (double) c / items[i].weight * items[i].value;
                c = 0;
                break;
            }
        }

        return sum;
    }
}

class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
