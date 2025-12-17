import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class T024_SchedulerAtFixedRate {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


        scheduler.scheduleAtFixedRate( // here overlapping is possible, suppose if the task take more than 10sec then this won't see that instead will start to do the next task after every 5 sec
                ()->System.out.println("Task executed after every 5 sec delay"),
                5,
                5,
                TimeUnit.SECONDS);

        scheduler.schedule(()->{
            System.out.println("Initiating ShutDown ...");
            scheduler.shutdown();
        }, 20, TimeUnit.SECONDS);


        // so when using scheduleAtFixedRate then we need to use another scheduler that delay the shutdown of the scheduler
    }
}


