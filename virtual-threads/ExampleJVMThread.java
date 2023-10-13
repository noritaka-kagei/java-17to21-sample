public class ExampleJVMThread {

    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        int numThreads = Integer.valueOf(args[0]);
        Thread[] threads = new Thread[numThreads];
        
        long start = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        // create and run tasks on JVM Threads
        for (int i = 0; i < numThreads; i++) {
            Task task = new Task("JVM Thread ["+String.valueOf(i)+"]");
            threads[i] = Thread.ofPlatform().unstarted(task);
        }
        // run tasks on JVM Threads
        for (Thread thread : threads) {
            thread.start();
        }
        // wait to finish the tasks
        for (Thread thread : threads) {
            thread.join();
        }

        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long end = System.currentTimeMillis();

        // print result
        System.out.println("===JVM Threads===");
        System.out.println("  Executing Time: "+(end-start)+" (ms)");
        System.out.println("  Used Memory: "+(usedMemoryAfter-usedMemoryBefore)+" (bytes)");
    }
}
