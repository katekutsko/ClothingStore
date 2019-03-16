package by.epam.javatraining.kutsko.task3.entity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import by.epam.javatraining.kutsko.task1.model.exception.CorruptParameterReferenceException;

public class Accessory extends Item implements Externalizable {

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
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		super.readExternal(in);
		try {
			setSeason(Accessory.Season.valueOf(in.readUTF()));
		} catch (CorruptParameterReferenceException e) {
		} catch (IllegalArgumentException ex) {
		}
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		super.writeExternal(out);
		out.writeUTF(season.name());
	}

	@Override
	public String toString() {
		return "season: " + season.toString().toLowerCase() + super.toString();
	}

}
