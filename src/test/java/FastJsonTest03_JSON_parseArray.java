import com.alibaba.fastjson.JSON;
import org.example.pojo.User;
import org.junit.Test;

import java.util.List;

public class FastJsonTest03_JSON_parseArray {

    @Test
    public void jsonStringToJsonArray() {
        String s = "[{\"age\":22,\"id\":1,\"name\":\"weimin\",\"sex\":\"man\"},{\"age\":50,\"id\":2,\"name\":\"tom\",\"sex\":\"man\"}]";

        List<User> userList = JSON.parseArray(s, User.class);

        userList.forEach(System.out::println);
    }

}
