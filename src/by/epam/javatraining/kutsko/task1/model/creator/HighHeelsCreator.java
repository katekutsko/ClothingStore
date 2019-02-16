package by.epam.javatraining.kutsko.task1.model.creator;

import by.epam.javatraining.kutsko.task1.model.entity.HighHeels;

public class HighHeelsCreator implements AbstractCreator {
	public HighHeels create(Object... objects) {
		return new HighHeels(objects);
	}
}
