package RunnableDemo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread running....");
        RunnableDemo runnable1 = new RunnableDemo("Thread-1-Hr-Database");
        runnable1.start();
        RunnableDemo runnable2 = new RunnableDemo("Thread-2-Sending-Information");
        runnable2.start();
        System.out.println("Main thread stopped!!!");
    }
}
