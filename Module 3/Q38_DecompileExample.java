public class Q38_DecompileExample {
    private String message;

    public Q38_DecompileExample(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message.toUpperCase();
    }

    public static void main(String[] args) {
        Q38_DecompileExample example = new Q38_DecompileExample("hello world");
        System.out.println(example.getMessage());
    }
}
