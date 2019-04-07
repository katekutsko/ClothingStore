package by.epam.javatraining.kutsko.task1.model.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

import by.epam.javatraining.kutsko.task1.model.entity.consts.ItemData;
import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptParameterReferenceException;

@XmlRootElement(name="jumper")
@XmlType(name="Jumper")
public class Jumper extends Clothing implements Serializable, Cloneable {
	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="jumpertype", required = true)
	private Type jumperType;
	
	@XmlType(name="JType")
	@XmlEnum(String.class)
	public enum Type {
		SWEATER, PULLOVER, SWEATSHOT, TUNIC, HOODY, OTHER
	}
	
	public Jumper() {
		super();
		jumperType = Type.OTHER;
	}

	public Jumper(Object... parameters) {
		this((Double) parameters[0], (Material) parameters[1], (Boolean) parameters[2], (Color) parameters[3], (String) parameters[4], (Size) parameters[5], (Type) parameters[6]);
	}
	
	public Jumper(double price, Material material, boolean selected, Color color, String ID, Size size, Type type) {
		super(price, material, selected, color, ID, size);
		this.jumperType = type;
	}

	public Jumper(Jumper item) {
		super(item);
		this.jumperType = item.jumperType;
	}

	public Type getType() {
		return jumperType;
	}

	public void setType(Type type) {
		if (type != null) {
			this.jumperType = type;
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
		if (jumperType != other.jumperType)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((jumperType == null) ? 0 : jumperType.hashCode());
		return result;
	}
	
	@Override
	public Object clone() {
		Clothing item = (Clothing) super.clone();
		Jumper clothing = new Jumper(item.getPrice(), item.getMaterial(), item.isSelected(), item.getColor(), item.getSize(), jumperType);
		return clothing;
	}
	
	@Override
	public String toString() {
		return  "\n" + ItemData.JUMPER + "\n" + ItemData.TYPE + ": " + ItemData.getLocalisedString(jumperType.toString().toLowerCase()) + super.toString();
	}
}
