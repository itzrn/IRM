public class T005_EssentialMethodThread extends Thread{
    @Override
    public void run() {
        System.out.println("T005_EssentialMethodThread is Running ...");

        for(int i=0; i<10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println();
            }
            System.out.println(i);
        }
    }
}


