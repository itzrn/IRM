import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T021_InvokeAnyMethod {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<Integer> callable1 = () -> {
            System.out.println("Callable 1");
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            System.out.println("Callable 2");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            System.out.println("Callable 3");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);

        try {
            // this gives direct integer, for the thread which get complete first
            Integer i = executor.invokeAny(list);

            // as we took two threads in Thread pool then two thread will get execute but the executor will return one value which gets complete first
            System.out.println(i);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        executor.shutdown();
        System.out.println("Aryan Prajapati");
    }
}
