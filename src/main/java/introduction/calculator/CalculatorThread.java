package introduction.calculator;

import java.math.BigInteger;
import javax.swing.*;

public class CalculatorThread extends Thread{

  private JTextField firstField;
  private JTextField secondField;
  private JLabel result;

  public CalculatorThread(JTextField firstField, JTextField secondField, JLabel result) {
    this.firstField = firstField;
    this.secondField = secondField;
    this.result = result;
    this.setName("The Best Thread");
  }

  @Override
  public void run() {

    Long firstValue = Long.parseLong(firstField.getText());
    Long secondValue = Long.parseLong(secondField.getText());

    BigInteger accumulator = new BigInteger("0");

    // Inefficient calculator to test
    for (int i = 0; i < firstValue; i++) {
      for (int j = 0; j < secondValue; j++) {
        accumulator = accumulator.add(new BigInteger("1"));
      }
    }

    this.result.setText(accumulator.toString());

  }
}
