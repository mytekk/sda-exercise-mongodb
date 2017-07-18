package pl.sda.exercise.mongodb;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Exercise 01: get all collections
 */
public class MongoDB01 extends MongoConnection {

	public static void main(String[] args) {
		//TODO

		//podlaczamy sie do serwera
		MongoClient mongoClient = new MongoClient(new MongoClientURI(CONNECTIONSTRING));

		//podlaczamy sie do bazy danych
		MongoDatabase database = mongoClient.getDatabase("books");

		//pobieramy liste kolejkcji z bazy
		ListCollectionsIterable<Document> listCollections = database.listCollections();

		//listujemy kolekcje z bazy danych
		//nowa instancja interfejsu block, pozwala na wykonywanie operacji na elementach MongoDB
		listCollections.forEach(new Block<Document>() {
			@Override
			public void apply(Document document) {
				//System.out.println(document.toJson());
				System.out.println(document.get("name"));
			}
		});

		mongoClient.close();
	}

}
