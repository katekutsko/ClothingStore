package by.epam.javatraining.kutsko.task1.model.entity;

import by.epam.javatraining.kutsko.task1.exception.*;

public abstract class Shoes extends Item {

	private short size;
	
	public Shoes() {
		super();
		size = 37;
	}

	public Shoes(double price, Material material, boolean selected, Color color, short size) {
		super(price, material, selected, color);
		this.size = size;
	}

	public Shoes(Shoes item) {
		super(item);
		size = item.size;
	}

	public short getSize() {
		return size;
	}
	
	public void setSize(short size) throws InvalidArgumentException {
		if (size < 35 || size > 45) {
			throw new InvalidArgumentException("Size " + size + " is not available.");
		}
	}

	@Override
	public String toString() {
		return ", size: " + size + super.toString();
	}
}
