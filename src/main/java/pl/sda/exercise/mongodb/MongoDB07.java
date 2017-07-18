package pl.sda.exercise.mongodb;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Exercise 07: create collection people
 */
public class MongoDB07 extends MongoConnection {

	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient(new MongoClientURI(CONNECTIONSTRING));
		MongoDatabase database = mongoClient.getDatabase("books");

		//tworzymy nowa kolekcje
		//database.createCollection("people");

		//pobieramy kolekcje, a jesli nie istnieje to utworzy
		MongoCollection<Document> collectionPeople2 = database.getCollection("people2");

		//dodajemy dokument
		Document doc = new Document();
		doc.put("jakies_pole", "jakas_wartosc");
		collectionPeople2.insertOne(doc);

		//listujemy kolekcje
		System.out.println("WSZYSTKIE KOLEKCJE");
		database.listCollections().forEach(new Block<Document>() {

			@Override
			public void apply(Document t) {
				// TODO Auto-generated method stub
				System.out.println(t.toJson());
			}});

		//listujemy dokuemnty z people2
		System.out.println("DOKUMENTY Z PEOPLE2");
		collectionPeople2.find().forEach(new Block<Document>() {

			@Override
			public void apply(Document t) {
				// TODO Auto-generated method stub
				System.out.println(t.toJson());
			}});


		mongoClient.close();
	}

}
