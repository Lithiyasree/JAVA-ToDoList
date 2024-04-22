import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
	private ArrayList<String> tasks;
	private ArrayList<Boolean> completed;

	public ToDoList() {
		tasks = new ArrayList<>();
		completed = new ArrayList<>();
	}

	public void addTask(String task) {
		tasks.add(task);
		completed.add(false);
	}

	public void markCompleted(String taskName) {
		int index = tasks.indexOf(taskName);
		if (index != -1) {
			completed.set(index, true);
			System.out.print("\nTask '" + taskName + "' marked as completed.\n");
		} else {
			System.out.print("\nTask '" + taskName + "' not found.\n");
		}
	}

	public void deleteTask(String taskName) {
		int index = tasks.indexOf(taskName);
		if (index != -1) {
			tasks.remove(index);
			completed.remove(index);
			System.out.print("\nTask '" + taskName + "' deleted.\n");
		} else {
			System.out.print("\nTask '" + taskName + "' not found.\n");
		}
	}

	public void printTasks() {
		for (int i = 0; i < tasks.size(); i++) {
			String task = tasks.get(i);
			boolean isCompleted = completed.get(i);
			System.out.println((i + 1) + ". " + task + (isCompleted ? " (Completed)" : ""));
		}
	}

	public static void main(String[] args) {
		ToDoList toDoList = new ToDoList();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\n1. Add Task");
			System.out.println("2. Mark Completed");
			System.out.println("3. Delete Task");
			System.out.println("4. Print Tasks");
			System.out.println("5. Exit\n");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter task: ");
					String task = scanner.next();
					System.out.println();
					toDoList.addTask(task);
					break;
				case 2:
					System.out.print("Enter task name: ");
					String taskName = scanner.next();
					toDoList.markCompleted(taskName);
					break;
				case 3:
					System.out.print("Enter task name: ");
					String taskNameToDelete = scanner.next();
					toDoList.deleteTask(taskNameToDelete);
					break;
				case 4:
					System.out.println();
					toDoList.printTasks();
					break;
				case 5:
					scanner.close();
					System.exit(0);
			}
		}
	}
}


