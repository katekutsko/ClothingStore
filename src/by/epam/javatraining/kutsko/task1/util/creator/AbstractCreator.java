package by.epam.javatraining.kutsko.task1.util.creator;

import by.epam.javatraining.kutsko.task1.model.entity.Item;

public interface AbstractCreator {
	Item create(Object... paramaters);
}
