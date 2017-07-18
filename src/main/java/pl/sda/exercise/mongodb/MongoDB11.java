package pl.sda.exercise.mongodb;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

/**
 * Exercise 11: update person
 */
public class MongoDB11 extends MongoConnection {

	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient(new MongoClientURI(CONNECTIONSTRING));
		MongoDatabase database = mongoClient.getDatabase("books");

		MongoCollection<Document> collection = database.getCollection("people3");

		//dodaje dokument do kolekcji
		Document document = new Document();
		document.put("firstName", "Jan");
		document.put("lastName", "Kowalski");
		collection.insertOne(document);

		//listuje dokumenty po insercie
        System.out.println("Przed zmiana:");
        collection.find().forEach((Block<Document>) document1 -> System.out.println(document1.toJson()) );

		//zmieniamy dokument
        //zmiana perwszego pasujacego do filtradokumentu
        //collection.updateOne(Filters.eq("firstName", "Jan"), Updates.set("firstName", "Janek"));
        //zmiana wszystkich pasujacychdo filtra dokumentow
        collection.updateMany(Filters.eq("firstName", "Jan"), Updates.set("firstName", "Janek"));

        //listuje dokumenty po zmianie
        System.out.println("Po zmianie:");
        collection.find().forEach((Block<Document>) document1 -> System.out.println(document1.toJson()) );

        mongoClient.close();

	}

}
