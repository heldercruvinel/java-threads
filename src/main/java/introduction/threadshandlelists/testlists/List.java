package introduction.threadshandlelists.testlists;

public class List {

  private String[] elements = new String[1000];
  private int index = 0;

  // synchronized to solve the concurrence problem
  // we ca use synchronized in the method signature
  // or using like a method with "this" like param
  public synchronized void addElement(String element) {

//    synchronized (this) {
      this.elements[index] = element;
      this.index++;
//    }
  }

  public int length() {
    return this.elements.length;
  }

  public String getElement(int position) {
    return this.elements[position];
  }
}
