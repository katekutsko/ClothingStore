package by.epam.javatraining.kutsko.task1.util.creator;

import by.epam.javatraining.kutsko.task1.model.entity.Accessory;
import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.entity.Scarf;

public class ScarfCreator implements AbstractCreator {
	public Scarf create(Object... objects) {
		double price = (double) objects[1];
		Item.Material material = (Item.Material) objects[2];
		boolean selected = (boolean) objects[3];
		Item.Color color = (Item.Color) objects[4];
		Accessory.Season season = (Accessory.Season) objects[5];
		Scarf.Type type = (Scarf.Type) objects[6];
		return new Scarf(price, material, selected, color, season, type);
	}
}
