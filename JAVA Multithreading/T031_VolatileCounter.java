import java.util.concurrent.atomic.AtomicInteger;

public class T031_VolatileCounter {
    private AtomicInteger counter=new AtomicInteger(0); // provide synchronization without using lock
    public void increment() {
        counter.incrementAndGet();
    }
    public int getCounter() {
        return counter.get();
    }


    public static void main(String[] args) throws InterruptedException {
        T031_VolatileCounter vc = new T031_VolatileCounter();

        Thread t1 = new Thread(()->{
            for(int i=0; i<10000; i++) {
                vc.increment();
            }
        });

        Thread t2 = new Thread(()->{
            for(int i=0; i<10000; i++) {
                vc.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(vc.getCounter());


    }
}
// without using synchronous keyword and lock we get its property using Atomicity and still it is thread safe

