package Lesson._59IO流体系;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TestsFileReaderWriter {
    private static final String test59_PATH = "resource/59/test59.txt";
    private static final String test59_1_PATH = "resource/59/test59(1).txt";
    private static final String class_data_PATH = "resource/59/class_data.txt";
    private static final String test_RAF = "resource/59/raf.txt";

    public static void main(String[] args) {
        // test();
        // testBuffered();
        // testBufferedReaderWriter();

        // String str = "dadadad123 测试";
        // testByteArrayIOStream(str.getBytes());

        // testDataOStream();
        // testDataIStream();

        // testObjectOStream();
        // testObjectIStream();

        // testIOStreamRW();
        testRandomAccessFile();
    }

    // 关于文件字符流的操作
    public static void test() {
        try (FileReader fr = new FileReader(test59_PATH); FileWriter fw = new FileWriter(test59_1_PATH)) {
            int num = 0;
            char[] chars = new char[1024];
            while ((num = fr.read(chars)) != -1) {
                System.out.println(Arrays.toString(chars));
                fw.write(chars, 0, num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 缓冲字节流
    // java缓冲流本身不具备IO流的读取和写入功能
    // BufferedInputStreamBufferedOutputString
    public static void testBuffered() {
        try (FileInputStream fis = new FileInputStream(test59_PATH);
                FileOutputStream fos = new FileOutputStream(test59_1_PATH);
                BufferedInputStream bis = new BufferedInputStream(fis);
                BufferedOutputStream bos = new BufferedOutputStream(fos);) {

            int temp = 0;
            while ((temp = bis.read()) != -1) {
                bos.write(temp);
            }
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 缓冲字符流
    // BufferedReader/BufferedWriter
    // 增加了缓存机制 大大提高了读写文本的效率
    // 同时 提供了更方便的按行读取的方法readLine
    // 处理文本时 我们一般可以使用缓冲字符流
    public static void testBufferedReaderWriter() {
        try (BufferedReader br = new BufferedReader(new FileReader(test59_PATH));
                BufferedWriter bw = new BufferedWriter(new FileWriter(test59_1_PATH));) {

            String tempString = "";

            while ((tempString = br.readLine()) != null) {
                System.out.println(tempString);
                bw.write(tempString);
                bw.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 字节数组流
    // ByteArrayInputStream ByteArrayOutputStream
    // 经常用在需要流和数组之间转化的情况
    // FileInputStream十八文件当作数据源
    // ByteArrayInputStream则是把内存中的某个字节数组对象当作数据源
    public static void testByteArrayIOStream(byte[] input) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(input)) {
            int temp = 0;
            int num = 0;

            while ((temp = bis.read()) != -1) {
                System.out.print((char) temp);
                num++;
            }

            System.out.println("\ntotal number: " + num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 数据流
    // 数据流将基本数据类型与字符串类型作为数据源
    // 从而允许程序以与机器无关的方式从底层输入输出流中操作Java基本数据类型与字符串类型
    // DataInputStream和DataOutputStream
    public static void testDataOStream() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(test59_1_PATH))) {
            dos.writeChar('j');
            dos.writeInt(15);
            dos.writeDouble(Math.random());
            dos.writeBoolean(false);
            dos.writeUTF("English 简体中文");

            // 手动刷新缓存区 将流中的数据写入到文件中
            dos.flush();
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }
    }

    public static void testDataIStream() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(test59_1_PATH))) {
            // 读取数据时 需要和写入的顺序保持一致 否则将不能正确的读取数据
            System.out.println(dis.readChar());
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readUTF());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 对象流
    // ObjectInputStream/ObjectOutputStream
    // 以对象为数据源 但是必须将传输的对象进行序列化和反序列化操作
    // 需要序列化的对象 需要实现接口java.io.Serializable
    // 对象序列化作用有两种
    // 持久化
    // 把对象的字节序列永久的保存在硬盘上 通常存放在一个文件中
    // 比如 休眠的实现 以后服务器session管理 hibernate将对象持久化实现
    // 网络通信
    // 在网络上传送对象的字节序列
    // 比如 服务器之间的数据通信 对象传递

    // 注意 static属性不参与序列化
    // 对象中的某些属性如果不想被序列化，不能使用static
    // 而是使用transient修饰
    public static void testObjectOStream() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(class_data_PATH))) {
            ArrayList<User> list = new ArrayList<>();
            list.add(new User(1, "link", "1005"));
            list.add(new User(2, "ada", "1023"));
            list.add(new User(3, "akasi", "648"));

            oos.writeObject(list);

            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings(value = { "unchecked" })
    public static void testObjectIStream() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(class_data_PATH))) {
            ArrayList<User> list = (ArrayList<User>) ois.readObject();

            for (User user : list) {
                System.out.println(user.getId() + " " + user.getName() + " " + user.getPwd());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 转换流
    // InputStreamReader OutputStreamWrite 来实现字节流转字符流
    public static void testIOStreamRW() {
        // 字节流转字符流
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

            String str = br.readLine();

            while (!str.equals("exit")) {
                bw.write("键盘输入:" + str);
                bw.newLine();
                bw.flush();

                str = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 任意访问文件流
    // RandomAccessFile可以实现两个作用
    // 实现对以一个文件的读写操作
    // 可以访问文件的任意位置 不像其他流只能按照先后顺序读取
    public static void testRandomAccessFile() {
        try (RandomAccessFile raf = new RandomAccessFile(test_RAF, "rw")) {
            int[] data = { 10, 20, 30, 40, 50, 60, 98, 56, 100 };
            // 写入
            for (int i : data) {
                raf.writeInt(i);
            }

            // 读取 直接从指定位置开始读取
            raf.seek(12);// 从第n个字节开始
            System.out.println(raf.readInt());

            raf.seek(8);
            raf.writeInt(999);

            for (int i = 0; i < data.length; i++) {
                raf.seek(i * 4);
                System.out.println(raf.readInt() + "\t");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Serializable 空接口用来标记是否能被序列化
class User implements Serializable {
    private int id;
    private String name;
    transient private String pwd;

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
