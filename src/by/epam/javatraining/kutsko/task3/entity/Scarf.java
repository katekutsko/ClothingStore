package by.epam.javatraining.kutsko.task3.entity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import by.epam.javatraining.kutsko.task1.model.exception.CorruptParameterReferenceException;

public class Scarf extends Accessory implements Externalizable {

	private Type type;

	public enum Type {
		THIN, CHUNKY, LOOP, OTHER
	}

	public Scarf() {
		super();
		type = Type.OTHER;
	}

	public Scarf(Object... parameters) {
		this((Double) parameters[0], (Material) parameters[1], (Boolean) parameters[2], (Color) parameters[3],
				(Season) parameters[4], (Type) parameters[5]);
	}

	public Scarf(double price, Material material, boolean selected, Color color, Season season, Type type) {
		super(price, material, selected, color, season);
		this.type = type;
	}

	public Scarf(Scarf item) {
		super(item);
		this.type = item.type;
	}

	public void setType(Type type) throws CorruptParameterReferenceException {
		if (type != null) {
			this.type = type;
		} else {
			throw new CorruptParameterReferenceException("Type reference was null");
		}
	}

	public Type getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Scarf other = (Scarf) obj;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ("Scarf\n" + super.toString()) + ", type: " + type.toString().toLowerCase();
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		super.readExternal(in);
		try {
			setType(Scarf.Type.valueOf(in.readUTF()));
		} catch (CorruptParameterReferenceException e) {
		} catch (IllegalArgumentException ex) {}
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		super.writeExternal(out);
		out.writeUTF(type.name());
	}
}
