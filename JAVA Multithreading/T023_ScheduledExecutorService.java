import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class T023_ScheduledExecutorService {
    public static void main(String[] args) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // using runnable
        scheduler.schedule(()->System.out.println("Task executed after 5 sec delay"), 5, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(
                ()->System.out.println("Task executed after every 5 sec delay"),
                5,
                5,
                TimeUnit.SECONDS);

        scheduler.shutdown();

    }
}

