package by.epam.javatraining.kutsko.task3.serializator;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class ItemSerializator {
	public static void write(String fileName, Item item) {
		try (ObjectOutputStream stream = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(fileName)))) {
			stream.writeObject(item);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
}
