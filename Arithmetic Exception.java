import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntegerDivisionApp extends JFrame {

    private JTextField num1Field;
    private JTextField num2Field;
    private JTextField resultField;
    private JButton divideButton;

    public IntegerDivisionApp() {
        initializeUI();
        addComponentsToFrame();
        attachButtonListener();
    }

    private void initializeUI() {
        setTitle("Integer Division Calculator");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));
    }

    private void addComponentsToFrame() {
        JLabel num1Label = new JLabel("Num1:");
        num1Field = new JTextField();

        JLabel num2Label = new JLabel("Num2:");
        num2Field = new JTextField();

        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);

        divideButton = new JButton("Divide");

        add(num1Label);
        add(num1Field);
        add(num2Label);
        add(num2Field);
        add(resultLabel);
        add(resultField);
        add(new JLabel()); // Empty label for formatting
        add(divideButton);
    }

    private void attachButtonListener() {
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(num1Field.getText());
                    int num2 = Integer.parseInt(num2Field.getText());

                    if (num2 == 0) {
                        throw new ArithmeticException("Cannot divide by zero!");
                    }

                    int result = num1 / num2;
                    resultField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    showMessageDialog("Error: Please enter valid integers for Num1 and Num2.");
                } catch (ArithmeticException ex) {
                    showMessageDialog("Error: " + ex.getMessage());
                }
            }
        });
    }

    private void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
     
            IntegerDivisionApp app = new IntegerDivisionApp();
            app.setVisible(true);
 
    }
}
}
