/*
Filename: Shape.java
Author: Yael Brown
Date: 4/26/2020
Brief Purpose of the Program: program that draws two types of shapes, ovals and rectangles.
*/

import java.awt.*;

abstract class Shape extends Rectangle {
    public Color color;
    public boolean solid;
    public static int shapesCreated = 0;

    public Shape(Color c, boolean isS, int x, int y, Dimension d) {
        super(new Point(x,y), d);
        this.color = c;
        this.solid = isS;
        shapesCreated++;
    }

    public Shape(Color c, boolean isS, Point p, Dimension d) {
        super(p, d);
        this.color = c;
        this.solid = isS;
        shapesCreated++;
    }

    public void setColor(Graphics g) {
        this.color = g.getColor();
    }

    public boolean getSolid() {
        return this.solid;
    }

    public static int getNoOfShapes() {
        return shapesCreated;
    }

    public void draw(Graphics g) { }

}