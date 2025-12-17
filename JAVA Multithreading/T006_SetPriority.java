public class T006_SetPriority extends Thread{
    T006_SetPriority(String name){
        super(name);
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println(Thread.currentThread().getName() + " -Priority " + Thread.currentThread().getPriority() + " -count "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
