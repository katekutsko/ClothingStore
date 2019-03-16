package by.epam.javatraining.kutsko.task1.ioutil.writer;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import by.epam.javatraining.kutsko.task1.model.entity.*;

public class DataWriter {
	
	public static void writeToBinFile(String fileName, Item item) {
		try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))){
			out.writeDouble(item.getPrice());
			out.writeUTF(item.getMaterial().name());
			out.writeBoolean(item.isSelected());
			out.writeUTF(item.getColor().name());

			if (item instanceof Scarf) {
				Scarf scarf = (Scarf) item;
				out.writeUTF(scarf.getSeason().name());
				out.writeUTF(scarf.getType().name());
			}
			
			if (item instanceof HighHeels) {
				HighHeels shoes = (HighHeels) item;
				out.writeInt(shoes.getSize());
				out.writeFloat(shoes.getHeelHeight());
			}
			
			if (item instanceof Jumper) {
				Jumper jumper = (Jumper) item;
				out.writeUTF(jumper.getSize().name());
				out.writeUTF(jumper.getType().name());
			}
		} catch (FileNotFoundException e) {} 
		catch (IOException e) {}
	}
}
