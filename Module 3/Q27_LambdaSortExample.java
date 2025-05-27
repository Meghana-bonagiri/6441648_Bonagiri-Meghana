import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q27_LambdaSortExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("David");
        names.add("Charlie");
        names.add("Bob");

        // Sort using lambda expression
        Collections.sort(names, (a, b) -> a.compareTo(b));

        // Display sorted list
        System.out.println("Sorted names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
