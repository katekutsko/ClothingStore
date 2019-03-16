package by.epam.javatraining.kutsko.task3.entity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import by.epam.javatraining.kutsko.task1.model.exception.InvalidItemPriceException;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptParameterReferenceException;

/**
 * This class is designed as an abstraction for items of a clothing store.
 * 
 * @version 1.0 14 Feb 2019
 * @author Kate Kutsko
 */
public class Item implements Comparable<Item>, Externalizable {

	private double price;

	private Material material;

	private boolean selected;

	private Color color;

	public enum Material {
		WOOL, LEATHER, POLIESTER, COTTON, VISCOSE, SILK, OTHER
	}

	public enum Color {
		WHITE, BLACK, RED, BLUE, GREEN, BROWN, PINK, GREY, MULTI
	}

	/**
	 * Default constructor for class Item
	 */
	public Item() {
		super();
		this.price = 0;
		this.material = Material.OTHER;
		this.selected = false;
		this.color = Color.MULTI;
	}

	/**
	 * Parametrized constructor. Accepts all parameters for items in specified order
	 * 
	 * @param price    price of the item
	 * @param material material the item is made of
	 * @param selected shows whether the item was selected
	 * @param color    color of the item
	 */
	public Item(double price, Material material, boolean selected, Color color) {
		this.price = price;
		this.material = material;
		this.selected = selected;
		this.color = color;
	}

	/**
	 * Copying constructor, accepts item to be copied.
	 * 
	 * @param item template for copying
	 */
	public Item(Item item) {
		this();
		if (item != null) {
			this.price = item.getPrice();
			this.material = item.getMaterial();
			this.selected = item.isSelected();
			this.color = item.getColor();
		}
	}

	/**
	 * @return Price of the item
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price price to be set
	 * @throws InvalidItemPriceException is thrown when price is negative
	 */
	public void setPrice(double price) throws InvalidItemPriceException {
		if (price > 0) {
			this.price = price;
		} else {
			throw new InvalidItemPriceException("Price must not be a negative number");
		}
	}

	/**
	 * @return material of the item
	 */
	public Material getMaterial() {
		return material;
	}

	/**
	 * @param material material to be set
	 * @throws CorruptParameterReferenceException
	 */
	public void setMaterial(Material material) throws CorruptParameterReferenceException {
		if (material != null) {
			this.material = material;
		} else {
			throw new CorruptParameterReferenceException("Parameter reference was null");
		}
	}

	/**
	 * @return indicator that shows if item is selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected indicator that shows if item is selected
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * @return color of the item
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * 
	 * @param color color to be set
	 * @throws CorruptParameterReferenceException
	 */
	public void setColor(Color color) throws CorruptParameterReferenceException {
		if (color != null) {
			this.color = color;
		} else {
			throw new CorruptParameterReferenceException("Parameter reference was null");
		}
	}

	@Override
	public boolean equals(Object otherItem) {
		if (this == otherItem) {
			return true;
		}
		if (otherItem == null) {
			return false;
		}
		if (getClass() != otherItem.getClass()) {
			return false;
		}
		Item item = (Item) otherItem;
		if ((item.price != price) || (item.selected != selected) || (item.color != color)
				|| (item.material != material)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result += (int) (temp >>> 32);
		result += prime * (selected ? 1231 : 1237);
		result += (material == null ? 0 : material.hashCode());
		result += (color == null ? 0 : color.hashCode());
		return result;
	}

	public int compareTo(Item secondItem) {
		return Double.compare(getPrice(), secondItem.getPrice());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		try {
			setPrice(in.readDouble());
		} catch (InvalidItemPriceException e) {
		}
		try {
			setMaterial(Material.valueOf(in.readUTF()));
			setSelected(in.readBoolean());
			setColor(Color.valueOf(in.readUTF()));
		} catch (CorruptParameterReferenceException e) {
		} catch (IllegalArgumentException ex) {
		}
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeDouble(price);
		out.writeUTF(material.name());
		out.writeBoolean(selected);
		out.writeUTF(color.name());
	}

	@Override
	public String toString() {
		return ", price: " + price + ", material: " + material.toString().toLowerCase() + ", color: "
				+ color.toString().toLowerCase() + ", selected: " + selected;
	}
}
