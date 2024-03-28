package org.example;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import processing.core.PApplet;


public class Main extends PApplet {
    public void settings(){
        size(800,600);
    }
    public void draw(){
        if(mousePressed){
            fill(0,255,0);
        } else {
            fill(0,0,255);
        }
        ellipse(mouseX, mouseY, 60, 60);
        //rect(30,20,55,55);
    }
    public static void main(String[] args) {
        PApplet.main(Main.class.getName());

    }
}
