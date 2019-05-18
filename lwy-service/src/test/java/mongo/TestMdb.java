package mongo;

import demo.lwy.lwyservice.LwyServiceApplication;
import demo.lwy.lwyservice.entity.DemoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LwyServiceApplication.class)
public class TestMdb {

    @Autowired
    MongoOperations mongoOperations;

    @Test
    public void insertDemo() {
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setName("aaa");
        demoEntity.setAge(23);
        demoEntity.setGender("F");
        demoEntity.setCreatedBy("lwy");
        demoEntity.setCreatedDate(new Date());
        mongoOperations.insert(demoEntity);
    }
}
