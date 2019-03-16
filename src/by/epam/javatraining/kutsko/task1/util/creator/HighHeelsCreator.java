package by.epam.javatraining.kutsko.task1.util.creator;

import by.epam.javatraining.kutsko.task1.model.entity.HighHeels;
import by.epam.javatraining.kutsko.task1.model.entity.type.*;

public class HighHeelsCreator implements AbstractCreator {
	
	public HighHeels create(Object... objects) {
		double price = (double) objects[1];
		Material material = (Material) objects[2];
		boolean selected = (boolean) objects[3];
		Color color = (Color) objects[4];
		int size = (int) objects[5];
		float heelHeight = (float) objects[6];
		return new HighHeels(price, material, selected, color, size, heelHeight);
	}
}
