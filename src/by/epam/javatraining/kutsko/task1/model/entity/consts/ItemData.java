package by.epam.javatraining.kutsko.task1.model.entity.consts;

import java.util.Locale;
import java.util.ResourceBundle;

public class ItemData {
	
	private static ResourceBundle bundle;
	private static Locale locale;
	
	public static String PRICE = "price";
	public static String SIZE = "size";
	public static String COLOR = "color";
	public static String MATERIAL = "material";
	public static String SELECTED = "selected";
	public static String TYPE = "type";
	public static String SEASON = "season";
	public static String HEEL_HEIGHT = "heel height";
	public static String SCARF = "scarf";
	public static String HIGH_HEELS = "high heels";
	public static String JUMPER = "jumper";
	
	public static String RED = "red";
	public static String WHITE = "white";
	public static String BLACK = "black";
	public static String GREEN = "green";
	public static String BLUE = "blue";
	public static String MULTI = "multi";
	public static String PINK = "pink";
	public static String BROWN = "brown";
	public static String GREY = "grey";
	public static String LEATHER = "leather";
	public static String COTTON = "cotton";
	public static String SILK = "silk";
	public static String POLIESTER = "poliester";
	public static String WOOL = "wool";
	public static String FALSE = "false";
	public static String TRUE = "true";
	public static String WINTER = "winter";
	public static String ANY = "any";
	public static String DEMISEASON = "demiseason";
	public static String LOOP = "loop";
	public static String CHUNKY = "chunky";
	public static String THIN = "thin";
	
	
	static {
		locale = new Locale("ru", "RU");
	}
	
	public static void changeLocale() {
		bundle = ResourceBundle.getBundle("localisation.l10n", locale);
		PRICE = bundle.getString("price");
		SIZE = bundle.getString("size");
		COLOR = bundle.getString("color");
		MATERIAL = bundle.getString("material");
		SELECTED = bundle.getString("selected");
		TYPE = bundle.getString("type");
		SEASON = bundle.getString("season");
		HEEL_HEIGHT = bundle.getString("heelHeight");
		SCARF = bundle.getString("scarf");
		HIGH_HEELS = bundle.getString("highHeels");
		JUMPER = bundle.getString("jumper");
	}
	
	public static String getLocalisedString(String string) {
		return bundle.getString(string);
	}
}
