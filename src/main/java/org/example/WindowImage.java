package org.example;

import org.opencv.core.Mat;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class WindowImage extends JFrame {
    JLabel labelImage;
    private BufferedImage Mat2BufferedImage(Mat matrix){
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if(matrix.channels() > 1){
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = matrix.channels() * matrix.cols() * matrix.rows();
        byte[] buffer = new byte[bufferSize];
        matrix.get(0, 0, buffer);
        BufferedImage image = new BufferedImage(matrix.cols(), matrix.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);
        return image;
    }
    public WindowImage(String title) {
        super(title);
        labelImage = new JLabel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(labelImage);
        setVisible(true);
    }

    public void setImage(Mat matImage){
        Image image = Mat2BufferedImage(matImage);
        ImageIcon imgIcon = new ImageIcon(image);
        setSize(matImage.cols(), matImage.rows());
        labelImage.setIcon(imgIcon);
        labelImage.repaint();
    }
}
