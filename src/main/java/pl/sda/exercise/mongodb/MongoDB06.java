package pl.sda.exercise.mongodb;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 * Exercise 06: get books with only title
 */
public class MongoDB06 extends MongoConnection {

	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient(new MongoClientURI(CONNECTIONSTRING));
		MongoDatabase database = mongoClient.getDatabase("books");
		MongoCollection<Document> collection = database.getCollection("books");

		//wyszukujemy a wczesniejza pomoca Projekcji okreslamy, ktore pola maja byc wyswietlone, a ktore nie
		//Projections - to fabryka, ktora sluzy do tworz4enia innych obiektow
		//Filters i <cos tam> to tez fabryki
		Bson myInclude = Projections.include("title");
		Bson myExclude = Projections.excludeId();
		collection.find().projection(Projections.fields(myInclude,myExclude))
				.forEach((Block<Document>) document -> System.out.println(document.toJson()));


		mongoClient.close();
	}

}
