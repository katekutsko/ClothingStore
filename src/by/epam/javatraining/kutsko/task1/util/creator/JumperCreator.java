package by.epam.javatraining.kutsko.task1.util.creator;

import by.epam.javatraining.kutsko.task1.model.entity.*;
import by.epam.javatraining.kutsko.task1.model.entity.type.*;

public class JumperCreator implements AbstractCreator {
	
	public Jumper create(Object... objects) {
		double price = (double) objects[1];
		Material material = (Material) objects[2];
		boolean selected = (boolean) objects[3];
		Color color = (Color) objects[4];
		Clothing.Size size = (Clothing.Size) objects[5];
		Jumper.Type type = (Jumper.Type) objects[6];
		return new Jumper(price, material, selected, color, size, type);
	}
}
