public class ExampleVirtualThread {

    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        int numThreads = Integer.valueOf(args[0]);

        Thread[] threads = new Thread[numThreads];
        
        long start = System.currentTimeMillis();

        // create and run tasks on Virtual Threads
        for (int i = 0; i < numThreads; i++) {
            // threads[i] = Thread.ofVirtual().unstarted(new Task("JVM Thread ["+String.valueOf(i)+"]"));
            threads[i] = Thread.ofVirtual().start(new Task("Virtual Thread ["+String.valueOf(i)+"]"));
        }
        // // run tasks on Virtual Threads
        // for (Thread thread : threads) {
        //     thread.start();
        // }
        // wait to finish the tasks
        for (Thread thread : threads) {
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
