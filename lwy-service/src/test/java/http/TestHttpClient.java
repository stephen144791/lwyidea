package http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import demo.lwy.lwyservice.entity.Person;
import demo.lwy.lwyservice.utils.HttpUtils;

public class TestHttpClient {

    public static void main(String[] args) {
        int count = 0;
        String url = "http://localhost:8086/savePerson";
        Person person = new Person();
        person.setPersonId("127");
        person.setEmail("aa@qq.com");
        person.setMobile("13844445555");
        person.setGender("男");
        person.setName("张一山");
        person.setAge(23);
        String data = JSON.toJSONString(person);
        System.out.println(data);
        String result = HttpUtils.doPost(url, data);
        System.out.println(result);
        JSONObject parse = JSONObject.parseObject(result);
        String message = (String) parse.get("message");
        if("ok".equals(message)){
            count = (int) parse.get("data");
        }
        System.out.println(count);
    }
}
