package by.epam.javatraining.kutsko.task1.util.creator;

import by.epam.javatraining.kutsko.task1.model.entity.*;

public class JumperCreator implements AbstractCreator {
	public Jumper create(Object... objects) {
		double price = (double) objects[1];
		Item.Material material = (Item.Material) objects[2];
		boolean selected = (boolean) objects[3];
		Item.Color color = (Item.Color) objects[4];
		Clothing.Size size = (Clothing.Size) objects[5];
		Jumper.Type type = (Jumper.Type) objects[6];
		return new Jumper(price, material, selected, color, size, type);
	}
}
