package TEST.Battlefield;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.alibaba.fastjson.JSON;

public class jsontojava {
    public static String PATH_57 = "dataAssets/59/test59(1).txt";
    public static String PATH_FALL = "dataAssets/FallEndless/old_fallendless_event.json";

    public static void main(String[] args) {
        
        String json = readtxt(PATH_FALL);

        Event[] events = null;
        events = JSON.parseObject(json, Event[].class);
        
        for (int i = 0; i < events.length; i++) {
            if (events[i].Eventtitle != null) {
                System.out.println(events[i].Eventtitle);
            }
        }

        
        if (events[19] == null) {
            System.out.println();
            System.out.println("nul");
        }else{
            System.out.println();
            System.out.println(events[19].Eventtitle);
            System.out.println(events.length);
        }

        
    }

    public static String readtxt(String PATH){
        StringBuilder sb = new StringBuilder();

        try {
            FileReader reader = new FileReader(PATH);

            int ch = -1;

            while ((ch = reader.read()) != -1) {
                sb.append((char)ch);
            }

            System.out.println(sb.toString());

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}

class Event{
    public int Id;
    public String Eventtitle;
    public String Desciption;
    public String Icon;
    public int Precondition;
    public String Choice1;
    public String Choice1Change;
    public String Choice2;
    public String Choice2Change;
    public String Choice3;
    public String Choice3Change;
}
