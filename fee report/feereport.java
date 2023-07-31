import java.util.Scanner;
public class feereport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student name:");
        String name = scanner.nextLine();

        System.out.println("Enter course name:");
        String course = scanner.nextLine();
        
        System.out.println("Enter course fee:");
        double courseFee = scanner.nextDouble();

        System.out.println("Enter additional fee (if any):");
        double additionalFee = scanner.nextDouble();
   
        double totalFee = courseFee + additionalFee;

        System.out.println("\nFee Report");
        System.out.println("===========");
        System.out.println("Student Name: " + name);
        System.out.println("Course Name: " + course);
        System.out.println("Course Fee: $" + courseFee);
        System.out.println("Additional Fee: $" + additionalFee);
        System.out.println("Total Fee: $" + totalFee);

        scanner.close();
    }
}
