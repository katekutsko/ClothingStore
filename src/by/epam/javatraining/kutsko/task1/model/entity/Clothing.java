package by.epam.javatraining.kutsko.task1.model.entity;

import java.io.Serializable;

import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptParameterReferenceException;

/**
 * This class is an abstraction of clothing items.
 * 
 * @version		1.0 14 Feb 2019
 * @author		Kate Kutsko
 */
public class Clothing extends Item implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	private Size size;
	
	public enum Size {
		XXS, XS, S, M, L, XL, XXL
	}
	
	public Clothing() {
		super();
		size = Size.M;
	}

	/**
	 * @param price Price of one unit of goods
	 * @param material Main material for production
	 * @param selected Shows whether the item was put into shopping basket
	 * @param color Color of the item
	 * @param size Size of the clothing item
	 */
	public Clothing(double price, Material material, boolean selected, Color color, Size size) {
		super(price, material, selected, color);
		this.size = size;
	}

	/**
	 * @param item Item to copy
	 */
	public Clothing(Clothing item) {
		super(item);
		this.size = item.size;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) throws CorruptParameterReferenceException {
		if (size != null) {
			this.size = size;
		} else {
			throw new CorruptParameterReferenceException("Parameter reference was null");
		}
	}


	@Override
	public int hashCode() {
		int result = super.hashCode();
		result += ((size == null) ? 0 : size.hashCode());
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
		if (size != other.size)
			return false;
		return true;
	}
	
	@Override
	public Object clone() {
		Item item = (Item) super.clone();
		Clothing clothing = new Clothing(item.getPrice(), item.getMaterial(), item.isSelected(), item.getColor(), size);
		return clothing;
	}
	
	@Override
	public String toString() {
		return (super.toString() + ", size: " + size);
	}
}
