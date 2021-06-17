package Lesson._34Array;

//数组是相同类型数据的有序集合
public class TestArray {
    public static void main(String[] args) {
        int[] c = { 100, 200, 300, 500 };

        // java 的foreach
        for (int temp : c) {
            System.out.println(temp);
        }

        User[] users = new User[3];
        users[0] = new User(5, "lucas");
        users[1] = new User(10, "denil");
        users[2] = new User(22, "22");
        for (User user : users) {
            System.out.println(user);
        }


        // 静态初始化
        User[] users2 = { new User(13, "lily"), new User(60, "sam"), new User(36, "tom") };
        for (User user : users2) {
            System.out.println(user);
        }

        //数组的拷贝
        int[] a = {1,2,3,4,5,6,7,8,9};
        int[] b = new int[6];

        System.arraycopy(a, 1, b, 0, 6);
        for (int i : b) {
            System.out.println(i);
        }
    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{id=" + id + " name=" + name + "}";
    }
}
