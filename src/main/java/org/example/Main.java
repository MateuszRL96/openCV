package org.example;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Main extends PApplet {
    Mat img;
    PImage pimg;
    VideoCapture capture;
    //--cat
    Mat cat;
    PImage pcat;


    public void settings(){
        size(800,600);
        capture = new VideoCapture(0);
        if(!capture.isOpened()){
            System.out.println("Unable to open the camera");
            capture.release();
            System.exit(0);
        }
        img = new Mat();

        //--cat
        cat = new Mat();
        String filePath = "src/cat.jpg";
        cat = Imgcodecs.imread(filePath);
    }
    public void draw(){
        if(capture.read(img)){
            pimg = MatToPImage(img);
            image(pimg,400,0,400,300);
        }
        //--cat
        pcat = MatToPImage(cat);
        image(pcat,0,0,400,300);

    }
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        PApplet.main(Main.class.getName());

    }
    private static PImage MatToPImage(Mat mat){
        if(mat != null && !mat.empty()){
            MatOfByte matOfByte = new MatOfByte();
            Imgcodecs.imencode(".jpg", mat, matOfByte);
            byte[] byteArray = matOfByte.toArray();
            try {
                InputStream in = new ByteArrayInputStream(byteArray);
                BufferedImage bimg = ImageIO.read(in);
                PImage img = new PImage(bimg.getWidth(), bimg.getHeight(), PConstants.ARGB);
                bimg.getRGB(0,0,img.width, img.height, img.pixels, 0, img.width);
                img.updatePixels();
                bimg = null;
                return img;
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
