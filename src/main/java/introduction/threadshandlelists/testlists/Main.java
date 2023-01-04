package introduction.threadshandlelists.testlists;

public class Main {

  public static void main(String[] args) throws InterruptedException {

    List list = new List();

    for (int i = 0; i < 10; i++) {
      new Thread(new AddElementTask(list, i)).start();
    }
    
    Thread.sleep(2000);

    for (int i = 0; i < list.length(); i++) {
      /**
       *  In final result we can see a lot of "null" elements
       *  this happens because thread are running parallel
       *  causing conflict, when a "null" element happens, is because
       *  two or more threads filled a unique index at the same time
       *  incrementing the next index twice or more, and these indexes
       *  become a null element.
       *  To solve this problem, we can use the synchronized method.
       * */
      System.out.println(i + " - " + list.getElement(i));
    }

  }
}
