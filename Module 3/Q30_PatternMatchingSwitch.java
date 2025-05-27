public class Q30_PatternMatchingSwitch {
    public static void main(String[] args) {
        printTypeMessage(42);
        printTypeMessage("Hello");
        printTypeMessage(3.14);
        printTypeMessage(true);
    }

    public static void printTypeMessage(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("It's an Integer: " + i);
            case String s -> System.out.println("It's a String: " + s);
            case Double d -> System.out.println("It's a Double: " + d);
            default -> System.out.println("Unknown type: " + obj);
        }
    }
}
