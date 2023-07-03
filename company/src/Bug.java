import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bug {
    private int id;
    private String description;
    private String status;

    public Bug(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "Open";
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class BugTracker {
    private List<Bug> bugs;
    private Scanner scanner;

    public BugTracker() {
        bugs = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Bug Tracking System ---");
            System.out.println("1. Add Bug");
            System.out.println("2. View Bugs");
            System.out.println("3. Update Bug Status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBug();
                    break;
                case 2:
                    viewBugs();
                    break;
                case 3:
                    updateBugStatus();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        System.out.println("Thank you for using the Bug Tracking System!");
        scanner.close();
    }

    private void addBug() {
        System.out.print("\nEnter bug ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter bug description: ");
        String description = scanner.nextLine();

        Bug bug = new Bug(id, description);
        bugs.add(bug);

        System.out.println("Bug added successfully!");
    }

    private void viewBugs() {
        System.out.println("\n--- Bug List ---");
        if (bugs.isEmpty()) {
            System.out.println("No bugs found.");
        } else {
            for (Bug bug : bugs) {
                System.out.println("Bug ID: " + bug.getId());
                System.out.println("Description: " + bug.getDescription());
                System.out.println("Status: " + bug.getStatus());
                System.out.println("--------------------");
            }
        }
    }

    private void updateBugStatus() {
        viewBugs();

        if (bugs.isEmpty()) {
            return;
        }

        System.out.print("Enter the bug ID to update status: ");
        int bugId = scanner.nextInt();
        scanner.nextLine();

        Bug bugToUpdate = null;
        for (Bug bug : bugs) {
            if (bug.getId() == bugId) {
                bugToUpdate = bug;
                break;
            }
        }

        if (bugToUpdate != null) {
            System.out.print("Enter the new status (Open, In Progress, Closed): ");
            String newStatus = scanner.nextLine();
            bugToUpdate.setStatus(newStatus);
            System.out.println("Bug status updated successfully!");
        } else {
            System.out.println("Invalid bug ID! Please try again.");
        }
    }

    public static void main(String[] args) {
        BugTracker bugTracker = new BugTracker();
        bugTracker.start();
    }
}
