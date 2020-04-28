/*
Filename: Shape.java
Author: Yael Brown
Date: 4/26/2020
Brief Purpose of the Program: program that draws two types of shapes, ovals and rectangles.
*/

import java.awt.*;

public class Rectangular extends Shape {
    public Rectangular (Rectangle r, Color c, Boolean solid) {
        super(c, solid, r.getLocation(), new Dimension((int) r.getWidth(), (int) r.getHeight()));
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }
}
