public class T001_Dummy {
    public static void main(String[] args) {
        System.out.println("This is a Dummy Class");

    }
}

// CPU -  The brain of Computer like -> intel AMD
// Core is an individual processing unit within a CPU. This is the place where actual processing happens.
// Modern CPU have multiple cores in it.
// A quad-core processor have 4 core, allowing to perform 4 task simultaneously.

// A program is a set of instructions that is performed to do the specific task
// A process is an instance of program in operating system

// A thread is a smallest unit of execution within a process.
// A process can have multiple thread, which share the same resources but can run independently

// Multitasking allows an operating system to run multiple processes simultaneously.
// On single Core CPU, this is done through time sharing, rapidly switching between tasks.
// On multi-Core CPUs true parallel execution happen, with task executed across cores.
// The OS Scheduler balances the load, ensuring efficient and responsive system performance.

// Multithreading refers to the ability to execute multiple threads within a single process concurrently

// The JVM can distribute thread across multiple cores, allowing true parallel execution of threads.

// main thread begins to run immediately when java program starts.