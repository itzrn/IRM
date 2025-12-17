public class T005_EssentialMethodsMain {
    public static void main(String[] args) throws InterruptedException {
        T005_EssentialMethodThread t1 = new T005_EssentialMethodThread();
        t1.start();

        t1.join(); // this line says the main(the thread which running the function where this line is written) thread will wait until the thread t1 won't get finish
        System.out.println("Hello");
    }
}