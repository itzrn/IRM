import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class T028_CompletableFuture {
    public static void main(String[] args) {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(()->{ // by default it is an deman thread(Means the main thread will not wait for the completion of this particular thread)
            try {
                Thread.sleep(5000);
                System.out.println("Worker f1");
            }catch(Exception e) {

            }

            return "ok";
        });

//		String str = f1.get(); // after this the main thread will wait for the f1 thread to get complete
//		System.out.println(str);

//		String s = f1.getNow("noo"); // as we didn't do get the main thread will not wait for the f1 thread and when the compiler come at this line it print noo bcz the thread haven't yet completed
//		System.out.println(s);


        Executor executor = Executors.newFixedThreadPool(3);
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(5000);
                System.out.println("Worker f2");
            }catch(Exception e) {

            }

            return "ok";
        }, executor); // now here taking the control on thread management more


//		CompletableFuture<Void> f = CompletableFuture.allOf(f1, f2);
//		f.join();





        System.out.println("Main");
    }

}


// This was introduced in java8 to handle asynchronous programming
// CompletableFuture ma asynchronous task ko run karaya jata hai, jo future me return hota hai asyncly

/*'
 * By Default, Completable future tasks often run on daemon  threads due to the use of ForkJoinPool.commonPool
 * You can control the thread type by providing a custom executor service.
 * The CompletableFuture task itself doesn't dictate whether it's a daemon or user thread.
 */
 
 
 
 
 