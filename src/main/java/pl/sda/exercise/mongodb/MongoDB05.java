package pl.sda.exercise.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Exercise 05: get books sorted by title
 */
public class MongoDB05 extends MongoConnection {

	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient(new MongoClientURI(CONNECTIONSTRING));
		MongoDatabase database = mongoClient.getDatabase("books");
		MongoCollection<Document> collection = database.getCollection("books");

		//wyszukujemy o srtujemy
		collection.find().sort(Sorts.ascending("title"))
				.forEach((Block<Document>) document -> System.out.println(document.toJson()));


		mongoClient.close();
	}

}
