package by.epam.javatraining.kutsko.task1.util.xml.parser;

import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;
import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.util.xml.handler.ClothingStoreHandler;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ClothingStoreSAXParser {

	private static ClothingStoreSAXParser instance;
	
	private Set<Item> items;
	private ClothingStoreHandler handler;
	private XMLReader reader;
	
	private static final Lock LOCK;
	private static final Logger LOGGER;
	private static final String LOG_FILE = "resource/log4j.xml";

	static {
		LOCK = new ReentrantLock();
		LOGGER = Logger.getRootLogger();
		DOMConfigurator.configure(LOG_FILE);
	}

	private ClothingStoreSAXParser() {

		handler = new ClothingStoreHandler();

		try {
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(handler);
		
		} catch (SAXException e) {
			LOGGER.error("SAX error: " + e.getMessage());
		}
	}
	
	public static ClothingStoreSAXParser getInstance() {
		if (instance == null) {
			LOCK.lock();
			
			if (instance == null) {
				instance = new ClothingStoreSAXParser();
			}
			LOCK.unlock();
		}
		return instance;
	}

	public ClothingStore getStore() {
		return new ClothingStore(items);
	}

	public void buildItemSet(String fileName) {
		try {
			reader.parse(fileName);
		} catch (SAXException e) {
			LOGGER.error("SAX error: " + e);
		} catch (IOException e) {
			LOGGER.error("IO error: " + e);
		}
		items = handler.getItems();
	}
}
