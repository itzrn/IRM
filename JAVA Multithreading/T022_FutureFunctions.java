
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class T022_FutureFunctions {
    public static void main(String[] args) {
        ExecutorService exService = Executors.newSingleThreadExecutor();
        Future<Integer> future = exService.submit(()->{
            try {
                Thread.sleep(2000);
            }catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
            return 42;
        });

//		Integer i = null;
//
//		try {
//			i = future.get(1, TimeUnit.SECONDS); // this is like if the ans gets in 1 sec then on else it will throw TimeoutException
//			System.out.println(future.isDone());
//			System.out.println(i);
//		}catch (InterruptedException | ExecutionException | TimeoutException e) {
//			// TODO: handle exception
//			System.out.println("Exception Occured -> "+e);
//		}


        future.cancel(true); // this is like if you want to cancel any thread
        // if true
        // 		then that task will get cancel doesn't matter the task is in running phase or not
        // if false
        // 		then if the task is in running phase then do not interrupt
        System.out.println(future.isCancelled()); // if false is given then future.cancelled will get mark as true, but in the backend the task will take its own time and complete the task
        System.out.println(future.isDone());


        exService.shutdown();
    }
}
