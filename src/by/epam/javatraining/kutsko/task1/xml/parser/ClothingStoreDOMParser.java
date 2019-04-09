package by.epam.javatraining.kutsko.task1.util.xml.parser;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;
import by.epam.javatraining.kutsko.task1.model.entity.*;
import by.epam.javatraining.kutsko.task1.model.entity.Accessory.Season;
import by.epam.javatraining.kutsko.task1.model.entity.type.Color;
import by.epam.javatraining.kutsko.task1.model.entity.type.Material;
import by.epam.javatraining.kutsko.task1.util.xml.handler.ItemEnum;

public class ClothingStoreDOMParser {
	
	private static ClothingStoreDOMParser instance;

	private Set<Item> items;
	private DocumentBuilder docBuilder;
	
	private static final Lock LOCK;
	private static final Logger LOGGER;
	private static final String LOG_FILE = "resource/log4j.xml";

	static {
		LOCK = new ReentrantLock();
		LOGGER = Logger.getRootLogger();
		DOMConfigurator.configure(LOG_FILE);
	}

	private ClothingStoreDOMParser() {

		items = new HashSet<Item>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			LOGGER.error("SAX parser configuration error: " + e);
		}
	}
	
	public static ClothingStoreDOMParser getInstance() {
		if (instance == null) {
			LOCK.lock();
			
			if (instance == null) {
				instance = new ClothingStoreDOMParser();
			}
			LOCK.unlock();
		}
		return instance;
	}

	public ClothingStore getStore() {
		return new ClothingStore(items);
	}

	public void buildItemSet(String fileName) {
		Document doc = null;

		try {
			doc = docBuilder.parse(fileName);
			Element root = doc.getDocumentElement();
			NodeList itemList = root.getChildNodes();
			
			for (int i = 0; i < itemList.getLength(); i++) {
				
				Node element = itemList.item(i);
				
				if (element instanceof Element) {
					Element itemElement = (Element) element;
					Item item = buildItem(itemElement);
					items.add(item);
				}
			}
		} catch (IOException e) {
			LOGGER.error("IO error: " + e);
		} catch (SAXException e) {
			LOGGER.error("SAX error: " + e);
		}
	}

	private Item buildItem(Element itemElement) {

		String elementName = itemElement.getNodeName();
		ItemEnum temp = ItemEnum.valueOf(elementName.toUpperCase());
		Item item;

		switch (temp) {
		case SCARF: {
			item = new Scarf();
			Scarf scarf = (Scarf) item;
			scarf.setSeason(Season.valueOf(getElementTextContent(itemElement, ItemEnum.SEASON.getValue())));
			scarf.setType(Scarf.Type.valueOf(getElementTextContent(itemElement, ItemEnum.SCARFTYPE.getValue())));
		}
			break;
		case JUMPER: {
			item = new Jumper();
			Jumper jumper = (Jumper) item;
			jumper.setSize(Clothing.Size.valueOf(getElementTextContent(itemElement, ItemEnum.CLOTHINGSIZE.getValue())));
			jumper.setType(Jumper.Type.valueOf(getElementTextContent(itemElement, ItemEnum.JUMPERTYPE.getValue())));
		}
			break;
		case HIGHHEELS: {
			item = new HighHeels();
			HighHeels heels = (HighHeels) item;
			heels.setSize(Integer.parseInt(getElementTextContent(itemElement, ItemEnum.SHOESIZE.getValue())));
			heels.setHeelHeight(Float.parseFloat(getElementTextContent(itemElement, ItemEnum.HEELHEIGHT.getValue())));
		}
			break;
		default: {
			item = null;
		}
		}
		if (item != null) {
			item.setID(itemElement.getAttribute(ItemEnum.MODEL.getValue()));
			item.setPrice(Double.parseDouble(getElementTextContent(itemElement, ItemEnum.PRICE.getValue())));
			item.setMaterial(Material.valueOf(getElementTextContent(itemElement, ItemEnum.MATERIAL.getValue())));
			item.setSelected(Boolean.parseBoolean(getElementTextContent(itemElement, ItemEnum.SELECTED.getValue())));
			item.setColor(Color.valueOf(getElementTextContent(itemElement, ItemEnum.COLOR.getValue())));
		}

		return item;
	}

	private static String getElementTextContent(Element element, String elementName) {
		NodeList nList = element.getElementsByTagName(elementName);
		Node node = nList.item(0);
		String text = node.getTextContent().trim();
		return text;
	}
}
