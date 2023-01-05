package introduction.synchronizedexecution;

public class FixingPaymentSystem implements Runnable {
  private StoreActions storeActions;

  public FixingPaymentSystem(StoreActions storeActions) {
    this.storeActions = storeActions;
  }

  @Override
  public void run() {

    while(true) {
      this.storeActions.fixPaymentSystem();

      try {
        Thread.sleep(20000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
