public class ExampleVirtualThread {

    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        int numThreads = Integer.valueOf(args[0]);

        long start = System.currentTimeMillis();

        // Virtual Threads
        for (int i = 0; i < numThreads; i++) {
            Thread thread = Thread.ofVirtual().start(new Task("Virtual Thread"));
            thread.join();
        }

        long end = System.currentTimeMillis();
        long usedMemory = runtime.totalMemory() - runtime.freeMemory();

        // print result
        System.out.println("===Virtual Threads===");
        System.out.println("  Executing Time: "+(end-start)+" (ms)");
        System.out.println("  Used Memory: "+usedMemory+" (bytes)");
    }
}
