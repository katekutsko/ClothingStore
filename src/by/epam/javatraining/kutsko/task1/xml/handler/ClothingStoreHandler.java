package by.epam.javatraining.kutsko.task1.util.xml.handler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.javatraining.kutsko.task1.model.entity.*;
import by.epam.javatraining.kutsko.task1.model.entity.type.Color;
import by.epam.javatraining.kutsko.task1.model.entity.type.Material;

public class ClothingStoreHandler extends DefaultHandler {

	private Set<Item> items;
	private Item current = null;
	private ItemEnum currentEnum = null;
	private EnumSet<ItemEnum> withText;

	public ClothingStoreHandler() {
		items = new HashSet<Item>();
		withText = EnumSet.range(ItemEnum.PRICE, ItemEnum.HEELHEIGHT);
	}

	public Set<Item> getItems() {
		return items;
	}

	public void startElement(String uri, String localName, String qName, Attributes attrs) {

		ItemEnum temp = ItemEnum.valueOf(localName.toUpperCase());

		switch (temp) {
		case SCARF: {
			current = new Scarf();
		}
			break;
		case HIGHHEELS: {
			current = new HighHeels();
		}
			break;
		case JUMPER: {
			current = new Jumper();
		}
			break;
		default: {
			if (withText.contains(temp)) {
				currentEnum = temp;
			}
		}
			break;
		}
		if (attrs.getLength() == 1) {
			if (current != null) {
				current.setID(attrs.getValue(0));
			}
		}
	}

	public void endElement(String uri, String localName, String qName) {

		ItemEnum temp = ItemEnum.valueOf(localName.toUpperCase());

		switch (temp) {
		case SCARF:
		case HIGHHEELS:
		case JUMPER: {
			if (current != null) {
				items.add(current);
			}
		}
			break;
		default: {
			if (withText.contains(temp)) {
				currentEnum = null;
			}
		}
			break;
		}
	}

	public void characters(char[] ch, int start, int length) {

		String s = new String(ch, start, length).trim();

		if (currentEnum != null) {

			switch (currentEnum) {
			case PRICE: {
				current.setPrice(Double.valueOf(s));
			}
				break;
			case MATERIAL: {
				current.setMaterial(Material.valueOf(s));
			}
				break;
			case SELECTED: {
				current.setSelected(Boolean.valueOf(s));
			}
				break;
			case COLOR: {
				current.setColor(Color.valueOf(s));
			}
				break;
			default: {
				if (current instanceof Jumper) {

					Jumper jumper = (Jumper) current;

					switch (currentEnum) {
					case CLOTHINGSIZE: {
						jumper.setSize(Clothing.Size.valueOf(s));
					}
						break;
					case JUMPERTYPE: {
						jumper.setType(Jumper.Type.valueOf(s));
					}
						break;
					default:
						break;
					}
				} else if (current instanceof Scarf) {

					Scarf scarf = (Scarf) current;

					switch (currentEnum) {
					case SEASON: {
						scarf.setSeason(Accessory.Season.valueOf(s));
					}
						break;
					case SCARFTYPE: {
						scarf.setType(Scarf.Type.valueOf(s));
					}
						break;
					default:
						break;
					}
				} else if (current instanceof HighHeels) {

					HighHeels heels = (HighHeels) current;

					switch (currentEnum) {
					case SHOESIZE: {
						heels.setSize(Integer.parseInt(s));
					}
						break;
					case HEELHEIGHT: {
						heels.setHeelHeight(Float.parseFloat(s));
					}
						break;
					default:
						break;
					}
				}
			}
			}
			currentEnum = null;
		}
	}
}
