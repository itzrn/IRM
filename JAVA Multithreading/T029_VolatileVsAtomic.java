public class T029_VolatileVsAtomic {
    public static void main(String[] args) {
        T029_SharedResource obj = new T029_SharedResource();
        Thread writeThread = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            obj.setFlagTrue();
        });

        Thread readerThread = new Thread(()->{
            obj.printIfFlagTrue();
        });

        writeThread.start();
        readerThread.start();
    }
}

class T029_SharedResource{
    private boolean flag=false;
    public void setFlagTrue() {
        System.out.println("Writer Thread Made the flag true");
        this.flag=true;
    }
    public void printIfFlagTrue() {
        while(!flag) {
            // do nothing
            // readerThread will stuck here in the loop even of the flag gets true by writer thread
            // the reason is every thread keeps the local copy of each variable saved in there cached and refer it through the task process
        }

        System.out.println("Flag is True");
    }
}


