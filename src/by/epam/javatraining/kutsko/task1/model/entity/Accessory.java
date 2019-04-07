package by.epam.javatraining.kutsko.task1.model.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

import by.epam.javatraining.kutsko.task1.model.entity.consts.ItemData;
import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptParameterReferenceException;

@XmlType(name = "Accessory", propOrder = { "season" })
public class Accessory extends Item implements Serializable, Cloneable {
	@XmlTransient
	private static final long serialVersionUID = 1L;

	@XmlElement(required = true, name = "season")
	private Season season;

	@XmlEnum(String.class)
	public enum Season {
		@XmlEnumValue(value = "WINTER")
		WINTER, @XmlEnumValue(value = "DEMI_SEASON")
		DEMI_SEASON, @XmlEnumValue(value = "ANY")
		ANY
	}

	public Accessory() {
		super();
		season = Season.ANY;
	}

	public Accessory(double price, Material material, boolean selected, Color color, String ID, Season season) {
		super(price, material, selected, color, ID);
		this.season = season;
	}

	public Accessory(Accessory item) {
		super(item);
		this.season = item.season;
	}

	public void setSeason(Accessory.Season season) {
		if (season != null) {
			this.season = season;
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
		Accessory accessory = new Accessory(item.getPrice(), item.getMaterial(), item.isSelected(), item.getColor(),
				item.getID(), season);
		return accessory;
	}

	@Override
	public String toString() {
		return ItemData.SEASON + ": " + ItemData.getLocalisedString(season.toString().toLowerCase()) + super.toString();
	}

}
