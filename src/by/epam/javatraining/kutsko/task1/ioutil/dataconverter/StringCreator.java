package by.epam.javatraining.kutsko.task1.ioutil.dataconverter;

import java.lang.reflect.Array;

import by.epam.javatraining.kutsko.task1.model.exception.CorruptParameterReferenceException;

public class StringCreator {
	public static String convertToString(Object object) {
		if (object != null) {
			Class<? extends Object> type = object.getClass();
			StringBuffer buffer = new StringBuffer();
			if (type.isArray()) {
				int length = Array.getLength(object);
				for (int i = 0; i < length; i++) {
					buffer.append(Array.get(object, i));
					buffer.append("\n");
				}
			} else {
				buffer.append(object);
			}
			return buffer.toString();
		}
		return "null";
	}
}
