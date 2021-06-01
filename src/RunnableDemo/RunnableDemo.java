package RunnableDemo;

public class RunnableDemo implements Runnable {
    private Thread thread;
    private final String threadName;

    RunnableDemo(String threadName) {
        this.threadName = threadName;
        System.out.println(threadName+ "was created");
    }

    @Override
    public void run() {
        System.out.println("Running: "+ threadName);
        try {
            for (int i =50; i>0; i--) {
                System.out.println("Thread: " + threadName +", "+ i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException interruptedException) {
            System.out.println("Thread: " + threadName + " interrupted");
        }
        System.out.println("Thread" + threadName + "exiting");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if(thread ==null) {
            thread = new Thread(this,threadName);
            thread.start();
        }
    }
}
