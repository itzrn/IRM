
public class T004_ThreadState extends Thread{

    @Override
    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) throws InterruptedException {
        T004_ThreadState t1 = new T004_ThreadState();
        System.out.println(t1.getState());

        t1.start();

        System.out.println(t1.getState());

        Thread.sleep(100); // the thread which making this function to run, and this particular line is written then that particular thread will get in sleep for some time as metnioned.

        System.out.println(t1.getState());// this is getting print by the main thread about the thread t1
        t1.join();

        System.out.println(t1.getState());
    }
}

// Thread is extended when the class won't extends any other class
// when the class extends any other class then Runnable comes to implement multi threading

