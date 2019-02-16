package by.epam.javatraining.kutsko.task1.model.entity;

public class Accessory extends Item {

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((season == null) ? 0 : season.hashCode());
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
	public String toString() {
		return ", season: " + season.toString().toLowerCase() + super.toString();
	}

}
