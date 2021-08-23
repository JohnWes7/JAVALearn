package Lesson._58classicIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//按处理数据的单位分类

//字节流 以字节为单位获取数据 命名以Stream结尾一般是字节流
//如FileInputStream FileOutputStream

//字符流 以字符为单位获取数据 命名上Reader/Writer结尾一般是字符流
//如FileReader FileWriter

//按处理对象不同分类

//节点流 可以直接从数据源或者目的地读写数据
//如 FileReader DataInputStream

//处理流 不直接连接到数据源或者目的地 是处理流的流 通过对其他流的处理提高程序的性能
//如BufferedInputStream BufferedReader

//InputStream
//OutputStream
//Reader
//Writer
//RandomAccessFile 随意访问文件

public class Test {

    public static final String PATH57 = "dataAssets/57/test57.txt";
    public static final String PATH58 = "dataAssets/58/test58.txt";

    public static void main(String[] args) {
        // TestStream();
        // readFile2();
        // TryCatchWriter();
        TryWithWriter();
    }

    // 流的使用经典代码
    public static void TestStream() {
        System.out.println("function: TestStream");

        FileInputStream fis = null;
        try {
            // 创建对象
            fis = new FileInputStream(PATH57);

            // 通过循环读取
            StringBuilder stringBuilder = new StringBuilder();
            int temp = 0;
            while ((temp = fis.read()) != -1) {
                stringBuilder.append((char) temp);
            }

            System.out.println(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 经典
    public static void readFile2() {
        System.out.println("function: readFile2");

        try (FileInputStream fis = new FileInputStream(PATH57)) {
            StringBuilder sb = new StringBuilder();

            // 通过循环读取
            int temp = 0;
            while ((temp = fis.read()) != -1) {
                sb.append((char) temp);
            }

            // 输出
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void TryCatchWriter() {
        String str = "function: TryCatchWriter\ntext58: 卡哇大~~";

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(PATH58);

            fos.write(str.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void TryWithWriter(){
        String str = "function: TryWithWriter\ntext58: 卡哇大~~";

        try (FileOutputStream fos = new FileOutputStream(PATH58)) {
            fos.write(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
