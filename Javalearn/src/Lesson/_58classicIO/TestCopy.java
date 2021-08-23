package Lesson._58classicIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

@SuppressWarnings("unused")
public class TestCopy {
    private static final String test_setu_PATH = "resource/58/test_setu.jpg";
    private static final String test_setu1_PATH = "resource/58/test_setu(1).jpg";
    private static final String test_TXT_PATH = "resource/58/test58.txt";
    private static final String test_TXT1_PATH = "resource/58/test58(1).txt";

    public static void main(String[] args) {
        //copyFile(test_setu_PATH, test_setu1_PATH);
        //copyFile2(test_setu_PATH, test_setu1_PATH);
        copyFile2(test_TXT_PATH, test_TXT1_PATH);
    }

    // 读一个字节，写一个字节 效率最低的原始版本 （没什么用）
    public static void copyFile(String src, String des) {
        try (FileInputStream fis = new FileInputStream(src); FileOutputStream fos = new FileOutputStream(des);) {
            int temp = 0;
            while ((temp = fis.read()) != -1) {
                fos.write(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("copy complete");
    }

    //增加缓存提高缓存效率
    public static void copyFile2(String src, String des){
        System.out.println("function: copyFile2");

        try (FileInputStream fis = new FileInputStream(src); FileOutputStream fos = new FileOutputStream(des);) {
            byte[] temp = new byte[1024];
            int num = 0;
            while ((num = fis.read(temp)) != -1) {
                System.out.println(Arrays.toString(temp));
                //fos.write(b, off, len); 用这个不会乱码 可以存取指定长度
                fos.write(temp, 0, num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("copy complete");
        
    }
}
