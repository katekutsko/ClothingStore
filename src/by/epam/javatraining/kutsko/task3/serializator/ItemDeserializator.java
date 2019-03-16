package by.epam.javatraining.kutsko.task3.serializator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class ItemDeserializator {
	public static Item read(String fileName) {
		Item item = null;

		try (ObjectInputStream stream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
			item = (Item) stream.readObject();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
		
		return item;
	}
}
