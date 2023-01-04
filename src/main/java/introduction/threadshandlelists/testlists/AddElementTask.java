package introduction.threadshandlelists.testlists;

public class AddElementTask implements Runnable {
  private List list;
  private int threadNumber;

  public AddElementTask(List list, int threadNumber) {
    this.list = list;
    this.threadNumber = threadNumber;
  }

  @Override
  public void run() {

    for (int i = 0; i < 100; i++) {
      list.addElement("Thread -> " + threadNumber + ", Adding -> " + i);
    }
  }
}
