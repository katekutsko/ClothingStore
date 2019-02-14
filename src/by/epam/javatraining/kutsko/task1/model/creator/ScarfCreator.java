package by.epam.javatraining.kutsko.task1.model.creator;

import by.epam.javatraining.kutsko.task1.model.entity.Scarf;

public class ScarfCreator implements AbstractCreator {
	public Scarf create() {
		return new Scarf();
	}
}
