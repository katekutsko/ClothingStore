package by.epam.javatraining.kutsko.task1.model.creator;

import by.epam.javatraining.kutsko.task1.model.entity.HighHeels;
import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class HighHeelsCreator implements AbstractCreator {
	public HighHeels create(Object... objects) {
		double price = (double) objects[1];
		Item.Material material = (Item.Material) objects[2];
		boolean selected = (boolean) objects[3];
		Item.Color color = (Item.Color) objects[4];
		int size = (int) objects[5];
		float heelHeight = (float) objects[6];
		return new HighHeels(price, material, selected, color, size, heelHeight);
	}
}
