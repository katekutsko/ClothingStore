package by.epam.javatraining.kutsko.task3.entity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import by.epam.javatraining.kutsko.task1.model.exception.InvalidHeelHeightException;

public class HighHeels extends Shoes implements Externalizable {

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
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		super.readExternal(in);
		heelHeight = in.readFloat();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		super.writeExternal(out);
		out.writeFloat(heelHeight);
	}
	
	@Override
	public String toString() {
		return "HighHeels\n" + super.toString() + ", heel height: " + heelHeight;
	}
}
