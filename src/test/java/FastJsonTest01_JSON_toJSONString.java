import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.example.pojo.User;
import org.junit.Test;

import java.util.*;

public class FastJsonTest01_JSON_toJSONString {

    // java bean 转为json字符串
    @Test
    public void beanToJsonString(){
        User user = User.builder().id(1).age(22).name("weimin").sex("man").build();
        System.out.println(JSON.toJSONString(user)); // {"age":22,"id":1,"name":"weimin","sex":"man"}
    }

    // java bean 转为json字符串，格式化
    @Test
    public void beanToJsonStringFormat(){
        User user = User.builder().id(1).age(22).name("weimin").sex("man").build();
        System.out.println(JSON.toJSONString(user, true));
        // {
        //	"age":22,
        //	"id":1,
        //	"name":"weimin",
        //	"sex":"man"
        //}
    }

    // map 转为json字符串
    @Test
    public void mapToJsonString(){
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("id",1);
        userMap.put("age","22");
        userMap.put("name","weimin");
        userMap.put("sex","man");

        System.out.println(JSON.toJSONString(userMap));
    }

    // list 转为json字符串
    @Test
    public void listToJsonString(){
        List<User> userList = new ArrayList<>();
        User user1 = User.builder().id(1).age(22).name("weimin").sex("man").build();
        User user2 = User.builder().id(2).age(50).name("tom").sex("man").build();
        userList.add(user1);
        userList.add(user2);

        System.out.println(JSON.toJSONString(userList));
    }

    // java bean 转为json字符串，使用单引号
    @Test
    public void beanToJsonStringExtend_UseSingleQuotes(){
        User user = User.builder().id(1).age(22).name("weimin").sex("man").build();
        System.out.println(JSON.toJSONString(user, SerializerFeature.UseSingleQuotes));
        // {'age':22,'id':1,'name':'weimin','sex':'man'}
    }

    // java bean 转为json字符串，格式化
    @Test
    public void beanToJsonStringExtend_PrettyFormat(){
        User user = User.builder().id(1).age(22).name("weimin").sex("man").build();
        System.out.println(JSON.toJSONString(user, SerializerFeature.PrettyFormat));
        // {
        //	"age":22,
        //	"id":1,
        //	"name":"weimin",
        //	"sex":"man"
        //}
    }

    // 格式化日期类型
    @Test
    public void beanToJsonStringExtend_WriteDateUseDateFormat(){
        System.out.println(JSON.toJSONString(new Date()));
        System.out.println(JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat));
        System.out.println(JSON.toJSONStringWithDateFormat(new Date(), "HH:mm:ss"));

        // 1704620672330
        //"2024-01-07 17:44:32"
        //"17:44:32"

        User user = User.builder().id(1).age(22).name("weimin").sex("man").birth(new Date()).build();
        System.out.println(JSON.toJSONString(user));
        System.out.println(JSON.toJSONString(user, SerializerFeature.WriteDateUseDateFormat));
        System.out.println(JSON.toJSONStringWithDateFormat(user, "HH:mm:ss"));

        //{"age":22,"birth":1704620672456,"id":1,"name":"weimin","sex":"man"}
        //{"age":22,"birth":"2024-01-07 17:44:32","id":1,"name":"weimin","sex":"man"}
        //{"age":22,"birth":"17:44:32","id":1,"name":"weimin","sex":"man"}
    }

    // 是否忽略null value
    @Test
    public void beanToJsonStringExtend_WriteMapNullValue(){
        User user = User.builder().id(1).age(22).name("weimin").sex("man").build();
        System.out.println(JSON.toJSONString(user));
        System.out.println(JSON.toJSONString(user, SerializerFeature.WriteMapNullValue));
        // {"age":22,"id":1,"name":"weimin","sex":"man"}
        //{"age":22,"birth":null,"id":1,"name":"weimin","sex":"man"}
    }

    // 序列化时写入类型信息
    @Test
    public void beanToJsonStringExtend_WriteClassName(){
        User user = User.builder().id(1).age(22).name("weimin").sex("man").build();
        System.out.println(JSON.toJSONString(user));
        System.out.println(JSON.toJSONString(user, SerializerFeature.WriteClassName));
        //{"age":22,"id":1,"name":"weimin","sex":"man"}
        //{"@type":"org.example.pojo.User","age":22,"id":1,"name":"weimin","sex":"man"}
    }

}
