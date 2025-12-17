import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class T014_ReadWriteCounter {
    private int count=0;

    // allows multiple threads to read resources concurrently as long as no thread is writing to it, it ensures exclusive access for write operations
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();


    public void increment(){
        writeLock.lock();
        try{
            count++;
        }finally {
            writeLock.unlock();
        }
    }

    public int getCount(){
        readLock.lock();
        // multiple Threads can acquire read lock, on one condition read lock can only get acquire when there is no thread acquiring the write lock, means write lock is getting use
        try{
            return count;
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T014_ReadWriteCounter counter = new T014_ReadWriteCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    System.out.println(Thread.currentThread().getName()+" read: "+counter.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    counter.increment();
                    System.out.println(Thread.currentThread().getName()+ " incremented");
                }
            }
        };

        Thread writerThread = new Thread(writeTask);
        Thread readThread1 = new Thread(readTask);
        Thread readThread2 = new Thread(readTask);

        writerThread.start();
        readThread1.start();
        readThread2.start();

        writerThread.join();
        readThread1.join();
        readThread2.join();

        System.out.println("Final Count -> "+counter.getCount());

    }
}
