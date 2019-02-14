package by.epam.javatraining.kutsko.task1.model.entity;

import by.epam.javatraining.kutsko.task1.exception.NonexistentArgumentException;

public class Scarf extends Accessory {

	private Type type;
	
	public enum Type {
		THIN, CHUNKY, LOOP, OTHER
	}
	
	public Scarf() {
		super();
		type = Type.OTHER;
	}

	public Scarf(double price, Material material, boolean selected, Color color, Season season, Type type) {
		super(price, material, selected, color, season);
		this.type = type;
	}

	public Scarf(Scarf item) {
		super(item);
		this.type = item.type;
	}

	public void setType(Type type) throws NonexistentArgumentException {
		if (type != null) {
			this.type = type;
		} else {
			throw new NonexistentArgumentException("Type is unidentified");
		}
	}
	
	public Type getType() {
		return type;
	}
	
	@Override 
	public String toString() {
		return ("Scarf\ntype: " + type.toString().toLowerCase() + super.toString());
	}
}
