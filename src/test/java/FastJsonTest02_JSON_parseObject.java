import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.example.pojo.NiceCard;
import org.example.pojo.Person;
import org.example.pojo.User;
import org.junit.Test;

public class FastJsonTest02_JSON_parseObject {

    @Test
    public void jsonStringToJSONObject() {
        String s = "{'age':22,'id':1,'name':'weimin','sex':'man'}";
        JSONObject jsonObject = JSON.parseObject(s);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("id"));
        // JSONObject 实现了map接口
    }

    @Test
    public void jsonStringToBean() {
        String s = "{'age':22,'id':1,'name':'weimin','sex':'man'}";
        User user = JSON.parseObject(s, User.class);
        System.out.println(user);
    }

    @Test
    public void jsonStringToBeanTypeReference() {
        String s = "{'age':22,'id':1,'name':'weimin','sex':'man'}";
        User user = JSON.parseObject(s, new TypeReference<User>() {
        });
        System.out.println(user);
    }

    // 浅克隆
    @Test
    public void cloneTest() throws CloneNotSupportedException {
        NiceCard niceCard = new NiceCard();
        Person person = new Person();
        person.setName("小李");
        niceCard.setPerson(person);

        NiceCard clone = niceCard.clone();
        Person person1 = clone.getPerson();
        person1.setName("小王");

        niceCard.award();
        clone.award();

        System.out.println(person == person1);
    }

    @Test
    public void deepClone() {
        NiceCard niceCard = new NiceCard();
        Person person = new Person();
        person.setName("小李");
        niceCard.setPerson(person);

        NiceCard clone = JSON.parseObject(JSON.toJSONString(niceCard), NiceCard.class);
        System.out.println(clone.getPerson() == person);
    }
}
