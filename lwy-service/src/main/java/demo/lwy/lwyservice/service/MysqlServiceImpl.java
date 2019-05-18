package demo.lwy.lwyservice.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import demo.lwy.lwyservice.entity.Person;
import demo.lwy.lwyservice.utils.HttpUtils;
import org.springframework.stereotype.Service;

@Service
public class MysqlServiceImpl implements MysqlService {


    @Override
    public int savePerson(Person person) {
        int count = 0;
        String data = JSON.toJSONString(person);

        String url = "http://localhost:8086/savePerson";
        String result = HttpUtils.doPost(url,data);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String message = (String) jsonObject.get("message");
        if("ok".equals(message)){
            count = (int) jsonObject.get("data");
        }
        return count;
    }
}
