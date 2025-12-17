class SharedResource{
    private int data;
    private boolean hasData=false; // the data should be consumed or produce when the data is available

    public synchronized void produce(int value){
        while (hasData){
            try{
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        data=value;
        hasData=true;
        System.out.println("Produced: "+value);
        notify();
    }

    public synchronized int consume(){
        while (!hasData){
            try{
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        hasData=false;
        System.out.println("Consumed: "+data);
        notify();
        return data;
    }
}

class Producer implements Runnable{
    private SharedResource sharedResource;
    Producer(SharedResource sharedResource){
        this.sharedResource=sharedResource;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            sharedResource.produce(i);
        }
    }
}

class Consumer implements Runnable{
    private SharedResource sharedResource;
    Consumer(SharedResource sharedResource){
        this.sharedResource=sharedResource;
    }
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            sharedResource.consume();
        }
    }
}

public class T016_ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();
    }
}

// .wait -> mean to release the lock by current thread and wait until and unless the other thread get over or won't call the .notify or .notifyAll
// .notify
// .notifyALl

// these are the function used for inter Thread communication
// these methods can be called in a synchronized call

