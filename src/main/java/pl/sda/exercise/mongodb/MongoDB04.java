package pl.sda.exercise.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Exercise 04: get book by id
 */
public class MongoDB04 extends MongoConnection {

	private static final String bookId = "596ccf473213161d246dff5d";

	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient(new MongoClientURI(CONNECTIONSTRING));
		MongoDatabase database = mongoClient.getDatabase("books");
		MongoCollection<Document> collection = database.getCollection("books");

		//tworzymy obiekt klasy BasicDBObject i nadajemy mu takie pola, o jakie bedzie nam
		//chodzilo w wyszukiwaniu
		//ten obiekt bedzie takim "wzorcem" do wyszukiwania
		BasicDBObject basicDBObject = new BasicDBObject();
		basicDBObject.put("_id", new ObjectId(bookId)); //nie mozemy wstrzyknac samego stringa,
		// bo id nie jest stringiem, tlyko obiektem (patrz jak to wyglada z bazie mongo:)
		// "_id" : ObjectId("596ccf233213161d246dff5b") -> to (wartosc pola) jest obiekt, a nie string!!!

		//teraz wyszukujemy - zoastapione wyrazeniem lambda, bo Block<Document> jest interfejsem z jedna metoda
		collection.find(basicDBObject).forEach((Block<Document>) document -> System.out.println(document.toJson()));


		mongoClient.close();
	}

}
