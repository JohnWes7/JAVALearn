package TEST.Battlefield;

public class test_str_is_class {
    public static void main(String[] args) {
        String name = "johnwest";
        System.out.println(name);

        test(name);
        System.out.println(name);
    
    }

    public static void test(String str) {
        str += "dwasdwa";
    }
}
