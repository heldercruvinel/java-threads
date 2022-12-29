package introduction.synchronizedexecution;

import java.awt.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StoreActions {

  // We can use th ReentrantLock class to lock the execution
  private Lock lock = new ReentrantLock();

  public void creditCardPayment() {

    // With synchronized we ca sync the Thread Execution
    // this modifier "synchronized is called MUTEX in Java"
    // We can use th ReentrantLock class to lock the execution

    lock.lock();
//    synchronized (this) {
      String name = Thread.currentThread().getName();

      System.out.println(name + " get credit card");
      System.out.println(name + " insert into credit machine");
      System.out.println(name + " tap the password");
      System.out.println(name + " waiting the payment to be completed");

      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      System.out.println(name + " get out credit card from machine");
      System.out.println(name + " get the product");

      this.CheckPaymentPrint();
//    }
    lock.unlock();

  }

  public void pixPayment() {

    lock.lock();
//    synchronized (this) {
      String name = Thread.currentThread().getName();

      System.out.println(name + " get smartphone");
      System.out.println(name + " access the bank app");
      System.out.println(name + " tap the pix key");
      System.out.println(name + " sending the paiyment");
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      System.out.println(name + " get the product");

      this.CheckPaymentPrint();
//    }
    lock.unlock();
  }

  private void CheckPaymentPrint() {
    String name = Thread.currentThread().getName();

    System.out.println(name + " ask for the printed check");
    System.out.println(name + " printing the check");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(name + " get the check");
  }
}
