package introduction;

public class Introduction {

  public static void main(String[] args) throws InterruptedException {

    // WITH JCONSOLE WE CAN TO ANALYZE THE THREADS AND OTHERS PARAMETERS
    // IN JAVA WE ALLWAYS USE THREADS, EVEN WE DON'T CREATE ONE
    System.out.println("Main thread!");

    Thread.sleep(60000);
  }
}
