package by.epam.javatraining.kutsko.task1.model.entity;

import java.io.Serializable;

import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.model.exception.InvalidHeelHeightException;

public class HighHeels extends Shoes implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private float heelHeight;
	
	public HighHeels() {
		super();
		heelHeight = 0;
	}
	
	public HighHeels(double price, Material material, boolean selected, Color color, int size, float heelHeight) {
		super(price, material, selected, color, size);
		this.heelHeight = heelHeight;
	}

	public HighHeels(HighHeels item) {
		super(item);
		this.heelHeight = item.heelHeight;
	}

	public float getHeelHeight() {
		return heelHeight;
	}

	public void setHeelHeight(float heelHeight) throws InvalidHeelHeightException {
		if (heelHeight >= 0 && heelHeight <= 20) {
			this.heelHeight = heelHeight;
		} else {
			throw new InvalidHeelHeightException("Heel height must be from 0 to 20 cm");
		}
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(heelHeight);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		HighHeels other = (HighHeels) obj;
		if (Float.floatToIntBits(heelHeight) != Float.floatToIntBits(other.heelHeight))
			return false;
		return true;
	}
	
	@Override
	public Object clone() {
		Shoes item = (Shoes) super.clone();
		HighHeels shoes = new HighHeels(item.getPrice(), item.getMaterial(), item.isSelected(), item.getColor(), item.getSize(), heelHeight);
		return shoes;
	}
	
	
	@Override
	public String toString() {
		return "HighHeels\n" + super.toString() + ", heel height: " + heelHeight;
	}
}
