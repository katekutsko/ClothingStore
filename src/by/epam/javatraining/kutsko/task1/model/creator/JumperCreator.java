package by.epam.javatraining.kutsko.task1.model.creator;

import by.epam.javatraining.kutsko.task1.model.entity.Jumper;

public class JumperCreator implements AbstractCreator {
	public Jumper create() {
		return new Jumper();
	}
}
