package introduction.threadshandlelists.javalists;

import java.util.List;

public class AddElementTask implements Runnable {
  private List<String> list;
  private int threadNumber;

  public AddElementTask(List<String> list, int threadNumber) {
    this.list = list;
    this.threadNumber = threadNumber;
  }

  @Override
  public void run() {

    for (int i = 0; i < 100; i++) {
      list.add("Thread -> " + threadNumber + ", Adding -> " + i);
    }
  }
}
