package pl.sda.exercise.mongodb.block;

import org.bson.Document;

import com.mongodb.Block;

public class DocumentPrintlnBlock implements Block<Document> {

	@Override
	public void apply(Document document) {
		System.out.println(document.toJson());
	}

}
