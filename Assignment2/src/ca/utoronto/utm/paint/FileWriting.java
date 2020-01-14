package ca.utoronto.utm.paint;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * Class that allows the program to Write and Read commands to file.
 * @author liameaton
 *
 */
public class FileWriting {
	
	/**
	 * Saves commands list to given fileName so it can be reopened.
	 * @param commands List of commands used to draw image
	 * @param fileName Location to save commands
	 */
	public static void saveImage(ArrayList<DrawingCommand> commands, String fileName) {
		try {
			FileOutputStream fileOutput = new FileOutputStream(fileName);
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(commands);
			objectOutput.close();
		} catch (IOException e) {
			System.out.println("Save failed!");
			e.printStackTrace();
		}
		
	}
	/**
	 * Opens image from given fileName and returns commands used to draw it
	 * @param fileName Location to load commands used to draw image
	 */
	public static ArrayList<DrawingCommand> openImage(String fileName) {
		ArrayList<DrawingCommand> commands = new ArrayList<DrawingCommand>();
		try {
			FileInputStream fileInput = new FileInputStream(fileName);
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			commands = (ArrayList<DrawingCommand>) objectInput.readObject();
			objectInput.close();
		} catch (IOException e) {
			System.out.println("Open failed!");
			e.printStackTrace();
		}
		 catch (ClassNotFoundException e) {
			 System.out.println("This shouldn't happen");
			 e.printStackTrace();
		 }
		return commands;
	}

}
