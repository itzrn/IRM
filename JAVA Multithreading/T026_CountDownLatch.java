import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class T026_CountDownLatch {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//		ExecutorService executor = Executors.newFixedThreadPool(3);
//		Future<String> future1 = executor.submit(new DependentService());
//		Future<String> future2 = executor.submit(new DependentService());
//		Future<String> future3 = executor.submit(new DependentService());
//
//		future1.get();
//		future2.get();
//		future3.get();
//
//		System.out.println("All dependent Services finished. starting main service ... ");
//		executor.shutdown();
        // as we can see here we need to call .get function for each thread


        int numberOfServices = 3;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfServices);

        CountDownLatch latch = new CountDownLatch(numberOfServices); // we use when we have to make one or more than one threads to wait

        executor.submit(new DependentService(latch));
        executor.submit(new DependentService(latch));
        executor.submit(new DependentService(latch));

        latch.await();
        System.out.println("All dependent Services finished. starting main service ... ");
        executor.shutdown();




    }
}


class DependentService implements Callable<String>{
    private final CountDownLatch latch;
    public DependentService(CountDownLatch latch) {
        // TODO Auto-generated constructor stub
        this.latch=latch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName()+ " Service Started");
            Thread.sleep(2000);

        }finally {
            latch.countDown();
        }
        return "ok";
    }

}

// countDownLatch is not reusable, once the count is zero
// only for simplicity we use.


