public class T010_SyncThread extends Thread{
    private T010_SyncCounter counter;
    public T010_SyncThread(T010_SyncCounter counter, String name) {
        super(name);
        this.counter=counter;
    }
    @Override
    public void run() {
        for(int i=0; i<1000; i++) {
            counter.increment();
        }
    }
}

