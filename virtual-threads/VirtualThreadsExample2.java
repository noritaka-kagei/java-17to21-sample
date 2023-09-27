// Calculate executing time for running 100(MAX_SIZE) tasks to print message on Virtual Threads
public class VirtualThreadsExample2 {
    /* Fields */
    private static int MAX_SIZE = 100;

    private Thread[] threads;

    /* Inner Class */
    private class Task implements Runnable {
        private String message;
        public Task(String message) {
            this.message = message;
        }
        @Override
        public void run() {
            System.out.println(message);
        }
    }
    
    /* Methods */
    // create virtual threads that have runnable task
    public void init() {
        threads = new Thread[MAX_SIZE];

        for ( int i=0; i<MAX_SIZE; i++ ) {
            String message = String.valueOf(i+1)+": running on virtual thread";
            threads[i] = Thread.ofVirtual().unstarted(new Task(message));

            // // Same process as the above
            // // You do not need to define "Task" class if you this statement
            // String message = String.valueOf(i)+": running on virtual thread";
            // Runnable task = () -> System.out.println(message);
            // threads[i] = Thread.ofVirtual().unstarted(task);
        }
    }

    // run all tasks
    public void runAllTask() {
        for (Thread thread: threads) {
            thread.start();
        }
    }

    // wait to finish all tasks on virtual threads
    public void wait2finish() throws InterruptedException {
        for (Thread thread: threads) {
            thread.join();
        }
    }
    
    /* Main Method */
    public static void main(String[] args) throws InterruptedException {
        VirtualThreadsExample2 example = new VirtualThreadsExample2();

        example.init();

        long start = System.currentTimeMillis();
        example.runAllTask();
        example.wait2finish();
        long end = System.currentTimeMillis();

        System.out.println("Execute time: "+(end-start)+"ms");
    }
}
