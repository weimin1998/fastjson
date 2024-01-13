import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import org.example.pojo.User;
import org.junit.Test;

import java.util.List;

public class FastJsonTest04_JSON_toJSONBytes {

    @Test
    public void beanToBytes() {
        User user = User.builder().id(1).age(22).name("weimin").sex("man").build();
        byte[] bytes = JSON.toJSONBytes(user);
    }

    // byte 转为 字符串，反序列化
    @Test
    public void bytesToBean(){
        User user = User.builder().id(1).age(22).name("weimin").sex("man").build();
        byte[] bytes = JSON.toJSONBytes(user);

        Object o = JSON.parseObject(bytes, User.class, Feature.IgnoreNotMatch);
        System.out.println(o);
    }
}
