package pl.sda.exercise.mongodb;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 * Exercise 03: get books by title
 */
public class MongoDB03 extends MongoConnection {

	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient(new MongoClientURI(CONNECTIONSTRING));
		MongoDatabase database = mongoClient.getDatabase("books");
		MongoCollection<Document> collection = database.getCollection("books");

		//wyszukanie wszystkich dokumentow z kolekcji o zadanym tytule
        //dokladnie rowny tytulowi
		//collection.find(Filters.eq("title", "Pinokio")).forEach(new Block<Document>() {
        //lub po wyrazeniu regularnym
        collection.find(Filters.regex("title", "Pinok.*")).forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.println(document.toJson());
            }
        });


		mongoClient.close();
	}

}
