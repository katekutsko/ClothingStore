package by.epam.javatraining.kutsko.task1.model.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

import by.epam.javatraining.kutsko.task1.model.entity.consts.ItemData;
import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.model.exception.InvalidHeelHeightException;

@XmlRootElement(name="highheels")
@XmlType(name = "Highheels", propOrder = {
		"heelheight"
})
public class HighHeels extends Shoes implements Serializable, Cloneable {
	
	@XmlTransient
	private static final long serialVersionUID = 1L;
	
	@XmlElement(required = true, name = "heelheight")
	private float heelheight;

	public HighHeels() {
		super();
		heelheight = 0;
	}

	public HighHeels(double price, Material material, boolean selected, Color color, String ID, int size, float heelHeight) {
		super(price, material, selected, color, ID, size);
		this.heelheight = heelHeight;
	}

	public HighHeels(HighHeels item) {
		super(item);
		this.heelheight = item.heelheight;
	}

	public float getHeelHeight() {
		return heelheight;
	}

	public void setHeelHeight(float heelHeight) {
		if (heelHeight >= 0 && heelHeight <= 20) {
			this.heelheight = heelHeight;
		} 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(heelheight);
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
		HighHeels other = (HighHeels) obj;
		if (Float.floatToIntBits(heelheight) != Float.floatToIntBits(other.heelheight))
			return false;
		return true;
	}

	@Override
	public Object clone() {
		Shoes item = (Shoes) super.clone();
		HighHeels shoes = new HighHeels(item.getPrice(), item.getMaterial(), item.isSelected(), item.getColor(), item.getID(),
				item.getSize(), heelheight);
		return shoes;
	}

	@Override
	public String toString() {
		return  "\n" + ItemData.HIGH_HEELS + "\n" + super.toString() + ", " + ItemData.HEEL_HEIGHT + ": " + heelheight;
	}
}
