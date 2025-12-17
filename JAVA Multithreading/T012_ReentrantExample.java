import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T012_ReentrantExample {
    private final Lock lock = new ReentrantLock(); // since the lock is reentrant if the same thread want to enter another resource to lock then it will able to lock it so names as reentrant

    public void outerMethod() {
        lock.lock();
//        lock.lockInterruptibly(); // suppose there is another thread which is waiting for long time to make this resource interruptible we make the resource interruptible using .lockInterruptibly()
        try {

        }finally {
            lock.unlock();
        }
    }

    public void innerMethod() {
        lock.lock();
        try {

        }finally {
            lock.unlock();
//            lock.unlock(); // writing it again will completely unlock even the outerMethod, so where you use .lock() in its finally do use .unlock()
        }
    }
}

// Reentrant class in this way acquire synchronization
