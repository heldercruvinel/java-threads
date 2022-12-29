package introduction.synchronizedexecution;

public class SynchronizedExecutionStoreMain {

  public static void main(String[] args){

    StoreActions storeActions = new StoreActions();

    Thread clienteJohn = new Thread(new CreditCardPayment(storeActions), "John");
    Thread clienteMaria = new Thread(new PixPayment(storeActions), "Maria");
    Thread clienteAlex = new Thread(new CreditCardPayment(storeActions), "Alex");
    Thread clientePeter = new Thread(new CreditCardPayment(storeActions), "Peter");

    clienteJohn.start();
    clienteMaria.start();
    clienteAlex.start();
    clientePeter.start();

  }
}
