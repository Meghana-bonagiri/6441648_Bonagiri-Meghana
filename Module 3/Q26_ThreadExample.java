class MessagePrinter extends Thread {
    String message;

    MessagePrinter(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(message);
        }
    }
}

public class Q26_ThreadExample {
    public static void main(String[] args) {
        MessagePrinter t1 = new MessagePrinter("Thread 1 is running");
        MessagePrinter t2 = new MessagePrinter("Thread 2 is running");
        t1.start();
        t2.start();
    }
}