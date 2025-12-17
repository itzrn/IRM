import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T027_CyclicBarrier {
    public static void main(String[] args) {
        int numberOfServices = 3;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfServices);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfServices);
        executor.submit(new T027_DependentService(cyclicBarrier));
        executor.submit(new T027_DependentService(cyclicBarrier));
        executor.submit(new T027_DependentService(cyclicBarrier));
        cyclicBarrier.reset(); // we can also reset it
        System.out.println("Main");
        executor.shutdown();
    }
}


class T027_DependentService implements Callable<String>{
    private final CyclicBarrier cyclicBarrier;
    public T027_DependentService(CyclicBarrier cyclicBarrier) {
        // TODO Auto-generated constructor stub
        this.cyclicBarrier=cyclicBarrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+ " Service Started");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+ " is waiting at the barrier");
        cyclicBarrier.await();
        return "ok";
    }

}

// CyclicBarrier won't block main thread
// Used when you want all the task to reach at specific point before any of them proceed

// Trip -> meeting at a point

// CyclicBarrier have another constructor which takes number and runnable
// which means what will run when all the task end up meeting at a point
// this  runnable thread is performed by the last thread which reach at the meeting point

