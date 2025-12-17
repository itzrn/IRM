public class T002_ThreadMain {
    public static void main(String[] args) {
        T002_ThreadWorld threadWorld = new T002_ThreadWorld(); // STAGE 1 -> this is called as 'NEW' state
        threadWorld.start(); //STAGE 2 -> RUNNABLE state
        for(int i=0; i<1000; i++) {
            System.out.println("Thread Main");
        }
    }
}