public class ExampleJVMThread {

    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        int numThreads = Integer.valueOf(args[0]);
    
        long start = System.currentTimeMillis();

        // JVM Threads
        for (int i = 0; i < numThreads; i++) {
            Thread thread = Thread.ofPlatform().start(new Task("JVM Thread"));
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
