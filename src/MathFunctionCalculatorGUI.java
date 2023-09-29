import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MathFunctionCalculatorGUI {

    private final MathFunctionCalculator calculator;
    private JTextField num1Field, num2Field, resultField;
    private JTextArea outputArea;

    public MathFunctionCalculatorGUI() {
        calculator = new MathFunctionCalculator();

        // Create and configure the JFrame
        JFrame frame = new JFrame("Math Function Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);

        // Create and configure the JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.setBackground(Color.pink); // Set your desired color here


        // Create and configure input fields
        JLabel num1Label = new JLabel("Enter your first number:");
        num1Field = new JTextField();
        JLabel num2Label = new JLabel("Enter your second number:");
        num2Field = new JTextField();
        JLabel resultLabel = new JLabel("Enter the desired result:");
        resultField = new JTextField();

        // Create and configure the output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Create and configure the Calculate button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        // Add components to the panel
        panel.add(num1Label);
        panel.add(num1Field);
        panel.add(num2Label);
        panel.add(num2Field);
        panel.add(resultLabel);
        panel.add(resultField);
        panel.add(calculateButton);

        // Add the panel and scroll pane to the frame
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }

    private void calculate() {
        try {
            int num1 = Integer.parseInt(num1Field.getText());
            int num2 = Integer.parseInt(num2Field.getText());
            int result = Integer.parseInt(resultField.getText());

            String operations = calculator.mathFunction(num1, num2, result).toString();

            if (operations.contains("None")) {
                outputArea.setText("No matching operations found.");
            } else {
                outputArea.setText("Matching operations: " + String.join(", ", operations));
            }
        } catch (NumberFormatException ex) {
            outputArea.setText("Invalid input. Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MathFunctionCalculatorGUI();
            }
        });
    }
}
