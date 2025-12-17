public class T007_Main {
    public static void main(String[] args) {
        T007_Interrupt t1 = new T007_Interrupt("Interrupt Thread 1");
        t1.start();

        t1.interrupt(); // this is something telling to compiler to make this thread stop whatever the current state it is at.
    }
}
