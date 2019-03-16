package by.epam.javatraining.kutsko.task1.ioutil.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.epam.javatraining.kutsko.task1.model.exception.CorruptParameterReferenceException;

public class DataReader {
	
	private static final Logger LOGGER;

	static {
		LOGGER = Logger.getRootLogger();
		PropertyConfigurator.configure("log4j.properties");
	}

	public static List<String> readFromTxtFile(String path) throws CorruptParameterReferenceException {
		List<String> listOfStrings = new ArrayList<String>();
		if (path != null) {
			String line;
			try (BufferedReader fis = new BufferedReader(new FileReader(path))) {
				while ((line = fis.readLine()) != null) {
					listOfStrings.add(line);
				}
			} catch (FileNotFoundException ex) {
				LOGGER.error(ex.toString() + ": File was not found");
			} catch (IOException e) {
				LOGGER.error(e.toString() + ": Failed to read properly");
			}
			return listOfStrings;
		}
		throw new CorruptParameterReferenceException("File path was null");
	}

	public static String readFromBinFile(String path) {
		StringBuffer buffer = new StringBuffer();
		try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(path)))) {
			buffer.append(in.readDouble() + " ");
			buffer.append(in.readUTF() + " ");
			buffer.append(in.readBoolean() + " ");
			buffer.append(in.readUTF() + " ");
			buffer.append(in.readUTF() + " ");
			buffer.append(in.readUTF() + " ");
			// но это подойдет только для сущности Scarf
		} catch (IOException e) {
		}
		return buffer.toString();
	}
}
