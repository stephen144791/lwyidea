package demo.lwy.lwyservice.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.WriteResult;
import demo.lwy.lwyservice.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonDaoImpl implements PersonDao {

    @Autowired
    MongoOperations mongoOperations;

    @Override
    public void insertOne(Person person) {
        person.setCreatedBy("lwy");
        person.setUpdatedBy("lwy");
        Date date = new Date();
        person.setCreatedDate(date);
        person.setUpdatedDate(date);
        mongoOperations.insert(person);
    }

    @Override
    public void insertList(List<Person> personList) {

            Date date = new Date();
        for (Person p : personList ) {
            p.setCreatedBy("lwy");
            p.setUpdatedBy("lwy");
            p.setCreatedDate(date);
            p.setUpdatedDate(date);
        }

        mongoOperations.insertAll(personList);

    }

    @Override
    public Person findOneByName(Person person) {
        return null;
    }

    @Override
    public List<Person> findPersonList(Person person) {
        return null;
    }

    @Override
    public List<Person> findPersonListToMysql(int skip, int limit) {
        BasicDBObject fieldObject = new BasicDBObject();
        fieldObject.append("name",true).
                append("age",true).
                append("gender",true).
                append("email",true).
                append("mobile",true).
                append("created_date",true).
                append("created_by", true).
                append("updated_date",true).
                append("updated_by", true).
                append("_id",true);
        BasicDBObject dbObject = new BasicDBObject();
        BasicDBObject mysqlFlag = new BasicDBObject();
        mysqlFlag.append("$ne","Y");
        dbObject.append("mysql_flag",mysqlFlag);
        Query query = new BasicQuery(dbObject,fieldObject).skip(skip).limit(limit);
        return mongoOperations.find(query,Person.class);
    }

    @Override
    public int update(Person person) {
        BasicDBObject dbObject = new BasicDBObject();
        dbObject.append("_id",person.getPersonId());
        Query query = new BasicQuery(dbObject);
        Update update = new Update();
        update.set("mysql_flag", "Y");
        update.set("updated_date", new Date());
        WriteResult updateFirst = mongoOperations.updateFirst(query, update, "person");
        return updateFirst.getN();
    }

    @Override
    public long findCountToMysql() {
        BasicDBObject dbObject = new BasicDBObject();
        BasicDBObject mysqlFlag = new BasicDBObject();
        mysqlFlag.append("$ne","Y");
        dbObject.append("mysql_flag",mysqlFlag);
        Query query = new BasicQuery(dbObject);

        return mongoOperations.count(query,"person");
    }
}
