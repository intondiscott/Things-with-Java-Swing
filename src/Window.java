import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    public Window() { }

    void makeWindow(){
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400,400);
        this.setLayout(null);
        this.setVisible(true);
        }
    void createDesktop(){
        Icon icon = new ImageIcon("src/assets/calc.png");
        JButton button = new JButton(icon);
        Calculator calc = new Calculator();
        calc.makeUI();
        button.setBounds(10,10,30,40);
        this.add(button);
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                while(!calc.getVisibility()) {
                    calc.setVisibility(true);
                    calc.setVisible(true);
                }
                if(calc.getVisibility()){
                    calc.setVisibility(false);
                }
            }
        });
        }
    }