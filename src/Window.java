import javax.swing.*;

public class Window {
    private final JFrame window;

    Window(String title) {
        window = new JFrame(title);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setSize(400, 400);
        window.setLayout(null);
    }

    void createDesktop() {
        Icon icon = new ImageIcon("src/assets/calc.png");
        JButton button = new JButton(icon);
        Calculator calc = new Calculator();
        calc.makeUI();
        button.setBounds(10, 10, 30, 40);
        window.add(button);
        button.setFocusable(false);
        button.addActionListener(e -> calc.setVisible(!calc.isVisible()));
        window.setVisible(true);//do this after u are done modifying the UI
        //otherwise you need to call `window.repaint()` since you just added a button to the UI
    }
}