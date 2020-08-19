package _02_File_Encrypt_Decrypt;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	
	public static void main(String[] args) {
		//come back to this and figure out a way to retrieve the key (from the file itself?)
		try {
			Scanner s = new Scanner(System.in);
			System.out.println("Enter the key used in encryptor: ");
			int key = s.nextInt();
			s.close();
			
			FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/enigmafile.txt");
			int c = fr.read();
			String decrypted = "";
			System.out.println(key);
			while(c != -1){
				System.out.println((char) c);
				if (c >= 65 && c <= 90) {
					if (c - key >= 65) decrypted += (char) (c - key);
					else decrypted += (char) (90 - (64 - (c - key)));
				}
				else if (c >= 97 && c <= 122) {
					if (c - key >= 97) decrypted += (char) (c - key);
					else decrypted += (char) (122 - (96 - (c - key)));
				} else if (c == ' ') decrypted += " ";
				System.out.println(decrypted);
				c = fr.read();
			}
			fr.close();
			
			JOptionPane.showMessageDialog(null, "Decrypted thing: " + decrypted);
			System.out.println("completed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("failed");
			e.printStackTrace();
		}
	}
	
}
