import java.util.ArrayList;
import java.util.List;

/**
 * 测试
 * @author JohnWest
 * @version 0.1
 */

public class Wellcome
{
    public static void main(String[] args)
    {
        String name = "Johnwest";
        List<String> list = new ArrayList<String>();
        
        int num16 = 0x11;
        int num8 = 011;
        int num2 = 0b11;
        
        float f1 = 0.1f;//同C#
        double f3 = 0.1;//Java的float和double不够精确
        float f2 = 314E-2f;

        list.add(name);
        System.out.println(num2);
        System.out.println(num8);
        System.out.println(num16);
        System.out.println(f1);
        System.out.println(f1 == f3);

        
    }
}