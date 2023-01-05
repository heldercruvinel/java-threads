# Java Thread Studies
A thread is a thread of execution in a program. The Java Virtual Machine allows an application to have multiple threads of execution running concurrently.
Every thread has a priority. Threads with higher priority are executed in preference to threads with lower priority. Each thread may or may not also be marked as a daemon. When code running in some thread creates a new Thread object, the new thread has its priority initially set equal to the priority of the creating thread, and is a daemon thread if and only if the creating thread is a daemon.

When a Java Virtual Machine starts up, there is usually a single non-daemon thread (which typically calls the method named main of some designated class). The Java Virtual Machine continues to execute threads until either of the following occurs:

The exit method of class Runtime has been called and the security manager has permitted the exit operation to take place.
All threads that are not daemon threads have died, either by returning from the call to the run method or by throwing an exception that propagates beyond the run method.
- [Official Documentation](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html)

---

### Thread states

- **NEW** - A thread that has not yet started is in this state.
- **RUNNABLE** - A thread executing in the Java virtual machine is in this state.
- **BLOCKED** - A thread that is blocked waiting for a monitor lock is in this state.
- **WAITING** - A thread that is waiting indefinitely for another thread to perform a particular action is in this state. Called with `this.wait()`
- **TIMED_WAITING** - A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state. Called with `this.wait(milis)`
- **TERMINATED** - A thread that has exited is in this state.

---

### Difference Between Daemon and User Threads
Java offers two types of threads: user threads and daemon threads.

User threads are high-priority threads. The JVM will wait for any user thread to complete its task before terminating it.

On the other hand, daemon threads are low-priority threads whose only role is to provide services to user threads.

Since daemon threads are meant to serve user threads and are only needed while user threads are running, they won't prevent the JVM from exiting once all user threads have finished their execution.

That's why infinite loops, which typically exist in daemon threads, will not cause problems, because any code, including the finally blocks, won't be executed once all user threads have finished their execution. For this reason, daemon threads are not recommended for I/O tasks.

However, there are exceptions to this rule. Poorly designed code in daemon threads can prevent the JVM from exiting. For example, calling Thread.join() on a running daemon thread can block the shutdown of the application.
- [Baeldung](https://www.baeldung.com/java-daemon-thread)

---

### Implementation

There are two ways to create a new thread of execution. One is to declare a class to be a subclass of Thread. This subclass should override the run method of class Thread. An instance of the subclass can then be allocated and started. For example, a thread that computes primes larger than a stated value could be written as follows:


    class PrimeThread extends Thread {
    long minPrime;
    PrimeThread(long minPrime) {
    this.minPrime = minPrime;

    }
         public void run() {
             // compute primes larger than minPrime
              . . .
         }
     }
     

The following code would then create a thread and start it running:

     PrimeThread p = new PrimeThread(143);
     p.start();

The other way to create a thread is to declare a class that implements the Runnable interface. That class then implements the run method. An instance of the class can then be allocated, passed as an argument when creating Thread, and started. The same example in this other style looks like the following:

     class PrimeRun implements Runnable {
         long minPrime;
         PrimeRun(long minPrime) {
             this.minPrime = minPrime;
         }

         public void run() {
             // compute primes larger than minPrime
              . . .
         }
     }

The following code would then create a thread and start it running:

     PrimeRun p = new PrimeRun(143);
     new Thread(p).start();

Every thread has a name for identification purposes. More than one thread may have the same name. If a name is not specified when a thread is created, a new name is generated for it.

Unless otherwise noted, passing a null argument to a constructor or method in this class will cause a NullPointerException to be thrown.

