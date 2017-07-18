package pl.sda.exercise.mongodb;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Exercise 09: delete collection people
 */
public class MongoDB09 extends MongoConnection {

	public static void main(String[] args) {


		MongoClient mongoClient = new MongoClient(new MongoClientURI(CONNECTIONSTRING));
		MongoDatabase database = mongoClient.getDatabase("books");

		System.out.println("Kolekcje przed usunieciem");
		database.listCollections().forEach((Block<Document>) document -> System.out.println(document.toJson()));

		//tworze i usuwam kolekcje
		MongoCollection<Document> movies = database.getCollection("movies");
		movies.drop();

		System.out.println("Kolekcje po usunieciem");
		database.listCollections().forEach((Block<Document>) document -> System.out.println(document.toJson()));

		mongoClient.close();
	}

}
