package unipi.iatriki_plhroforikh.fotis.mathima1_part2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 1st step: Add new GUI Form on package:
//      Right click on 'src/unipi/iatriki_plhroforikh/fotis/mathima1_part1' > 'New' > 'Swing UI Designer' > 'GUI Form'
// 2nd step: Set field name to JPanel - FormLogin.form
// 3rd step: Add components on the JPanel - FormLogin.form
// 4th step: Set field name to JLabel - FormLogin.form
// 5th step: Extend FormLogin with JFrame - FormLogin.java
// 2nd step: Create constructor and configuration JPanel - FormLogin.java
// 3rd step: Create button1 addActionListener - FormLogin.java
// 4th step: Create main method and open new FormLogin - FormLogin.java

public class FormLogin extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JLabel label1;

    public FormLogin() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600,450));
        setContentPane(panel1);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = SQLiteMain.login(textField1.getText(),textField2.getText());
                label1.setText(String.valueOf(result));
            }
        });
    }

    public static void main(String[] args) {
        new FormLogin();
    }
}
