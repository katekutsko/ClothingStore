package by.epam.javatraining.kutsko.task1.model.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

import by.epam.javatraining.kutsko.task1.model.entity.consts.ItemData;
import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptParameterReferenceException;

@XmlRootElement(name="scarf")
@XmlType(name="Scarf")
public class Scarf extends Accessory implements Serializable, Cloneable {

	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	@XmlElement(required = true, name = "scarftype")
	private Type scarfType;

	@XmlType(name="SType")
	@XmlEnum(String.class)
	public enum Type {
		//@XmlEnumValue(value="THIN")
		THIN, 
		//@XmlEnumValue(value="CHUNKY")
		CHUNKY, 
		//@XmlEnumValue(value="LOOP")
		LOOP, 
		//@XmlEnumValue(value="OTHER")
		OTHER
	}

	public Scarf() {
		super();
		scarfType = Type.OTHER;
	}

	public Scarf(Object... parameters) {
		this((Double) parameters[0], (Material) parameters[1], (Boolean) parameters[2], (Color) parameters[3],
				(String) parameters[4], (Season) parameters[5], (Type) parameters[6]);
	}

	public Scarf(double price, Material material, boolean selected, Color color, String ID, Season season, Type type) {
		super(price, material, selected, color, ID, season);
		this.scarfType = type;
	}

	public Scarf(Scarf item) {
		super(item);
		this.scarfType = item.scarfType;
	}

	public void setType(Type type){
		if (type != null) {
			this.scarfType = type;
		}
	}

	public Type getType() {
		return scarfType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((scarfType == null) ? 0 : scarfType.hashCode());
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
		Scarf other = (Scarf) obj;
		if (scarfType != other.scarfType)
			return false;
		return true;
	}

	@Override
	public Object clone() {
		Accessory item = (Accessory) super.clone();
		Scarf scarf = new Scarf(item.getPrice(), item.getMaterial(), item.isSelected(), item.getColor(),
				item.getSeason(), scarfType);
		return scarf;
	}

	@Override
	public String toString() {
		return "\n" + ItemData.SCARF + "\n" + super.toString() + ", " + ItemData.TYPE +  ": " + ItemData.getLocalisedString(scarfType.toString().toLowerCase());
	}
}
