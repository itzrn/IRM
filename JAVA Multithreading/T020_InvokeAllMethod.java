
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class T020_InvokeAllMethod {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exService = Executors.newFixedThreadPool(3);

        // creating a thread which returns something
        Callable<Integer> collable1 = () -> 1;
        Callable<Integer> collable2 = () -> 2;
        Callable<Integer> collable3 = () -> 3;

        List<Callable<Integer>> list = Arrays.asList(collable1, collable2, collable3);


        List<Future<Integer>> futures = exService.invokeAll(list); // this will run a collection of threads and return the list of all thread return value
        // invokeAll block all the thread means main thread is need to wait for the completion of all the threads

//		List<Future<Integer>> futures = exService.invokeAll(list, 1, TimeUnit.SECONDS); -> this is another methods which take time
        // meaning the executor will work for given time and then get shutdown, doesn't matter all the threads completed there work or not
        // this should be handled as CancellationException

        for(Future<Integer> f:futures) {
            System.out.println(f.get());
        }

        exService.shutdown();

        System.out.println("Hello World");
    }
}


