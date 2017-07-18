package pl.sda.exercise.mongodb;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 * Exercise 12: delete person
 */
public class MongoDB12 extends MongoConnection {

	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient(new MongoClientURI(CONNECTIONSTRING));
		MongoDatabase database = mongoClient.getDatabase("books");

		MongoCollection<Document> collection = database.getCollection("people3");

		//listuje dokumenty przed usunieciem
		System.out.println("Przed usunieciem:");
		collection.find().forEach((Block<Document>) document1 -> System.out.println(document1.toJson()) );

		//usuwanie
		//usuwanie pierwszego znalezionego
		//collection.deleteOne(Filters.eq("firstName", "Janek"));
		//usuwanie wszystkich pasujacych do filtra
		collection.deleteMany(Filters.eq("firstName", "Janek"));

		//listuje dokumenty po usunieciu
		System.out.println("Po usunieciu:");
		collection.find().forEach((Block<Document>) document1 -> System.out.println(document1.toJson()) );

		mongoClient.close();
	}

}
