import java.util.concurrent.ThreadFactory;

public class ExampleJVMThread2 {

    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        int numThreads = Integer.valueOf(args[0]);

        ThreadFactory factory = Thread.ofPlatform().factory();
        Thread[] threads = new Thread[numThreads];
        
        long start = System.currentTimeMillis();

        // create JVM Threads
        for (int i = 0; i < numThreads; i++) {
            threads[i] = factory.newThread( new Task("JVM Thread ["+String.valueOf(i)+"]") );
        }
        // run tasks on JVM Threads
        for (Thread thread : threads) {
            thread.start();
        }
        // wait to finish the tasks
        for (Thread thread : threads) {
            thread.join();
        }

        long end = System.currentTimeMillis();

        long usedMemory = runtime.totalMemory() - runtime.freeMemory();

        // print result
        System.out.println("===JVM Threads===");
        System.out.println("  Executing Time: "+(end-start)+" (ms)");
        System.out.println("  Used Memory: "+usedMemory+" (bytes)");
    }
}
