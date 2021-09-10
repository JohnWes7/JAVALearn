package Lesson._60ApacheIO包;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class testApache {
    public static final String test_PATH = "dataAssets/62/test62.txt";
    public static final String test_COPY_PATH = "dataAssets/62/test62(1).txt";
    public static final String SRC_DIRECTORY_PATH = "dataAssets/58";
    public static final String DEST_DIRECTORY_PATH = "dataAssets/62";

    public static void main(String[] args) {
        // writeFile();
        // testReadFile();

        readURL();

        // testFileCopy();

        // testDirectoryCopy();
    }

    public static void writeFile() {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                sb.append(Math.random() + "\n");
            }

            FileUtils.writeStringToFile(new File(test_PATH), sb.toString(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("\ndone!");
        }
    }

    public static void testReadFile() {
        try {
            List<String> list = FileUtils.readLines(new File(test_PATH), Charset.defaultCharset());
            for (String string : list) {
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readURL() {
        try {
            URL url = new URL("https://www.baidu.com");
            InputStream is = url.openStream();
            String str = IOUtils.toString(is, "UTF-8");

            System.out.println(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testFileCopy() {
        File src = new File(test_PATH);
        File dest = new File(test_COPY_PATH);
        try {
            FileUtils.copyFile(src, dest);
            // FileUtils.copyDirectory(srcDir, destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("complete");
    }

    public static void testDirectoryCopy() {
        File src = new File(SRC_DIRECTORY_PATH);
        File dest = new File(DEST_DIRECTORY_PATH);
        //File可以表示目录和文件

        try {
            FileUtils.copyDirectory(src, dest, new FileFilter() {

                @Override
                public boolean accept(File pathname) {
                    //如果是目录或者jpg就拷贝
                    if (pathname.isDirectory() || pathname.getName().endsWith("jpg")) {
                        return true;
                    }
                    return false;
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("complete");
    }
}
