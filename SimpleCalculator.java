import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    private JFrame frame;
    private JTextField displayField;
    private double currentValue;
    private String operator;

    public SimpleCalculator() {
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setEditable(false);
        frame.add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        String[] buttonLabels = {"7", "8", "9", "/",
                                 "4", "5", "6", "*",
                                 "1", "2", "3", "-",
                                 "C", "0", "=", "+"};

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.matches("[0-9]")) {
                displayField.setText(displayField.getText() + command);
            } else if (command.equals("C")) {
                displayField.setText("");
                currentValue = 0;
                operator = null;
            } else if (command.matches("[+\\-*/]")) {
                currentValue = Double.parseDouble(displayField.getText());
                operator = command;
                displayField.setText("");
            } else if (command.equals("=")) {
                try {
                    double secondValue = Double.parseDouble(displayField.getText());
                    double result = calculate(currentValue, secondValue, operator);
                    displayField.setText(String.valueOf(result));
                } catch (NumberFormatException | ArithmeticException ex) {
                    displayField.setText("Error");
                }
            }
        }

        private double calculate(double a, double b, String op) {
            switch (op) {
                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "*":
                    return a * b;
                case "/":
                    if (b != 0) {
                        return a / b;
                    } else {
                        throw new ArithmeticException("Division by zero");
                    }
                default:
                    throw new IllegalArgumentException("Invalid operator");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleCalculator());
    }
}
