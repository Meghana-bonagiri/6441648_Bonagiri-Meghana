import java.util.HashMap;
import java.util.Scanner;

public class Q25_HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many student entries do you want to add? ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int i = 0; i < count; i++) {
            System.out.print("Enter student ID (integer): ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            studentMap.put(id, name);
        }

        System.out.print("\nEnter a student ID to search for: ");
        int searchId = scanner.nextInt();

        if (studentMap.containsKey(searchId)) {
            System.out.println("Student Name: " + studentMap.get(searchId));
        } else {
            System.out.println("Student ID not found.");
        }

        scanner.close();
    }
}
