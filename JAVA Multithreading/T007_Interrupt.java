public class T007_Interrupt extends Thread {
    public T007_Interrupt(String name) {
        super(name);
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Thread is Running ... ");
        } catch (InterruptedException e) {
            System.out.println("Thread Intrrputed: "+ e);
        }
    }
}