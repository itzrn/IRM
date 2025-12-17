
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T020_WithExecutorFramework {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(9); // this is the count of number of threads

        for(int i=1; i<=10; i++) {
            int finalI = i;
            executor.submit(()->{
                long res = factorial(finalI);
                System.out.println(res);
            });
        }
        executor.shutdown(); // -> started not to except the new tasks and orderly started to shutdown

        try {
            executor.awaitTermination(100, TimeUnit.SECONDS);
            // this will wait till 100 second that all threads complete there tasks and then main thread will get end
            // if it takes more than 100 seconds to complete then it main thread will automatically get end


            // when you want to wait for unlimited time
//			while(!executor.awaitTermination(1, TimeUnit.SECONDS)) {
//				System.out.println("Waiting ...");
//			}
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Total Time : "+(System.currentTimeMillis()-startTime));
    }

    private static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long res=1;
        for(int i=1; i<=n; i++) {
            res *= i;
        }
        return res;
    }

}


// ExecutorService extends Executor interface providing more functionality




