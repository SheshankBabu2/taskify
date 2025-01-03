package tasker;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TaskManager {
	private ArrayList<Task> tasks;
	
	//Constructor
	public TaskManager() {
		tasks = new ArrayList<>();
	}
	
	//Add a new  task
	public void addTask(Task task) {
		tasks.add(task);
		System.out.println("Task added successfully");
	}
	
	//View all tasks
	public void viewTasks() {
		if(tasks.isEmpty()) {
			System.out.println("No tasks available.");
		}
		else {
			for(Task task:tasks) {
				System.out.println(task);
				System.out.println("----------------------\n");
			}
		}
	}
	
	//Delete a task by title
	public void deleteTask(String title) {
		boolean found =  false;
		for(Task  task: tasks) {
			if(task.getTitle().equalsIgnoreCase(title)) {
				tasks.remove(task);
				System.out.println("Task  deleted successfully!");
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("Task  not  found!");
		}
	}
	
	//searching a task by title
	public void searchTask(String title) {
		boolean found = false;
		for(Task task:tasks) {
			if(task.getTitle().equalsIgnoreCase(title)) {
				System.out.println("Task found: ");
				System.out.println(task);
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("Task not found!");
		}
	}
	
	//sorting by task priority
	public void sortByPriority() {
		if(tasks.isEmpty()) {
			System.out.println("No tasks to sort.");
			return;
		}
		tasks.sort(Comparator.comparingInt(Task::getPriority));
		System.out.println("Tasks sorted by priority!");
	}
	
	//sorting by deadline
	public void sortByDeadline() {
	    if (tasks.isEmpty()) {
	        System.out.println("No tasks to sort.");
	        return;
	    }
	    tasks.sort(Comparator.comparing(Task::getDeadline));
	    System.out.println("Tasks sorted by deadline!");
	}
	
	public void saveToFile(String filename) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filename))){
			for(Task task : tasks) {
				writer.println(task.getTitle()  + "|" + task.getDescription() + "|" + task.getPriority() +"|" +task.getDeadline());
			}
			System.out.println("Tasks saved successfully!");
		}catch (IOException e ) {
			System.out.println("Error saving tasks: "+ e.getMessage());
		}
	}
	
	public void loadFromFile(String filename) {
		try (Scanner k=new Scanner(new File(filename))){
			while (k.hasNextLine()) {
				String[]  data = k.nextLine().split("\\|");
				String  title = data[0];
				String description = data[1];
				int priority =  Integer.parseInt(data[2]);
				String deadline = data[3];
				tasks.add(new Task(title, description, priority, deadline));
			}
			System.out.println("Tasks loaded successfully!");
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found. Starting  with an empty task list.");
		}
		catch(Exception e) {
			System.out.println("Error loading tasks: " + e.getMessage());
		}
	}


}
