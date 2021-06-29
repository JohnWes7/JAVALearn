package Lesson._57IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//不规范 下一个更规范
public class Test {
    public static final String PATH57 = "resource/57/test57.txt";
    public static final String PATH43 = "resource/test43.txt";

    public static void main(String[] args) {
        // ReadFile();
        writeFile();
    }

    public static void ReadFile() {
        //使用try catch finally的经典结构
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(PATH43);

            int s1 = fis.read();

            System.out.println((char) s1);
            System.out.println((char) fis.read());
            System.out.println((char) fis.read());
            System.out.println((char) fis.read());
            System.out.println(fis.read()); // 文件读取完毕返回-1

            // 流对象用完后必须关闭！不然总会占用系统资源 最终回造成系统崩溃

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeFile() {
        // 只测试英文不测试中文
        FileOutputStream fos = null;
        try {
            // 找不到文件夹会报错
            fos = new FileOutputStream(PATH57);

            fos.write('a');
            fos.write('d');
            fos.write('s');
            String str = "johnwest";
            fos.write(str.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
