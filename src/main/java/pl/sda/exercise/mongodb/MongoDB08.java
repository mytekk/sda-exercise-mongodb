package pl.sda.exercise.mongodb;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoNamespace;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Exercise 08: update collection persons to people
 */
public class MongoDB08 extends  MongoConnection {

	public static void main(String[] args) {


		MongoClient mongoClient = new MongoClient(new MongoClientURI(CONNECTIONSTRING));
		MongoDatabase database = mongoClient.getDatabase("books");

		MongoCollection<Document> collection = database.getCollection("people2");

		//zmiana nazwy kolekcji
		//drugi argument co nowa nazwa
		//pierwszy argument to nazwa bazy danych - jeslipodam ja inna (ale istniejaca)
		//to kolekcja people2 nie dosc, ze zmieni nazwe, to zostanie jeszcze przeniesiona do innej
		//bazy danych
		collection.renameCollection(new MongoNamespace("books", "people3"));


		mongoClient.close();
	}

}
