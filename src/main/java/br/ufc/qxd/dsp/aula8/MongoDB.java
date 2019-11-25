package br.ufc.qxd.dsp.aula8;

import br.ufc.qxd.dsp.aula8.model.User;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDB {

    public static void exemplo01(MongoClient mongoClient) {
        for(String nameDB: mongoClient.listDatabaseNames())
            System.out.println(nameDB);
    }

    public static void exemplo02(MongoClient mongoClient) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("dsp");
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("users");

        mongoCollection.insertOne(new User("Mauricio", "mcavalcante@outlook.com", 25).toDocument());
    }

    public static void exemplo03(MongoClient mongoClient) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("dsp");
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("users");

        List<Document> docs = new ArrayList<>();

        docs.add(new User("Marcelo", "fmarcelo@bol.com", 20).toDocument());
        docs.add(new User("Ravache", "jmravache@uol.com", 20).toDocument());

        mongoCollection.insertMany(docs);
    }

    public static void exemplo04(MongoClient mongoClient) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("dsp");
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("users");

        for(Document doc: mongoCollection.find()) {
            User user = new User(doc);
            System.out.println(user);
        }
    }

    public static void exemplo05(MongoClient mongoClient) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("dsp");
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("users");

        for(Document doc: mongoCollection.find(Document.parse("{name: 'Mauricio'}"))) {
            User user = new User(doc);
            System.out.println(user);
        }
    }

    public static void exemplo06(MongoClient mongoClient) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("dsp");
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("users");

        mongoCollection.updateOne(Document.parse("{name: 'Gabriel'}"), Document.parse("{$set: {age: 23}}"));
    }

    public static void exemplo07(MongoClient mongoClient) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("dsp");
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("users");

        mongoCollection.deleteOne(Document.parse("{name: 'Marcelo'}"));
    }

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost");

//        exemplo01(mongoClient);
//        exemplo02(mongoClient);
//        exemplo03(mongoClient);
        exemplo04(mongoClient);
//        exemplo05(mongoClient);
//        exemplo06(mongoClient);
//        exemplo07(mongoClient);

        mongoClient.close();

        System.out.println("FIM - Mongo");

    }

}
