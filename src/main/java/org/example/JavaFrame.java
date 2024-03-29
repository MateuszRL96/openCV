package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaFrame extends JFrame {
    JLabel labelMessage;
    JTextField txtFieldInput;
    JButton btnClick;
    JPanel p1, p2, p3;

    public JavaFrame(String title){
        super(title);
        setSize(480,480);
        setLayout(new GridLayout(3,1,5,5));

        labelMessage = new JLabel("elo elo elo");
        txtFieldInput = new JTextField(20);
        btnClick = new JButton("CLICK");

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        p1.add(labelMessage);
        p2.add(txtFieldInput);
        p3.add(btnClick);

        add(p1);
        add(p2);
        add(p3);
        btnClick.addActionListener(new ButtonHandler());
    }
    public class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnClick){
                JOptionPane.showMessageDialog(null, "hello " + txtFieldInput.getText());
                labelMessage.setText("Hello " + txtFieldInput.getText());
            }
        }
    }
    /*
    JavaFrame frame = new JavaFrame("Go go go!");
        frame.setVisible(true);
     */

}
