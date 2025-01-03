package tasker;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner  k =  new Scanner(System.in);
    	TaskManager taskManager = new  TaskManager();
    	taskManager.loadFromFile("tasks.txt");
    	
    	while(true) {
    		System.out.println("\nTaskify Menu:");
    		System.out.println("1. Add Task");
    		System.out.println("2. View Tasks");
    		System.out.println("3. Delete Task");
    		System.out.println("4. Search Task: ");
    		System.out.println("5. Sort Tasks by Priority");
    		System.out.println("6. Sort Tasks by Deadline");
    		System.out.println("7. Save Tasks");
    		System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            
            int choice = k.nextInt();
            k.nextLine();  // Consume newline
            System.out.println();
            
            switch (choice) {
            case 1:
            	System.out.print("Enter task title: ");
            	String title = k.nextLine();
            	
            	System.out.print("Enter task description: ");
            	String description = k.nextLine();
            	
            	System.out.print("Enter task priority (1-5): ");
            	int priority = k.nextInt();
            	k.nextLine();//consume  new line
            	
            	System.out.print("Enter task deadline(yyyy-mm-dd): ");
            	String deadline = k.nextLine();
            	
            	Task newtask = new Task(title,description,priority,deadline);
            	taskManager.addTask(newtask);
            	break;
            	
            case 2:
            	taskManager.viewTasks();
            	break;
            	
            case 3:
            	System.out.print("Enter the title of the task to delete: ");
            	String deleteTitle = k.nextLine();
            	taskManager.deleteTask(deleteTitle);
            	break;
            
            case 4:
            	System.out.print("Enter the title of the task to search: ");
            	String searchTitle  = k.nextLine();
            	taskManager.searchTask(searchTitle);
            	break;
            	
            case 5:
                taskManager.sortByPriority();
                taskManager.viewTasks();
                break;

            case 6:
                taskManager.sortByDeadline();
                taskManager.viewTasks();
                break;
                
            case 7:
                taskManager.saveToFile("tasks.txt");
                break;


            case 8:
                taskManager.saveToFile("tasks.txt");
                System.out.println("Exiting Taskify. Goodbye!");
                k.close();
                return;


            	
            default:
            	System.out.println("Invalid choice. Please try agian!");
            }
    	}
        
    }
}
