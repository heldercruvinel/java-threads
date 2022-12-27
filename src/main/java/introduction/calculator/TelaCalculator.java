package introduction.calculator;

import javax.swing.*;

public class TelaCalculator {

  public static void main(String[] args) {

    JFrame window = new JFrame("Calculator");

    JTextField firstField = new JTextField(10);
    JTextField secondField = new JTextField(10);
    JButton button = new JButton(" = ");
    JLabel result = new JLabel("           ?           ");

    // USING "JCONSOLE" ON TERMINAL YOU CAN SEE ALL THREADS CREATED
    button.addActionListener(new ButtonAction(firstField, secondField, result));

    JPanel panel = new JPanel();
    panel.add(firstField);
    panel.add(new JLabel("x"));
    panel.add(secondField);
    panel.add(button);
    panel.add(result);

    window.add(panel);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.pack();
    window.setVisible(true);
  }
}
