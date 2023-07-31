import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BugTrackingSystem {
    private List<Bug> bugs;
    private int nextId;

    public BugTrackingSystem() {
        bugs = new ArrayList<>();
        nextId = 1;
    }

    public void addBug(String description) {
        Bug bug = new Bug(nextId, description);
        bugs.add(bug);
        nextId++;
        System.out.println("Bug added successfully.");
    }

    public void updateBugStatus(int bugId, String status) {
        for (Bug bug : bugs) {
            if (bug.getId() == bugId) {
                bug.setStatus(status);
                System.out.println("Bug status updated successfully.");
                return;
            }
        }
        System.out.println("Bug not found.");
    }

    public void displayBugs() {
        System.out.println("List of Bugs:");
        for (Bug bug : bugs) {
            System.out.println(bug);
        }
    }

    public static void main(String[] args) {
        BugTrackingSystem bugTrackingSystem = new BugTrackingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBug Tracking System Menu:");
            System.out.println("1. Add Bug");
            System.out.println("2. Update Bug Status");
            System.out.println("3. Display Bugs");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter bug description: ");
                    String description = scanner.nextLine();
                    bugTrackingSystem.addBug(description);
                    break;
                case 2:
                    System.out.print("Enter bug ID: ");
                    int bugId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter new status: ");
                    String status = scanner.nextLine();
                    bugTrackingSystem.updateBugStatus(bugId, status);
                    break;
                case 3:
                    bugTrackingSystem.displayBugs();
                    break;
                case 4:
                    System.out.println("Exiting Bug Tracking System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
