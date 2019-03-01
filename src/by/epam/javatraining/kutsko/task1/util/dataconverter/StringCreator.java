package by.epam.javatraining.kutsko.task1.util.dataconverter;

import java.lang.reflect.Array;

public class StringCreator {
	 public static String convertToString(Object object) {
		 Class type = object.getClass();
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
}
