package mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;
import java.util.Date;

public class TestMongo {
    public static void main(String[] args) {
        //MongoClient mongoClient = new MongoClient("localhost", 27017);
        //MongoDatabase mgdb = mongoClient.getDatabase("mlmp");
        //System.out.println("Connect to database successfully!");
        //System.out.println("MongoDatabase inof is : "+mgdb.getName());

        String user = "mlmpopr"; // the user name
        String database = "mlmp"; // the name of the database in which the user is defined
        char[] password = "paic1234".toCharArray(); // the password as a character array
// ...
        MongoCredential credential = MongoCredential.createCredential(user, database, password);
        MongoClient mongoClient1 = new MongoClient(new ServerAddress("localhost", 27017),
                Arrays.asList(credential));


        MongoDatabase mdb = mongoClient1.getDatabase("mlmp");
        System.out.println("[sync_mdb]" + mdb.getCollection("sync_mdb").count());

        mdb.createCollection("java_mdb");
        Document document = new Document().append("name","张三").
                                           append("created_date",new Date());
        mdb.getCollection("java_mdb").insertOne(document);
        System.out.println("[java_mdb]" + mdb.getCollection("java_mdb").find().toString());

    }
}
