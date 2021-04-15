public class TypeConvert03 
{


    public static void main(String[] args) 
    {
        //自动转换类型 隐式转换
        long a = 3800;
        float b = a;
        System.out.println(b);
        byte c = 121;
        
        //算数运算符 两个操作数都是整形 有一个是long结果则为long 否则结果为int 即使是byte
    }
}