package by.epam.javatraining.kutsko.task1.util.creator;

public enum CreatorFactory {
	
	HIGHHEELS(new HighHeelsCreator()), JUMPER(new JumperCreator()), SCARF(new ScarfCreator());
	
	private AbstractCreator creator;
	
	private CreatorFactory(AbstractCreator creator) {
		this.creator = creator;
	}
	
	public AbstractCreator getCreator() {
		return creator;
	}

}
