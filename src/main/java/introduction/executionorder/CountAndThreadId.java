package introduction.executionorder;

public class CountAndThreadId implements Runnable{

  @Override
  public void run() {
    for (int i = 1; i <= 1000; i++) {
      Thread scopeThread = Thread.currentThread();
      System.out.println(
          "Thread name: " +
          scopeThread.getName() +
          " - Thread Id: " +
          scopeThread.getId() +
          ", Number: " +
          i
      );
    }
  }
}
