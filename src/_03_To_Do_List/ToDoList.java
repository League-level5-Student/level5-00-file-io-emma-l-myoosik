package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener{
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	
	JFrame frame = new JFrame("ToDo List");
	JPanel panel = new JPanel();
	
	JButton addTask = new JButton("Add task");
	JButton viewTasks = new JButton("View tasks");
	JButton removeTask = new JButton("Remove task");
	JButton saveList = new JButton("Save list");
	JButton loadList = new JButton("Load list");
	
	ArrayList<String> tasks = new ArrayList<String>();
	
	public void createUI() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.add(addTask);
		panel.add(viewTasks);
		panel.add(removeTask);
		panel.add(saveList); 
		panel.add(loadList);
		
		addTask.addActionListener(this);
		viewTasks.addActionListener(this);
		removeTask.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);
		
		frame.add(panel);
		frame.pack();
		
	}
	
	public String toprint() {
		String list = "";
		for (String s: tasks) {
			list += s + "\n";
		}
		return list;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addTask) {
			String input = JOptionPane.showInputDialog("Add task: ");
			tasks.add(input);
		}
		else if (e.getSource() == viewTasks) {
			JOptionPane.showMessageDialog(null, "Tasks: \n" + toprint());
		}
		else if (e.getSource() == removeTask) {
			String r = JOptionPane.showInputDialog("Index to remove: ");
			int v = Integer.parseInt(r);
			tasks.remove(v);
		}
		else if (e.getSource() == saveList) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/Saved_List.txt");
				fw.write(toprint());
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}
		else if (e.getSource() == loadList) {
			String src = JOptionPane.showInputDialog("Location of file: ");
			try {
				BufferedReader br = new BufferedReader(new FileReader(src));
				String line = br.readLine();
				tasks.clear();
				while(line != null){
					System.out.println(line);
					tasks.add(line);
					line = br.readLine();
				}
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ToDoList list = new ToDoList();
		list.createUI();
	}
}
