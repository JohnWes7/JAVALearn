package TEST.LD;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

import TEST.Battlefield.jsontojava;

public class ItemJson2new {

    // in
    public final static String ITEM_INFO_PATH = "dataAssets/FallEndless/item/fallendless_item.json";
    // out
    public static final String NEW_ITEM_INFO_PATH = "dataAssets/FallEndless/item/new_fallendless_item.json";
    public static final String DICT_PATH = "dataAssets/FallEndless/item/FE_item_l_simp_chinese_l_english.json";

    public static void main(String[] args) {
        to_new_json();
    }

    static void to_new_json() {

        // 导入到类
        String json = jsontojava.readtxt(ITEM_INFO_PATH);
        old_item_info[] item_list = null;
        item_list = JSON.parseObject(json, old_item_info[].class);

        Language language = new Language();

        for (int i = 0; i < item_list.length; i++) {
            change_old_add_Language(item_list[i], language);
        }

        // out
        String item_json = JSON.toJSONString(item_list);
        String dict_json = JSON.toJSONString(language, SerializerFeature.MapSortField);

        jsontojava.writetxt(NEW_ITEM_INFO_PATH, item_json);
        jsontojava.writetxt(DICT_PATH, dict_json);
    }

    static void change_old_add_Language(old_item_info info, Language language) {
        String[] temp = info.item_name.split("#");
        String key = info.id + ".name";
        if (!info.item_name.equals("")) {
            language.l_simp_chinese.put(key, temp[0]);
            if (temp.length > 1) {
                language.l_english.put(key, temp[1]);
            }
            info.item_name = key;
        }else{
            info.item_name = "TODO:写名字 记得在字典加入对应的键值对";
        }
        

        temp = info.desciption.split("#");
        key = info.id + ".desc";
        if (!info.desciption.equals("")) {
            language.l_simp_chinese.put(key, temp[0]);
            if (temp.length > 1) {
                language.l_english.put(key, temp[1]);
            }
            info.desciption = key;

        }else{
            info.desciption = "TODO:写描述 记得在字典加入对应的键值对";
        }
        
    }
}

class old_item_info {
    @JSONField(ordinal = 1)
    public String id;
    @JSONField(ordinal = 2)
    public String item_name;
    @JSONField(ordinal = 3)
    public String desciption;
    @JSONField(ordinal = 4)
    public String icon;
    @JSONField(ordinal = 5)
    public int score;
}

class Language {
    public Map<String, String> l_simp_chinese;
    public Map<String, String> l_english;

    public Language() {
        l_simp_chinese = new HashMap<>();
        l_english = new HashMap<>();
    }
}
