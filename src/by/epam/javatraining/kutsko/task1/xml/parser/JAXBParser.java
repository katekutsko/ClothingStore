package by.epam.javatraining.kutsko.task1.util.xml.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;

public class JAXBParser {
	public static void parse() {
		try {
			JAXBContext jc = JAXBContext.newInstance(ClothingStore.class);
			Unmarshaller u = jc.createUnmarshaller();
			FileReader reader = new FileReader("resource/clothing.xml");
			ClothingStore items = (ClothingStore) u.unmarshal(reader);
			System.out.println(items);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
