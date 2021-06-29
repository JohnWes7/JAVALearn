package Lesson._57IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class TestTryWith {
    public static void main(String[] args) {
        readFile();
    }

    public static void readFile() {
        //编译器自动生成finally 进行关闭
        try (FileInputStream fis = new FileInputStream("resource/test57.txt");) {
            byte[] bytes =  fis.readAllBytes();
            
            Charset charset = Charset.defaultCharset();
            ByteBuffer bb = ByteBuffer.wrap(bytes);
            CharBuffer cb = charset.decode(bb);

            System.out.println(cb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
