/*
Filename: Oval.java
Author: Yael Brown
Date: 4/26/2020
Brief Purpose of the Program: program that draws two types of shapes, ovals and rectangles.
*/

import java.awt.*;

public class Oval extends Shape {
        public Oval(Rectangle r, Color c, Boolean solid) {
                super(c, solid, r.getLocation(), new Dimension((int) r.getWidth(), (int) r.getHeight()));
                }

        // Draw method takes in Graphics object
        public void draw(Graphics o) {

                }
                }