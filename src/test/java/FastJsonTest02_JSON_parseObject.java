import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.example.pojo.User;
import org.junit.Test;

public class FastJsonTest02_JSON_parseObject {

    @Test
    public void jsonStringToJSONObject(){
        String s = "{'age':22,'id':1,'name':'weimin','sex':'man'}";
        JSONObject jsonObject = JSON.parseObject(s);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("id"));
        // JSONObject 实现了map接口
    }

    @Test
    public void jsonStringToBean(){
        String s = "{'age':22,'id':1,'name':'weimin','sex':'man'}";
        User user = JSON.parseObject(s, User.class);
        System.out.println(user);
    }

    @Test
    public void jsonStringToBeanTypeReference(){
        String s = "{'age':22,'id':1,'name':'weimin','sex':'man'}";
        User user = JSON.parseObject(s, new TypeReference<User>(){});
        System.out.println(user);
    }
}
