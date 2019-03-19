package by.epam.javatraining.kutsko.task1.model.entity;

import java.io.Serializable;

import by.epam.javatraining.kutsko.task1.model.entity.consts.ItemData;
import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptParameterReferenceException;

public class Jumper extends Clothing implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private Type type;
	
	public enum Type {
		SWEATER, PULLOVER, SWEATSHOT, TUNIC, HOODY, OTHER
	}
	
	public Jumper() {
		super();
		type = Type.OTHER;
	}

	public Jumper(Object... parameters) {
		this((Double) parameters[0], (Material) parameters[1], (Boolean) parameters[2], (Color) parameters[3], (Size) parameters[4], (Type) parameters[5]);
	}
	
	public Jumper(double price, Material material, boolean selected, Color color, Size size, Type type) {
		super(price, material, selected, color, size);
		this.type = type;
	}

	public Jumper(Jumper item) {
		super(item);
		this.type = item.type;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) throws CorruptParameterReferenceException {
		if (type != null) {
			this.type = type;
		} else {
			throw new CorruptParameterReferenceException("Parameter reference was null");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jumper other = (Jumper) obj;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
	@Override
	public Object clone() {
		Clothing item = (Clothing) super.clone();
		Jumper clothing = new Jumper(item.getPrice(), item.getMaterial(), item.isSelected(), item.getColor(), item.getSize(), type);
		return clothing;
	}
	
	@Override
	public String toString() {
		return ItemData.JUMPER + "\n" + ItemData.TYPE + ": " + ItemData.getLocalisedString(type.toString().toLowerCase()) + super.toString();
	}
}
