import java.time.Duration;
import java.time.Instant;

public class Q40_VirtualThreadsDemo {
    public static void main(String[] args) throws InterruptedException {
        int totalThreads = 100_000;

        System.out.println("Starting virtual threads...");
        Instant startVirtual = Instant.now();
        Thread[] virtuals = new Thread[totalThreads];
        for (int i = 0; i < totalThreads; i++) {
            virtuals[i] = Thread.startVirtualThread(() -> {
                System.out.println("Hello from virtual thread " + Thread.currentThread().threadId());
            });
        }
        for (Thread t : virtuals) {
            t.join();
        }
        Instant endVirtual = Instant.now();
        System.out.println("Virtual threads completed in: " + Duration.between(startVirtual, endVirtual).toMillis() + " ms");

        System.out.println("\nStarting platform threads...");
        Instant startPlatform = Instant.now();
        Thread[] platforms = new Thread[totalThreads];
        for (int i = 0; i < totalThreads; i++) {
            platforms[i] = new Thread(() -> {
                System.out.println("Hello from platform thread " + Thread.currentThread().threadId());
            });
            platforms[i].start();
        }
        for (Thread t : platforms) {
            t.join();
        }
        Instant endPlatform = Instant.now();
        System.out.println("Platform threads completed in: " + Duration.between(startPlatform, endPlatform).toMillis() + " ms");
    }
}
