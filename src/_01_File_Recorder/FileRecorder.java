package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter message: ");
		String message = s.nextLine();
		s.close();
		
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/UserFile.txt", true);
			fw.write(message + "\n");
			System.out.println("completed");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("failed");
			e.printStackTrace();
		}
		
		
	}
}
