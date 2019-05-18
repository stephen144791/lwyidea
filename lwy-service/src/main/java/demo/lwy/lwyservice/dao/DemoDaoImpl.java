package demo.lwy.lwyservice.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.WriteResult;
import demo.lwy.lwyservice.entity.DemoEntity;
import demo.lwy.lwyservice.entity.DemoRespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DemoDaoImpl implements DemoDao {

    @Autowired
    MongoOperations mongoOperations;

    @Override
    public void insertDemo(DemoEntity demoEntity) {
        demoEntity.setCreatedBy("lwy");
        demoEntity.setUpdatedBy("lwy");
        Date date = new Date();
        demoEntity.setCreatedDate(date);
        demoEntity.setUpdatedDate(date);
        mongoOperations.insert(demoEntity);
    }

    @Override
    public void insertDemoList(List<DemoEntity> demoEntityList) {
        mongoOperations.insertAll(demoEntityList);
    }

    @Override
    public DemoRespEntity findOneDemoByName(DemoEntity demoEntity) {
        System.out.println("[findOneDemoByName]" + demoEntity);
        BasicDBObject fieldObject = new BasicDBObject();
        fieldObject.append("name",true).
                append("age",true).
                append("gender",true).
                //append("created_date",true).
                //append("created_by", true).
                //append("updated_date",true).
                //append("updated_by", true).
                append("_id",false);


        BasicDBObject dbObject = new BasicDBObject();
        dbObject.append("name",demoEntity.getName());

        Query query = new BasicQuery(dbObject,fieldObject);
        return mongoOperations.findOne(query,DemoRespEntity.class);
    }

    @Override
    public List<DemoRespEntity> findDemoList(DemoEntity demoEntity) {
        BasicDBObject fieldObject = new BasicDBObject();
        fieldObject.append("name",true).
                append("age",true).
                append("gender",true).
                append("_id",false);


        BasicDBObject dbObject = new BasicDBObject();
        dbObject.append("age",demoEntity.getAge());

        Query query = new BasicQuery(dbObject,fieldObject);
        return mongoOperations.find(query,DemoRespEntity.class);
    }

    @Override
    public int updateDemo(DemoEntity demoEntity) {
        Query query = new Query(Criteria.where("name").is(demoEntity.getName()));
        Update update = new Update().
                set("age",demoEntity.getAge()).
                set("created_date",new Date());
        WriteResult writeResult = mongoOperations.updateMulti(query, update, DemoEntity.class);
        return writeResult.getN();
    }

    @Override
    public long findCount() {
        Query query = new Query();

        return mongoOperations.count(query,"java_mdb");
    }
}
