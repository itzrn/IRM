public class T009_SetDaemon extends Thread{
    @Override
    public void run() {
        while(true) {
            System.out.println("Hello World");
        }
    }
    public static void main(String[] args) {
        T009_SetDaemon t1 = new T009_SetDaemon();
//		t1.start(); // this is the thread which doing the main work
        // at this line the work of main thread will get over, but the thread t1 is still in the work JVM will go on doing that until it wont get finish

        // Daemon threads are those thread which runs in the background and JVM won't wait for the Daemon thread to finish

        T009_SetDaemon t2 = new T009_SetDaemon();
        t2.setDaemon(true);
        t2.start();

    }
}
