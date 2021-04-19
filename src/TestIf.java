/**
 * 测试if
 */

public class TestIf {
    public static void main(String[] args) {
        int r = (int) (Math.random() * 10);
        System.out.println(r);

        // 如果r小于5
        if (r < 5) {
            System.out.println("数比较小");
        } else {
            System.out.println("数比较大");
        }

        // 生成一个0，100的随机数
        int age = (int) (Math.random() * 100);

        if (age < 15) {
            System.out.println("age:" + age + "  儿童");
        } 
        else if (age < 25) {
            System.out.println("age:" + age + "  青年");
        } 
        else if (age < 45) {
            System.out.println("age:" + age + "  中年");
        } 
        else if (age < 65) {
            System.out.println("age:" + age + "  中老年");
        } 
        else if (age < 85) {
            System.out.println("age:" + age + "  老年");
        }
        else{
            System.out.println("age:" + age + "  凯尔西");
        }
    }
}