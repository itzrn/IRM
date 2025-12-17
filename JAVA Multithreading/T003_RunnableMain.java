

public class T003_RunnableMain {
    public static void main(String[] args) {
        T003_RunnableWorld t003_RunnableWorld = new T003_RunnableWorld();
        Thread t1 = new Thread(t003_RunnableWorld);
        t1.start();

        for(int i=0; i<1000; i++) {
            System.out.println("Runnable Main");
        }
    }
}


