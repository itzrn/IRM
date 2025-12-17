public class T011_Main {
    public static void main(String[] args) {
        T011_BankAccount bankAccount = new T011_BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                bankAccount.withdraw(50);
            }
        };

        Thread t1  = new Thread(task, "Thread 1");
        Thread t2  = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
    }
}

// now we will use our custom lock -> why
// suppose there is a synchronized function which is taking indefinite time to get complete due to some issue
// then it will go on and on which other thread will wont able to access the resource due to the implicit present of lock by synchronized


