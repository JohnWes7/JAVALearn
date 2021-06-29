
public class BooleanTest {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        System.out.println("===========boolean类型==========");
        boolean judge1 = true;
        boolean judge2 = true && false;
        System.out.println(judge2);

        System.out.println("===========逻辑运算符===========");
        judge1 = 2 < 5 || (4 < 4); //短路或 编译不了
        judge2 = false && 4 < 4;  //短路与
        //judge2 = false & 4 < 4/0;
        System.out.println(judge1);
        System.out.println(judge2);

        System.out.println("===========位运算==========");
        int a = 3;
        int b = 7;
        System.out.println(a | b);
        System.out.println(a & b);
        System.out.println(a ^ b);
        System.out.println( ~a );
        System.out.println(a << 1);
        System.out.println(a >> 1);
        
        System.out.println("=============字符串连接=============");
        System.out.println("results: " + (a + b));
        System.out.println("results: " + a + b);//字符串连接符

        System.out.println("=============三元表达式==============");
        a = (a < b)? b : a;
        System.out.println(a);
    }
}