package introduction.synchronizedexecution;

public class CreditCardPayment implements Runnable {

  private StoreActions storeActions;
  public CreditCardPayment(StoreActions storeActions) {
    this.storeActions = storeActions;
  }

  @Override
  public void run() {
    this.storeActions.creditCardPayment();
  }
}
