package org.example;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;


public class Main {
    public static void main(String[] args) throws Exception {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        WindowImage fw = new WindowImage("Webcam Capture");
        VideoCapture capture = new VideoCapture(0);

        if(!capture.isOpened()){
            System.out.println("Unable to open the camera");
            capture.release();
            System.exit(0);
        }
        Mat frame = new Mat();

        while (true) {
            if (capture.read(frame)) {
                fw.setImage(frame);
            }
        }
    }
}
