import org.w3c.dom.ls.LSOutput;

import javax.lang.model.type.NullType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator extends JFrame {
    private boolean isVisible;
    private final ArrayList<JButton> buttons = new ArrayList<JButton>(11);
    private final ArrayList<JButton> operators = new ArrayList<JButton>(4);
    public String operator;
    JButton result;
    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();
    JTextField input = new JTextField();
    String inputField = "";
    private double firstNum = 0.0;
    
    public Calculator() {
        this.setSize(200, 200);
        this.setTitle("Calculator");
    }
    public void setVisibility( boolean logic){
        this.isVisible = logic;
    }
    public boolean getVisibility(){
        return this.isVisible;
    }
    public void setFirstNum(double number){
        this.firstNum = number;
    }
    public double getFirstNum(){
        return this.firstNum;
    }

    public void makeUI(){
        for (int i = 0; i < 10; i++){
            JButton buttonsi = new JButton(new String(String.valueOf(i)));
            buttonsi.setFocusable(false);
            buttons.add(buttonsi);
        }
        JButton buttons11 = new JButton(".");
        buttons.add(buttons11);

        this.setLayout(grid);

        // This creates the layout for the buttons
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        this.add(input,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0;
        constraints.gridwidth = 1;
        this.add(buttons.get(7),constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 0;
        this.add(buttons.get(8),constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.weightx = 0;
        this.add(buttons.get(9),constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 0;
        this.add(buttons.get(4),constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx = 0;
        this.add(buttons.get(5),constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.weightx = 0;
        this.add(buttons.get(6),constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.weightx = 0;
        this.add(buttons.get(1),constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.weightx = 0;
        this.add(buttons.get(2),constraints);

        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.weightx = 0;
        this.add(buttons.get(3),constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        this.add(buttons.get(0),constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        this.add(buttons.get(10),constraints);

        // this layout is for the operators
        operators.add(0,new JButton("/"));
        operators.add(1,new JButton("*"));
        operators.add(2,new JButton("-"));
        operators.add(3,new JButton("+"));

        constraints.gridx = 3;
        constraints.gridy = 1;
        this.add(operators.get(0),constraints);

        constraints.gridx = 3;
        constraints.gridy = 2;
        this.add(operators.get(1),constraints);

        constraints.gridx = 3;
        constraints.gridy = 3;
        this.add(operators.get(2),constraints);

        constraints.gridx = 3;
        constraints.gridy = 4;
        this.add(operators.get(3),constraints);

        // this is for the result
        result = new JButton("=");
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 4;
        this.add(result,constraints);

        createActionListeners();
    }
    void createActionListeners(){
        for(JButton button:buttons){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    inputField = input.getText()+ button.getText();
                    input.setText(inputField);
                }
            });
        }

        for (JButton op: operators){
            op.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    firstNum = Double.parseDouble(input.getText());
                    setFirstNum(firstNum);
                    operator = op.getText();
                    input.setText("");
                }
            });
        }
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double secondNum = 0.0;
                try{
                    secondNum = Double.parseDouble(input.getText());
                }
                catch (Exception a){
                    a.getStackTrace();
                }
                double equals;
                switch(operator){
                    case "+" -> equals = firstNum + secondNum;
                    case "-" -> equals = firstNum - secondNum;
                    case "*" -> equals = firstNum * secondNum;
                    case "/" -> equals = firstNum / secondNum;
                    default -> equals = 0.0;
                }
                input.setText(String.valueOf(equals));
            }
        });
    }
}
