package Lesson._49Generic;

// 代码可读性更好 不用做强制转换
// 程序更加安全
public class TestGeneric {
    public static void main(String[] args) {
        Test01();
    }

    // 参数化类型
    // 数据类型 只能是引用类型
    // 类型擦除
    // 泛型主要用于编译阶段 编译后生成的字节码class文件不包含泛型中的类型信息
    // 涉及类型转换仍然是普通的强制类型转换
    // 泛型主要是方便了程序员的代码编写 以及更好的安全性检测
    public static void Test01() {
        Generic1<Integer> g1 = new Generic1<>();
        g1.aa(50);
        g1.bb("bbbb");
    }
}

class Generic1<T> {
    public T aa(T objT) {
        System.out.println(objT);
        return objT;
    }

    public <N> void bb(N obj) {
        System.out.println(obj);
    }
}

interface MyList<E> {
    int size();

    boolean isEmpty();

    void add(E e);

    E get(int index);
}
