
class Pen1{
    public synchronized void writeWithPenAndPaper(Paper1 paper){
        System.out.println(Thread.currentThread().getName()+" is using pen "+this+" and trying to use paper");
        paper.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + " finished using pen "+this);
    }
}

class Paper1{
    public synchronized void writeWithPenAndPaper(Pen1 pen){
        System.out.println(Thread.currentThread().getName()+" is using paper "+this+" and trying to use pen");
        pen.finishWriting();
    }
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + " finished using paper "+this);
    }
}

class Task11 implements Runnable{
    private Pen1 pen;
    private Paper1 paper;

    public Task11(Pen1 pen, Paper1 paper){
        this.pen=pen;
        this.paper=paper;
    }
    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper);
    }
}

class Task21 implements Runnable{
    private Pen1 pen;
    private Paper1 paper;

    public Task21(Pen1 pen, Paper1 paper){
        this.pen=pen;
        this.paper=paper;
    }
    @Override
    public void run() {
        synchronized (pen){ // if pen is not lock then it will not lock the paper, this is how first thread 1 uses pen and paper then thread 2 uses
            paper.writeWithPenAndPaper(pen);
        }

    }
}
public class T015_ResolveDeadlock {
    public static void main(String[] args) {

        Pen1 pen = new Pen1();
        Paper1 paper = new Paper1();

        Thread t1 = new Thread(new Task11(pen, paper), "Thread-1");
        Thread t2 = new Thread(new Task21(pen, paper), "Thread-2");

        t1.start();
        t2.start();
    }
}