package by.epam.javatraining.kutsko.task1.model.creator;

import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class Creator {
	
	public static Item getItem(AbstractCreator creator, Object... parameters) {
		return creator.create(parameters);
	}
}
