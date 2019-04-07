package by.epam.javatraining.kutsko.task1.util.xml.handler;

public enum ItemEnum {
	STORE("store"), SCARF("scarf"), HIGHHEELS("highheels"), JUMPER("jumper"), MODEL("model"), PRICE("price"), MATERIAL("material"),
	SELECTED("selected"), COLOR("color"), CLOTHINGSIZE("clothingsize"), SEASON("season"),
	SHOESIZE("shoesize"), JUMPERTYPE("jumpertype"), SCARFTYPE("scarftype"), HEELHEIGHT("heelheight");

	private String value;

	private ItemEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
