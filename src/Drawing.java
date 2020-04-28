/*
Filename: Drawing.java
Author: Yael Brown
Date: 4/26/2020
Brief Purpose of the Program:
*/

import javax.swing.*;
import java.awt.*;

public class Drawing extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return super.getPreferredSize();
    }

    public void drawShape(Shape s) throws OutsideBounds {
        // check if shape passed in will fill up panel
        // throw exception if not
    }
}