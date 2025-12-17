import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T013_FairnessLockExample {
    private final Lock fairLock = new ReentrantLock(true);

    public void accessResource(){
        fairLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" acquired the lock");
            Thread.sleep(1000);

        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }finally {
            fairLock.unlock();
            System.out.println(Thread.currentThread().getName()+ " released the lock");
        }
    }


    public static void main(String[] args) {
        T013_FairnessLockExample ex = new T013_FairnessLockExample();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                ex.accessResource();
            }
        };
        Thread t1 = new Thread(task, "t1");
        Thread t2 = new Thread(task, "t2");
        Thread t3 = new Thread(task, "t3");

        t1.start();
        t2.start();
        t3.start();
    }
}

// suppose there is a thread which won't get any resource, every thread is just asking the resource that situation is called as starvation
// so if we implement the fair lock then everyone will get resource

// Disadvantage of Lock
    // Fairness
    // Blocking
    // interruptibility
