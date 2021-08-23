package Lesson._46Set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        // test01();
        test02();
    }

    public static void test01() {
        Set<Object> set = new HashSet<Object>();
        // 特点 无序 不可重复
        set.add("hello");
        set.add("world");
        set.add("hello");
        System.out.println(set);

        // 其他方法和list一致因为set和list都是Collection的子接口
        System.out.println(set.size());
        System.out.println(set.isEmpty());
    }

    // Set中不可重复的核心 equals()方法
    public static void test02() {
        String a = "a";
        String b = new String("a");
        // equals 默认比较就是 == 比较是不是同一个对象
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println();

        Emp emp0 = new Emp(0, "xiaoa");
        Emp emp1 = new Emp(0, "xiaob");
        Emp emp2 = new Emp(1, "c");

        System.out.println(emp0 == emp1);
        System.out.println(emp0.equals(emp1));

        Set<Object> s = new HashSet<Object>();
        s.add(emp0);
        s.add(emp1);
        s.add(emp2); // 相等的元素不会再被加入(equals 返回 true)

        System.out.println(s);
    }
}

class Emp {
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Emp emp = (Emp) obj;

        return this.id == emp.id;
    }

    //重写equals要重写hashcode
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" + "id:" + this.id + " name:" + this.name + "}";
    }
}
