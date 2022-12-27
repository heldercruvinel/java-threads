package introduction.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonAction implements ActionListener {

  private JTextField firstField;
  private JTextField secondField;
  private JLabel result;

  public ButtonAction(JTextField firstField, JTextField secondField, JLabel result) {
    this.firstField = firstField;
    this.secondField = secondField;
    this.result = result;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    // We can use "anonymous classes" to create a thread
//    new Thread(new Runnable() {
//      @Override
//      public void run() {
//        System.out.println("resposta");
//      }
//    }).start();


    // To execute a runnable class
//    CalculatorRunnable calculatorRunnable = new CalculatorRunnable(this.firstField, this.secondField, this.result);
//    Thread threadCalculator = new Thread(calculatorRunnable, "Good Thread");
//    threadCalculator.start();

    // To execute a thread class
    CalculatorThread calculatorRunnable = new CalculatorThread(this.firstField, this.secondField, this.result);
    calculatorRunnable.start();
  }
}
