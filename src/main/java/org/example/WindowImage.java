package org.example;

import javax.swing.*;

public class WindowImage extends JFrame {
    JLabel labelImage;
    public WindowImage(String title) {
        super(title);
        labelImage = new JLabel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
