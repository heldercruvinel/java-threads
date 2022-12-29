package introduction.synchronizedexecution;

public class PixPayment implements Runnable {

  private StoreActions storeActions;
  public PixPayment(StoreActions storeActions) {
    this.storeActions = storeActions;
  }

  @Override
  public void run() {
    this.storeActions.pixPayment();
  }
}
