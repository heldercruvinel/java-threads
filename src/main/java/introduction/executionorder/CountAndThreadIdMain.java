package introduction.executionorder;

public class CountAndThreadIdMain {

  public static void main(String[] args) {

    Thread firstThread = new Thread(new CountAndThreadId(), "FirstThread");
    Thread secondThread = new Thread(new CountAndThreadId(), "SecondThread");

    firstThread.start();
    secondThread.start();
  }
}
