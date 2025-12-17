public class T020_WithoutExecutorFramework {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread[] arr = new Thread[10];
        for(int i=1; i<=10; i++) {
            int finalI=i;
            arr[i-1] = new Thread(()->{
                long res = factorial(finalI);
                System.out.println(res);
            });

            arr[i-1].start();
        }

        for(Thread t:arr) {
            try {
                t.join();
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
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

// This framework is introduces in java 5 as a part of java concurrent package to simplify the development of concurrent application
// by abstracting away many of the complexities involved in creating and managing Threads.

// Problems before introduction of Executor class
// 		Manual Thread Management
//		Resource Management
// 		Scalability
// 		Thread reuse
//  	Error Handling


// Executor Framework have three core interface
// Executor
// ExecutorService
// ScheduldedExecutorService


