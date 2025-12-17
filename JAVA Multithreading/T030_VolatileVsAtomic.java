public class T030_VolatileVsAtomic {
    public static void main(String[] args) {
        T030_SharedResource obj = new T030_SharedResource();
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

class T030_SharedResource{
    private volatile boolean flag=false;  // making volatile allows the thread to read and write from the main memory
    public void setFlagTrue() {
        System.out.println("Writer Thread Made the flag true");
        this.flag=true;
    }
    public void printIfFlagTrue() {
        while(!flag) {
            // do nothing

        }

        System.out.println("Flag is True");
    }
}


