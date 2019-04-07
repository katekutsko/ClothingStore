package by.epam.javatraining.kutsko.task1.model.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

import by.epam.javatraining.kutsko.task1.model.entity.consts.ItemData;
import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.model.exception.InvalidShoeSizeException;

@XmlType(name = "Shoes")
public class Shoes extends Item implements Serializable, Cloneable {
	@XmlTransient
	private static final long serialVersionUID = 1L;

	@XmlElement(required = true, name = "shoesize")
	private int shoeSize;

	public Shoes() {
		super();
		shoeSize = 37;
	}

	public Shoes(double price, Material material, boolean selected, Color color, String ID, int size) {
		super(price, material, selected, color, ID);
		this.shoeSize = size;
	}

	public Shoes(Shoes item) {
		super(item);
		if (item != null) {
			shoeSize = item.shoeSize;
		}
	}

	public int getSize() {
		return shoeSize;
	}

	public void setSize(int size) {
		if (size > 35 && size < 45) {
			this.shoeSize = size;
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
		if (shoeSize != other.shoeSize) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode() + prime * shoeSize;
		return result;
	}

	@Override
	public Object clone() {
		Item item = (Item) super.clone();
		Shoes shoes = new Shoes(item.getPrice(), item.getMaterial(), item.isSelected(), item.getColor(), item.getID(),
				shoeSize);
		return shoes;
	}

	@Override
	public String toString() {
		return ItemData.SIZE + ": " + shoeSize + super.toString();
	}
}
