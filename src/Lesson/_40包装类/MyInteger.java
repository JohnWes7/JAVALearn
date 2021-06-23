package Lesson._40包装类;

public class MyInteger {
    private int value;
    private static MyInteger[] cache = new MyInteger[256];
    private static final int LOW = -128;
    private static final int HIGH = 127; 

    static{
        for (int i = MyInteger.LOW; i <= MyInteger.HIGH; i++) {
            cache[i-MyInteger.LOW] = new MyInteger(i);
        }
    }

    public static MyInteger valueOf(int value){
        if (value >= MyInteger.LOW && value <= MyInteger.HIGH) {
            return MyInteger.cache[value-MyInteger.LOW];
        }
        return new MyInteger(value);
    }

    public int intValue(){
        return this.value;
    }

    private MyInteger(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
