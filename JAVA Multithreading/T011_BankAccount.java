import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T011_BankAccount {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName()+" attmpting to withdraw "+amount);

//		This is when you are using synchronized
//		if(amount <= balance) {
//			System.out.println(Thread.currentThread().getName()+" proceeding with withdrawal "+amount);
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			balance -= amount;
//			System.out.println(Thread.currentThread().getName()+" Completed withdrawal. Remaining balance "+balance);
//		}else {
//			System.out.println(Thread.currentThread().getName()+" insufficient balance ");
//		}





//		if(lock.tryLock()) {
//
//		}





        try {

            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if(balance>=amount) {
                    try {
                        System.out.println(Thread.currentThread().getName()+" proceeding with withdrawal "+amount);
                        Thread.sleep(10000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName()+" Completed withdrawal. Remaining balance "+balance);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        Thread.currentThread().interrupt();
                    }finally {
                        lock.unlock();
                    }

                }else {
                    System.out.println(Thread.currentThread().getName()+" insufficient balance ");
                }
            }else {
                System.out.println(Thread.currentThread().getName()+" Could not accquire the lock will try again later ");
            }

        }catch (Exception e) {
            // TODO: handle exception
            Thread.currentThread().interrupt(); // good practice to put this to make other thread know that the particular resource is in used
        }

        // if interrupted you can do things here
        if(Thread.currentThread().isInterrupted()) {
            // can be done something different things here
        }

    }
}

// lock.tryLock() without time parameter -> suppose one thread is using resource and at the same time another thread came and
// 											found resource is in used then it will directly get invoked
// lock.tryLock() with time parameter (need to put in try catch) -> suppose one thread is using resource and at the same time another thread came and found
// 										 resource is in used then it will wait for the given time and after that time still the
//  									 resource is in used then it get directly invoke else uses the resource









