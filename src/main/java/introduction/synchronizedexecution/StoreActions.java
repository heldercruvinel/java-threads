package introduction.synchronizedexecution;

public class StoreActions {

  private boolean paymentSystemOut = true;

  // We can use th ReentrantLock class to lock the execution
//  private Lock lock = new ReentrantLock();

  public void creditCardPayment() {

    String name = Thread.currentThread().getName();
    System.out.println(name + " Trying do the payment");

    // With synchronized we can sync the Thread Execution
    // this modifier "synchronized is called MUTEX in Java"
    // We can use th ReentrantLock class to lock the execution

//    lock.lock();
    synchronized (this) {


      System.out.println(name + " get credit card");
      System.out.println(name + " insert into credit machine");
      System.out.println(name + " tap the password");
      System.out.println(name + " waiting the payment to be completed");

      while (this.paymentSystemOut) {
        paymentSystemOut();
      }

      sleepThread(5000);

      this.paymentSystemOut = true;

      System.out.println(name + " get out credit card from machine");
      System.out.println(name + " get the product");

      System.out.println(name + " ask for the printed check");
      System.out.println(name + " printing the check");
      sleepThread(5000);
      System.out.println(name + " get the check");
    }
//    lock.unlock();

  }

  public void pixPayment() {

    String name = Thread.currentThread().getName();
    System.out.println(name + " Trying do the payment");

//    lock.lock();
    synchronized (this) {

      System.out.println(name + " get smartphone");
      System.out.println(name + " access the bank app");
      System.out.println(name + " tap the pix key");
      System.out.println(name + " sending the payment");

      while (this.paymentSystemOut) {
        paymentSystemOut();
      }

      sleepThread(10000);

      this.paymentSystemOut = true;

      System.out.println(name + " get the product");

      System.out.println(name + " ask for the printed check");
      System.out.println(name + " printing the check");
      sleepThread(5000);
      System.out.println(name + " get the check");
    }
//    lock.unlock();
  }

  private static void sleepThread(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public void fixPaymentSystem() {
    synchronized (this) {

      String name = Thread.currentThread().getName();

      if(!this.paymentSystemOut) {
        return;
      }

      System.out.println(name + " Fixing the payment system");

      this.paymentSystemOut = false;

      sleepThread(15000);

      // To notify all threads that are waiting to continue there execution
      this.notifyAll();

      System.out.println(name + " Payment system fixed");
    }
  }

  private void paymentSystemOut() {
    try {

      System.out.println("Payment system OUT!!!!!");

      // WITH THIS COMMAND ".wait()" WE MAKE THE THREAD STAY WAITING UNTIL
      // THE SYSTEM SEND TO THREAD A COMMAND TO CONTINUE
      this.wait();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
