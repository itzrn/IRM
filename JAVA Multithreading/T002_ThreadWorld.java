public class T002_ThreadWorld extends Thread{
    @Override
    public void run() {
        for(int i=0; i<1000; i++) { // STAGE 3 -> As soon the thread gets time it will come in RUNNUNG STAGE
            System.out.println("Thread World");
        }
    }

    // STAGE 4 ->  Blocking/Waiting => A thread is in the state when it is waiting for the resource to perform an action
    // STAGE 5 -> Terminated -> A thread is in the state when it has finished execution.
}


