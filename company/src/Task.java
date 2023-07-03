import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String name;
    private String description;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

class TodoListManager {
    private List<Task> tasks;
    private Scanner scanner;

    public TodoListManager() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Todo List Manager ---");
            System.out.println("1. Add task");
            System.out.println("2. Edit task");
            System.out.println("3. View tasks");
            System.out.println("4. Remove task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    viewTasks();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        System.out.println("Thank you for using the Todo List Manager!");
        scanner.close();
    }

    private void addTask() {
        System.out.print("\nEnter task name: ");
        String name = scanner.nextLine();

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        Task task = new Task(name, description);
        tasks.add(task);

        System.out.println("Task added successfully!");
    }

    private void editTask() {
        viewTasks();

        if (tasks.isEmpty()) {
            return;
        }

        System.out.print("Enter the task number to edit: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number! Please try again.");
        } else {
            Task task = tasks.get(taskNumber - 1);
            System.out.println("Editing Task: " + task.getName());
            System.out.print("Enter new name (leave blank to keep the same): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                task.setName(newName);
            }
            System.out.print("Enter new description (leave blank to keep the same): ");
            String newDescription = scanner.nextLine();
            if (!newDescription.isEmpty()) {
                task.setDescription(newDescription);
            }
            System.out.println("Task edited successfully!");
        }
    }

    private void viewTasks() {
        System.out.println("\n--- Task List ---");
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println("Task " + (i + 1) + ":");
                System.out.println("Name: " + task.getName());
                System.out.println("Description: " + task.getDescription());
                System.out.println();
            }
        }
    }

    private void removeTask() {
        viewTasks();

        if (tasks.isEmpty()) {
            return;
        }

        System.out.print("Enter the task number to remove: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number! Please try again.");
        } else {
            Task removedTask = tasks.remove(taskNumber - 1);
            System.out.println("Task removed: " + removedTask.getName());
        }
    }

    public static void main(String[] args) {
        TodoListManager manager = new TodoListManager();
        manager.start();
    }
}
