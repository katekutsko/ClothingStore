package by.epam.javatraining.kutsko.task1.model.entity;

import by.epam.javatraining.kutsko.task1.model.exception.ClothingStoreLogicalException;
import by.epam.javatraining.kutsko.task1.model.exception.InvalidShoeSizeException;

public class Shoes extends Item {

	private int size;
	
	public Shoes() {
		super();
		size = 37;
	}

	public Shoes(double price, Material material, boolean selected, Color color, int size) {
		super(price, material, selected, color);
		this.size = size;
	}

	public Shoes(Shoes item) {
		super(item);
		size = item.size;
	}

	public int getSize() {
		return size;
	}
	
	public void setSize(int size) throws InvalidShoeSizeException {
		if (size > 35 && size < 45) {
			this.size = size;
		} else {
			throw new InvalidShoeSizeException("Size " + size + " is not available.");
		}
	}

	@Override 
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Shoes other = (Shoes) obj;
		if (size != other.size) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode() + prime * size;
		return result;
	}
	
	@Override
	public String toString() {
		return "size: " + size + super.toString();
	}
}
