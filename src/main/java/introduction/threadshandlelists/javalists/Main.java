package introduction.threadshandlelists.javalists;

import java.util.List;
import java.util.Vector;

public class Main {

  public static void main(String[] args) throws InterruptedException {

    /**
     * The Collections API have a lot of interfaces and implementations.
     * In Collections API, we have four principal interfaces: java.util.Collection, java.util.List, java.util.Set e java.util.Map
     * for each one these, we have safe thread implementations
     *
     * for Map -> Map mapaThreadSafe = new Hashtable();
     *      or //from java.util.concurrent package
     *      Map mapaThreadSafe = new ConcurrentHashMap();
     *
     * for Set -> Set conjunto = Collections.synchronizedSet(new HashSet());
     * */

    /**
     * Default List<> class is not synchronized
     * to use a List synchronized we need to use a Collections.synchronizedList(new ArrayList<>())
     * or a Vector() class
     * */
//    List<String> list = new ArrayList<>();
//    List<String> list = Collections.synchronizedList(new ArrayList<>());
    List<String> list = new Vector<>();

    for (int i = 0; i < 10; i++) {
      new Thread(new AddElementTask(list, i)).start();
    }
    
    Thread.sleep(2000);

    for (int i = 0; i < list.size(); i++) {
      /**
       *  In final result we can see a lot of "null" elements
       *  this happens because thread are running parallel
       *  causing conflict, when a "null" element happens, is because
       *  two or more threads filled a unique index at the same time
       *  incrementing the next index twice or more, and these indexes
       *  become a null element.
       *  To solve this problem, we can use the synchronized method.
       * */
      System.out.println(i + " - " + list.get(i));
    }

  }
}
