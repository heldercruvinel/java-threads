package introduction.synchronizedexecution;

public class SynchronizedExecutionStoreMain {

  public static void main(String[] args){

    StoreActions storeActions = new StoreActions();

    Thread clienteJohn = new Thread(new CreditCardPayment(storeActions), "John");
    // To set the priority of thread execution
    // but we can't confirm that priority
//    clienteJohn.setPriority(10);
    clienteJohn.setPriority(Thread.MAX_PRIORITY);

    Thread clienteMaria = new Thread(new PixPayment(storeActions), "Maria");
    // To set the priority of thread execution
    // but we can't confirm that priority
//    clienteMaria.setPriority(5);
    clienteMaria.setPriority(Thread.NORM_PRIORITY);

    Thread techSupport = new Thread(new FixingPaymentSystem(storeActions), "TechSupport");
    techSupport.setDaemon(true);
//    Thread clienteAlex = new Thread(new CreditCardPayment(storeActions), "Alex");
//    Thread clientePeter = new Thread(new CreditCardPayment(storeActions), "Peter");

    clienteJohn.start();
    clienteMaria.start();
    techSupport.start();
//    clienteAlex.start();
//    clientePeter.start();

  }
}
