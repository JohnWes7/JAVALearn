package Lesson._54HashMap;

import java.util.Objects;

//equals和hashcode通常要一起重写
//equals为true 那么hashcode必须相等 (主要就是为了hashmap，如果不这么规定，hashmap存取的时候就有悖论了)
public class TestEqualsHashcode {
    public static void main(String[] args) {
        Cat a = new Cat();
        a.id = 0;
        a.name = "a";
        Cat b = new Cat();
        b.id = 0;
        b.name = "b";
        System.out.println("a:" + a.hashCode() + " b:" + b.hashCode());
        System.out.println(a == b); // 比地址
        System.out.println(a.equals(b));
        System.out.println();

        String stra = new String("aaa");
        String strb = "aaa";
        System.out.println("a:" + stra.hashCode() + " b:" + strb.hashCode());
        System.out.println(stra == strb);
        System.out.println(stra.equals(strb));
    }
}

// 只重写equals
class Cat {
    int id;
    String name;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Cat cat = (Cat) obj;
        return id == cat.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

// ==：关系运算符

// 在基本数据类型中比较两个值的内容是否相等

// 在引用类型型中比较的是两个对象的地址是否相等

// equals()是Object类中的方法

// 1.基本数据类型无法使用equals()方法

// 2.在引用类型中若是没有重写Object类时，则默认使用Object类的equals方法，则仍然

// 利用“==”比较两个对象的内存地址,若是重写Object类的equals方法，则调用子类重写后

// 的方法可以进行内容或值的比较

// 例如字符串中，equals()方法重写Object类的equals()方法，从而可以直接比较字符串的

// 内容。(可以自行观察字符串equals()源代码，此处不细讲)