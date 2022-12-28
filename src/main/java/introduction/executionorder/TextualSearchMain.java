package introduction.executionorder;

public class TextualSearchMain {

  public static void main(String[] args) {

    // JVM maps the Java thread to native system threads.
    // If the system not support native system threads, the JVM simulate a multi-thread environment, named Green Threads.
    // But this is not multi-thread in truth, only can be one process or thread running a time.

    String name = "da";

    // THE EXECUTION HAPPENS IN NOT ORDERED FORM
    Thread threadFirstFile = new Thread(new TextualSearchTask("textualSearchFiles/assinaturas1.txt", name));
    Thread threadSecondFile = new Thread(new TextualSearchTask("textualSearchFiles/assinaturas2.txt", name));
    Thread threadThirthFile = new Thread(new TextualSearchTask("textualSearchFiles/autores.txt", name));

    threadFirstFile.start();
    threadSecondFile.start();
    threadThirthFile.start();
  }
}
