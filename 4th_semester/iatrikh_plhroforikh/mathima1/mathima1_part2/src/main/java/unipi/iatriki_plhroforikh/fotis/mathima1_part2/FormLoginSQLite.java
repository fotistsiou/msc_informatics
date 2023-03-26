package unipi.iatriki_plhroforikh.fotis.mathima1_part2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 1st step: Add new GUI Form on package:
//      Right click on 'src/unipi/iatriki_plhroforikh/fotis/mathima1_part2' > 'New' > 'Swing UI Designer' > 'GUI Form'
// 2nd step: Set field name to JPanel - FormLoginSQLite.form
// 3rd step: Add components on the JPanel - FormLoginSQLite.form
// 4th step: Set field name to JLabel - FormLoginSQLite.form
// 5th step: Extend FormLoginSQLite with JFrame - FormLoginSQLite.java
// 2nd step: Create constructor and configuration JPanel - FormLoginSQLite.java
// 3rd step: Create button1 addActionListener - FormLoginSQLite.java
// 4th step: Create main method and open new FormLoginSQLite - FormLoginSQLite.java

public class FormLoginSQLite extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JLabel label1;
    private JButton button2;
    private JLabel label2;

    public FormLoginSQLite() {
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
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = String.valueOf(SQLiteMain.selectStudentIds());
                label2.setText(result);
            }
        });
    }

    public static void main(String[] args) {
        new FormLoginSQLite();
    }
}
