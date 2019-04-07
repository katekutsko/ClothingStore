package by.epam.javatraining.kutsko.task1.util.xml.validator;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import org.xml.sax.SAXException;

public class XMLValidator {

	private static final String LOG_CONFIG = "resource/log4j.xml";

	private static final Logger LOGGER;

	static {
		LOGGER = Logger.getRootLogger();
		DOMConfigurator.configure(LOG_CONFIG);
	}

	public static boolean validateXML(String fileName, String schemaName) {

		if (fileName != null && schemaName != null) {

			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			File schemaLocation = new File(schemaName);

			try {
				Schema schema = factory.newSchema(schemaLocation);
				Validator validator = schema.newValidator();
				Source source = new StreamSource(fileName);
				validator.validate(source);
				LOGGER.info(fileName + " is valid and may be parsed.");

				return true;

			} catch (SAXException e) {
				LOGGER.error(fileName + " is not valid. " + e.getMessage());

			} catch (IOException e) {
				LOGGER.error(e.getMessage() + " IOException was caught, validation was not successful");
			}
			return false;
		}
		LOGGER.error("File, schema name or both were null, validation unsuccesfful");
		return false;
	}
}