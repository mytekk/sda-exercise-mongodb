package pl.sda.exercise.mongodb;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Exercise 02: get all books
 */
public class MongoDB02 extends MongoConnection {

	public static void main(String[] args) {

		//podlaczamy sie do serwera
		MongoClient mongoClient = new MongoClient(new MongoClientURI(CONNECTIONSTRING));

		//podlaczamy sie do bazy danych
		MongoDatabase database = mongoClient.getDatabase("books");

		//podłączamy sie do kolekcji books
		MongoCollection<Document> collection = database.getCollection("books");

		//wyszukanie wszystkich dokumentow z kolekcji wypisanie ich
		collection.find().forEach(new Block<Document>() {
			@Override
			public void apply(Document document) {
				System.out.println(document.toJson());
			}
		});


		mongoClient.close();
	}

}
