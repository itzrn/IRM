
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class T020_Future {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(()-> 42);

        System.out.println(future.get()); // wait if necessary for the computation to complete, and then retrieves its result

        if(future.isDone()) { // return true of the task is completed
            // Completion may be due to normal termination, an execution or cancellation
            System.out.println("Task is Done ....");
        }
        executorService.shutdown();
    }
}
