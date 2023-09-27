import java.util.concurrent.ThreadFactory;

// Calculate executing time for running 100(MAX_SIZE) tasks to print message on Virtual Threads
public class VirtualThreadsExample1 {
    /* Fields */
    private static int MAX_SIZE = 100;

    private ThreadFactory factory = Thread.ofVirtual().factory();
    private Thread[] threads;

    /* Methods */
    // create virtual threads that have runnable task
    public void init() {
        threads = new Thread[MAX_SIZE];

        for ( int i=0; i<MAX_SIZE; i++ ) {
            String message = String.valueOf(i+1)+": running on virtual thread";
            threads[i] = factory.newThread( () -> System.out.println(message) );
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
        VirtualThreadsExample1 example = new VirtualThreadsExample1();

        example.init();

        long start = System.currentTimeMillis();
        example.runAllTask();
        example.wait2finish();
        long end = System.currentTimeMillis();

        System.out.println("Execute time: "+(end-start)+"ms");
    }
}
