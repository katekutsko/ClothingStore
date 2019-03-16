package by.epam.javatraining.kutsko.task1.model.entity;

import java.io.Serializable;

import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptParameterReferenceException;

public class Accessory extends Item implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	private Season season;
	
	public enum Season {
		WINTER, DEMI_SEASON, ANY
	}
	
	public Accessory() {
		super();
		season = Season.ANY;
	}
	
	public Accessory(double price, Material material, boolean selected, Color color, Season season) {
		super(price, material, selected, color);
		this.season = season;
	}

	public Accessory(Accessory item) {
		super(item);
		this.season = item.season;
	}
	
	public void setSeason(Accessory.Season season) throws CorruptParameterReferenceException {
		if (season != null) {
			this.season = season;
		} else {
			throw new CorruptParameterReferenceException("Parameter reference was null");
		}
	}
	
	public Accessory.Season getSeason() {
		return season;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result += ((season == null) ? 1 : season.hashCode());
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
		Accessory other = (Accessory) obj;
		if (season != other.season)
			return false;
		return true;
	}
	
	@Override
	public Object clone() {
		Item item = (Item) super.clone();
		Accessory accessory = new Accessory(item.getPrice(), item.getMaterial(), item.isSelected(), item.getColor(), season);
		return accessory;
	}
	
	@Override 
	public String toString() {
		return "season: " + season.toString().toLowerCase() + super.toString();
	}

}
