package by.epam.javatraining.kutsko.task1.model.entity;

import by.epam.javatraining.kutsko.task1.exception.InvalidArgumentException;
import by.epam.javatraining.kutsko.task1.exception.NonexistentArgumentException;

/**
 * This class is designed as an abstraction for items of a clothing store.
 * 
 * @version		1.0 14 Feb 2019
 * @author		Kate Kutsko
 */
public abstract class Item {
	
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
	
	public Item() {
		super();
		this.price = 0;
		this.material = Material.OTHER;
		this.selected = false;
		this.color = Color.MULTI;
	}
	
	public Item(double price, Material material, boolean selected, Color color) {
		super();
		/* setPrice(price);
		   setDiscount(discount); */
		this.price = price;
		this.material = material;
		this.selected = selected;
		this.color = color;
	}
	
	public Item(Item item) {
		this.price = item.getPrice();
		this.material = item.getMaterial();///////////////////////////////////////////////////////////////////////////
		this.selected = item.isSelected();
		this.color = item.getColor();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws InvalidArgumentException {
		if (price > 0) {
		this.price = price;
		} else {
			throw new InvalidArgumentException("Price must not be a negative number", price);
		}
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) throws NonexistentArgumentException {
		if (material != null) {
			this.material = material;
		} else {
			throw new NonexistentArgumentException("Material is unidentified");
		}
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) throws NonexistentArgumentException {
		if (color != null) {
			this.color = color;
		} else {
			throw new NonexistentArgumentException("Color is unidentified");
		}
	}

	@Override
	public String toString() {
		return ", price: " + price + ", material: " + material.toString().toLowerCase() 
				+ ", color: " + color.toString().toLowerCase()+ ", selected: " + selected;
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
		if (otherItem.hashCode() != this.hashCode()) {
			return false;
		}
		Item item = (Item) otherItem;
		if ((item.price != price) || (item.selected != selected)
		|| (item.color != color) || (item.material != material)) {
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
		result += prime * (int) (temp >>> 32);
		result += prime * (selected ? 1231 : 1237);
		result += (material == null ? 0 : material.hashCode());
		result += (color == null ? 0 : color.hashCode());
		return result;
	}
	
}
