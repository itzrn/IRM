public class T010_SyncCounter {
    private int count=0;
    public synchronized void increment() {
        count++;

        // if we want to set synchronized just some piece of code a function then we can put that thing in synchronized block
//		synchronized (this) { // these type of section is called critical section and this condition is called mutual exclusion
//			count++;
//		}
    }
    public int getCount() {
        return count;
    }
}

// applying synchronized its like when a thread is using that resource then while that time the thread put the lock shouldn't be any other thread that can access
// there are two types of lock
// -> Intrinsic
// 		These are built into every object in java.
//		You don't see them but they are there.
// 		When you use the synchronized keyword, you're using these automatic lock

//-> Explicit
// 		These are more advance lock you can control yourself using the Lock class from java.util.concurrent.locks.
// 		You can explicitly say when to lock and when not to.

