package by.epam.javatraining.kutsko.task1.model.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

import by.epam.javatraining.kutsko.task1.model.entity.consts.ItemData;
import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptParameterReferenceException;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Clothing")
/**
 * This class is an abstraction of clothing items.
 * 
 * @version		1.0 14 Feb 2019
 * @author		Kate Kutsko
 */
public class Clothing extends Item implements Serializable, Cloneable {
	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	@XmlElement(required = true, name = "clothingsize")
	private Size clothingSize;
	
	@XmlEnum(String.class)
	public enum Size {
		@XmlEnumValue(value = "XXS")XXS, 
		@XmlEnumValue(value = "XS")XS,
		@XmlEnumValue(value = "S")S, 
		@XmlEnumValue(value = "M")M, 
		@XmlEnumValue(value = "L")L, 
		@XmlEnumValue(value = "XL")XL, 
		@XmlEnumValue(value = "XXL")XXL
	}
	
	public Clothing() {
		super();
		clothingSize = Size.M;
	}

	/**
	 * @param price Price of one unit of goods
	 * @param material Main material for production
	 * @param selected Shows whether the item was put into shopping basket
	 * @param color Color of the item
	 * @param size Size of the clothing item
	 * @param ID model of the item
	 */
	public Clothing(double price, Material material, boolean selected, Color color, String ID, Size size) {
		super(price, material, selected, color, ID);
		this.clothingSize = size;
	}

	/**
	 * @param item Item to copy
	 */
	public Clothing(Clothing item) {
		super(item);
		this.clothingSize = item.clothingSize;
	}

	public Size getSize() {
		return clothingSize;
	}

	public void setSize(Size size) {
		if (size != null) {
			this.clothingSize = size;
		} 
	}


	@Override
	public int hashCode() {
		int result = super.hashCode();
		result += ((clothingSize == null) ? 0 : clothingSize.hashCode());
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
		Clothing other = (Clothing) obj;
		if (clothingSize != other.clothingSize)
			return false;
		return true;
	}
	
	@Override
	public Object clone() {
		Item item = (Item) super.clone();
		Clothing clothing = new Clothing(item.getPrice(), item.getMaterial(), item.isSelected(), item.getColor(), item.getID(), clothingSize);
		return clothing;
	}
	
	@Override
	public String toString() {
		return (super.toString() + ", " + ItemData.SIZE + ": " + clothingSize);
	}
}
