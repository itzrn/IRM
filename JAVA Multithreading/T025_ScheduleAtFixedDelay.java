import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class T025_ScheduleAtFixedDelay {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


        scheduler.scheduleWithFixedDelay( // here is no overlapping
                ()->System.out.println("Task executed after every 5 sec delay"),
                5,
                5,
                TimeUnit.SECONDS); // this is ek task khatam hone ke baad kitna intezar kare to start the next task

        scheduler.schedule(()->{
            System.out.println("Initiating ShutDown ...");
            scheduler.shutdown();
        }, 20, TimeUnit.SECONDS);
    }
}


// we have another function
// newCachedThreadPool() -> ek thread pool banata hai jaha par new threads create krte hai jarurat ke according, or agar koi thread ki jarurat nhi hai toh usko terminate kr deta hau in 60 secs after activity,
// so this basically dynamically adjust the thread pool size

