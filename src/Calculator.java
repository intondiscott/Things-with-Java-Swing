import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Calculator extends JFrame {
    private double firstNum = 0.0;
    private String operator;

    private final JTextField input = new JTextField();
    private final ActionListener actionListener;
    private final Set<String> ops = new LinkedHashSet<>(List.of("/", "*", "-", "+"));

    public Calculator() {
        this.setTitle("Calculator");
        actionListener = e -> {
            final String text = e.getActionCommand();
            if (ops.contains(text)) {
                operator = text;
                firstNum = Double.parseDouble(input.getText());
                input.setText("");
            } else if (text.equals("=")) {
                final double secondNum = Double.parseDouble(input.getText());
                final double equals;
                switch (operator) {
                    case "+" -> equals = firstNum + secondNum;
                    case "-" -> equals = firstNum - secondNum;
                    case "*" -> equals = firstNum * secondNum;
                    case "/" -> equals = firstNum / secondNum;
                    default -> throw new UnsupportedOperationException();
                }
                input.setText(String.valueOf(equals));
            } else {
                input.setText(input.getText() + text);
            }
        };
    }

    void makeUI() {
        this.setLayout(new GridBagLayout());

        // This creates the layout for the buttons
        final var constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        this.add(input, constraints);

        constraints.weightx = 0;


        //number 1 through 9
        constraints.gridwidth = 1;
        for (var i = 1; i <= 9; i++) {
            constraints.gridy = 3 - (i - 1) / 3;
            constraints.gridx = i % 3 - 1;
            var buttonI = new JButton(String.valueOf(i));
            buttonI.addActionListener(actionListener);
            this.add(buttonI, constraints);
        }

        //number 0
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        var zeroButton = new JButton("0");
        zeroButton.addActionListener(actionListener);
        this.add(zeroButton, constraints);

        //decimal point
        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        var pointButton = new JButton(".");
        pointButton.addActionListener(actionListener);
        this.add(pointButton, constraints);


        // this layout is for the operators
        constraints.gridy = 0;
        for (var op : ops) {
            constraints.gridx = 3;
            constraints.gridy++;
            var operatorButton = new JButton(op);
            operatorButton.addActionListener(actionListener);
            this.add(operatorButton, constraints);
        }

        // this is for the result
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 4;
        var result = new JButton("=");
        this.add(result, constraints);
        result.addActionListener(actionListener);

        this.pack();
    }

}
