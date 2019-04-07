package by.epam.javatraining.kutsko.task1.util.xml.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import by.epam.javatraining.kutsko.task1.model.entity.*;
import by.epam.javatraining.kutsko.task1.model.entity.Accessory.Season;
import by.epam.javatraining.kutsko.task1.model.entity.type.Color;
import by.epam.javatraining.kutsko.task1.model.entity.type.Material;
import by.epam.javatraining.kutsko.task1.util.xml.handler.ItemEnum;
import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;

public class ClothingStoreSTAXParser {
	private Set<Item> items = new HashSet<>();
	private XMLInputFactory inputFactory;
	private EnumSet<ItemEnum> itemTypes;
	
	private static final Logger LOGGER;
	private static final String LOG_FILE = "resource/log4j.xml";

	static {
		LOGGER = Logger.getRootLogger();
		DOMConfigurator.configure(LOG_FILE);
	}

	public ClothingStoreSTAXParser() {
		inputFactory = XMLInputFactory.newInstance();
		itemTypes = EnumSet.range(ItemEnum.SCARF, ItemEnum.JUMPER);
	}

	public ClothingStore getStore() {
		return new ClothingStore(items);
	}

	public void buildItemSet(String fileName) {

		FileInputStream inputStream = null;
		XMLStreamReader reader = null;
		String name;

		try {
			inputStream = new FileInputStream(new File(fileName));
			reader = inputFactory.createXMLStreamReader(inputStream);

			while (reader.hasNext()) {
				int type = reader.next();

				if (type == XMLStreamConstants.START_ELEMENT) {
					name = reader.getLocalName();

					if (itemTypes.contains(ItemEnum.valueOf(name.toUpperCase()))) {
						Item item = buildItem(reader);
						items.add(item);
					}
				}
			}
		} catch (XMLStreamException ex) {
			LOGGER.error("StAX parsing error! " + ex.getMessage());
		} catch (FileNotFoundException ex) {
			LOGGER.error("File " + fileName + " not found! " + ex);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				LOGGER.error("Impossible to close file " + fileName + " : " + e);
			}
		}
	}

	private Item buildItem(XMLStreamReader reader) throws XMLStreamException {

		Item item;

		if (reader.getLocalName() == ItemEnum.SCARF.getValue()) {
			item = new Scarf();
		} else if (reader.getLocalName() == ItemEnum.JUMPER.getValue()) {
			item = new Jumper();
		} else if (reader.getLocalName() == ItemEnum.HIGHHEELS.getValue()) {
			item = new HighHeels();
		} else {
			return null;
		}

		item.setID(reader.getAttributeValue(null, ItemEnum.MODEL.getValue()));

		String name = "";

		while (reader.hasNext()) {
			int type = reader.next();

			switch (type) {
			case XMLStreamConstants.START_ELEMENT:

				name = reader.getLocalName();

				switch (ItemEnum.valueOf(name.toUpperCase())) {
				case PRICE: {
					item.setPrice(Double.parseDouble(getXMLText(reader)));
				}
					break;
				case MATERIAL: {
					item.setMaterial(Material.valueOf(getXMLText(reader)));
				}
					break;
				case SELECTED: {
					item.setSelected(Boolean.parseBoolean(getXMLText(reader)));
				}
					break;
				case COLOR: {
					item.setColor(Color.valueOf(getXMLText(reader)));
				}
					break;
				default: {
					if (item instanceof Scarf) {
						Scarf scarf = (Scarf) item;

						if (name == ItemEnum.SEASON.getValue()) {
							scarf.setSeason(Season.valueOf(getXMLText(reader)));
						} else if (name == ItemEnum.SCARFTYPE.getValue()) {
							scarf.setType(Scarf.Type.valueOf(getXMLText(reader)));
						}
					} else if (item instanceof Jumper) {
						Jumper jumper = (Jumper) item;

						if (name == ItemEnum.CLOTHINGSIZE.getValue()) {
							jumper.setSize(Clothing.Size.valueOf(getXMLText(reader)));
						}
						if (name == ItemEnum.JUMPERTYPE.getValue()) {
							jumper.setType(Jumper.Type.valueOf(getXMLText(reader)));
						}
					} else if (item instanceof HighHeels) {
						HighHeels heels = (HighHeels) item;

						if (name == ItemEnum.SHOESIZE.getValue()) {
							heels.setSize(Integer.parseInt(getXMLText(reader)));
						}
						if (name == ItemEnum.HEELHEIGHT.getValue()) {
							heels.setHeelHeight(Float.parseFloat(getXMLText(reader)));
						}
					}
					break;
				}
				}

			case XMLStreamConstants.END_ELEMENT:
				if (reader.isEndElement()) {
					name = reader.getLocalName();
					if (itemTypes.contains(ItemEnum.valueOf(name.toUpperCase()))) {
						return item;
					}
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element");

	}

	private String getXMLText(XMLStreamReader reader) throws XMLStreamException {

		String text = null;

		if (reader.hasNext()) {
			reader.next();
			text = reader.getText().trim();
		}
		return text;
	}

}
