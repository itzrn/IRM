public class T010_SyncMain {
    public static void main(String[] args) {
        T010_SyncCounter counter = new T010_SyncCounter(); // here counter is common resource to both the thread
        T010_SyncThread t1 = new T010_SyncThread(counter, "Counter Thread 1");
        T010_SyncThread t2 = new T010_SyncThread(counter, "Counter Thread 2");

        t1.start();
        t2.start();

        try { // first we have to complete the thread so we can get the final count of the counter, thats y we need to join both the thread to main thread
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(counter.getCount()); // we should get 2000 in total but without using synchronization we may get 2000 or less
        // why less ? bcz it can be possible both the thread accessed count at the same time and incremented at the same time
        // which didn't let T010_SyncCounter object that there is two different increment

    }
}
