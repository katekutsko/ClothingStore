package by.epam.javatraining.kutsko.task1.model.creator;

import by.epam.javatraining.kutsko.task1.model.entity.Jumper;

public class JumperCreator implements AbstractCreator {
	public Jumper create(Object... objects) {
		return new Jumper(objects);
	}
}
