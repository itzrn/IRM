import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T013_UnfairLockExample {
    private final Lock unfairLock = new ReentrantLock();

    public void accessResource(){
        unfairLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" acquired the lock");
            Thread.sleep(1000);

        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }finally {
            unfairLock.unlock();
            System.out.println(Thread.currentThread().getName()+ " released the lock");
        }
    }


    public static void main(String[] args) {
        T013_UnfairLockExample ex = new T013_UnfairLockExample();
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

    // When we use lock different thread randomly comes here there is no sequence that thread a comes first then thread b will come
    // this is unfairness of lock
    // giving that order to thread is called fairness -> like first come, first served
}
