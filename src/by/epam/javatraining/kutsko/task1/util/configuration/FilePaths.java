package by.epam.javatraining.kutsko.task1.util.configuration;

import java.util.ResourceBundle;

public class FilePaths {

	private static ResourceBundle bundle;
	
	public static String XML_FILE;
	public static String XSD_FILE;
	public static String LOG_CONFIG_FILE;
	
	static {
		bundle = ResourceBundle.getBundle("configuration.configuration");
		XML_FILE = bundle.getString("xmlFile");
		XSD_FILE = bundle.getString("xsdFile");
		LOG_CONFIG_FILE = bundle.getString("logConfigFile");
	}
}
