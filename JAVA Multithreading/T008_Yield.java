public class T008_Yield extends Thread{
    public T008_Yield(String name) {
        // TODO Auto-generated constructor stub
        super(name);
    }
    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println(Thread.currentThread().getName() + " ... is Running");
            // after every iteration will tell scheduler to give the chance to other thread also using yield method
            Thread.yield();
        }
    }
}
