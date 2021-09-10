package TEST.Battlefield;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import org.apache.commons.io.FileUtils;

public class jsontojava {
    public static String PATH_57 = "dataAssets/59/test59(1).txt";
    public static String PATH_FALL = "dataAssets/FallEndless/old_fallendless_event.json";
    public static String PATH_NEW_FALL = "dataAssets/FallEndless/new_fallendless_event.json";
    public static String PATH_NEW_TEST = "dataAssets/FallEndless/new_fallendless_event_TEST.json";

    public static void main(String[] args) {
        // test();
        Old2New();

        System.exit(0);
    }

    public static void test() {
        Test1 t1 = new Test1();
        t1.name = "dwasd";
        t1.tests = new ArrayList<Test2>();
        t1.tests.add(new Test2());
        t1.tests.get(0).name = "65468";

        String str = JSON.toJSONString(t1);
        writetxt(PATH_NEW_TEST, str);
    }

    public static void Old2New() {
        // 获得读取出来的json字符串
        String json = readtxt(PATH_FALL);

        // 用来装事件的数组
        oldEvent[] events = null;
        events = JSON.parseObject(json, oldEvent[].class);

        // 检验json反序列化是否成功
        for (int i = 0; i < events.length; i++) {
            if (events[i].Eventtitle != null) {
                System.out.println(events[i].Eventtitle);
            }
        }
        System.out.println("反序列事件总数：" + events.length);

        // 存放事件的字典
        Map<String, newEventInfo> dict = new HashMap<>();
        // 存放用的数组
        List<newEventInfo> list = new ArrayList<>();

        for (int i = 0; i < events.length; i++) {
            newEventInfo temp = new newEventInfo(events[i].Eventtitle, events[i].Desciption, events[i].Icon,
                    null, "请写入事件链(没有就删除)");

            List<Option> options = new ArrayList<>();

            // 要用equals 记得测C#的==和equals
            if (!events[i].Choice1.equals("")) {
                options.add(Old2Option(events[i].Choice1, events[i].Choice1Change));
            }
            if (!events[i].Choice2.equals("")) {
                options.add(Old2Option(events[i].Choice2, events[i].Choice2Change));
            }
            if (!events[i].Choice3.equals("")) {
                options.add(Old2Option(events[i].Choice3, events[i].Choice3Change));
            }
            System.out.println();
            temp.options = options;

            //用字典存储
            // int index = (int)'a' + i;
            // char ch = (char)index;
            // dict.put(ch + events[i].Eventtitle, temp);

            //用数组存储
            temp.id = events[i].Eventtitle.split("#")[1];
            list.add(temp);
        }

        flEvent fl = new flEvent();
        fl.DayEvents = list;
        String dictjson = JSON.toJSONString(fl, SerializerFeature.NotWriteDefaultValue);
        System.out.println(dictjson + "\n");

        writetxt(PATH_NEW_FALL, dictjson);
    }

    public static Option Old2Option(String title, String change) {
        System.out.println("写入option：" + title);

        String[] strs = change.split("#");

        Option option1 = null;

        if (change.equals("")) {
            // 如果没有操作
            option1 = new Option(title);
            return option1;
        } else {
            // 增加固定值
            option1 = new Option(title, Integer.valueOf(strs[0]), Integer.valueOf(strs[1]));
            List<String> itemlist = new ArrayList<>();
            itemlist.add("固定物品增减用(字符串表示 格式为 物品代码.lost/add) 没有直接null或者删除该行");
            option1.add_item = itemlist;
        }

        // 如果有随机判定 就增加一个模板
        if (strs.length > 2) {
            List<RandomPart> randomParts = new ArrayList<>();
            randomParts.add(new RandomPart());
            option1.random_parts = randomParts;
        }
        System.out.println("done!");
        return option1;
    }

    public static String readtxt(String PATH) {
        StringBuilder sb = new StringBuilder();

        try {
            FileReader reader = new FileReader(PATH);

            int ch = -1;

            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
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

    public static void writetxt(String PATH, String str) {
        try {
            FileUtils.writeStringToFile(new File(PATH), str, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("complete");
        }
    }
}

class flEvent{
    public List<newEventInfo> DayEvents;
}

class oldEvent {
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

class newEventInfo {
    public String id;
    public String event_title;
    public String description;
    public String icon;
    public String precondition;
    public String event_chain;

    public List<Option> options;

    public newEventInfo(String eventTitle, String description, String icon, String precondition, String eventchain) {
        this.event_title = eventTitle;
        this.description = description;
        this.icon = icon;
        this.precondition = precondition;
        this.event_chain = eventchain;
    }
}

class Option {
    // 单项选泽的文字
    public String label;

    // 固定体力增加量（负数为扣除）
    public int add_health;
    // 固定能量增减量（负数为扣除）
    public int add_energy;
    // 固定物品增减用(字符串表示 格式为 物品代码.lost/add)
    public List<String> add_item;

    // 多次判定
    public List<RandomPart> random_parts;

    public Option(String label, int add_Health, int add_Energy) {
        this.label = label;
        add_health = add_Health;
        add_energy = add_Energy;
    }

    public Option(String label) {
        this.label = label;
    }

}

class RandomPart {
    // 一次百分比判定
    public List<RandomModify> random_modifies;

    // 生成默认json模板
    public RandomPart() {
        this.random_modifies = new ArrayList<RandomModify>();

        random_modifies.add(new RandomModify(0.3f, 0, 0));
        random_modifies.add(new RandomModify(0.7f, 0, 0));
    }
}

class RandomModify {
    // 一次百分比判定中某一项百分数
    public float percentage;

    public int add_health;
    public int add_energy;
    public List<String> add_item;

    public RandomModify(float percentage, int add_Health, int add_Energy) {
        this.percentage = percentage;
        add_health = add_Health;
        add_energy = add_Energy;
        add_item = new ArrayList<String>();
        add_item.add("该百分比下随机物品增减用(字符串表示 格式为 物品代码.lost/add) 没有直接null或者删除该行");
    }

}

class Test1 {
    public String name;
    public List<Test2> tests;
}

class Test2 {
    public String name;
}