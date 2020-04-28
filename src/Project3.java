/*
Filename: Project3.java
Author: Yael Brown
Date: 4/26/2020
Brief Purpose of the Program:
*/

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Project3 extends JFrame {
        private JLabel shapeTypeLabel = new JLabel("Shape Type");
        private JLabel fillTypeLabel = new JLabel("Fill Type");
        private JLabel colorLabel = new JLabel("Color");
        private JLabel widthLabel = new JLabel("Width");
        private JLabel heightLabel = new JLabel("Height");
        private JLabel xcoordLabel = new JLabel("x coordinate");
        private JLabel ycoordLabel = new JLabel("y coordinate");

        private String[] shapeTypes = {"Oval", "Rectangular"};
        private JComboBox shapeList = new JComboBox(shapeTypes);

        private String[] fillTypes = {"Solid", "Hollow"};
        private JComboBox fillList = new JComboBox(fillTypes);

        private String[] colorTypes = {"Black", "Red", "Orange", "Yellow", "Green", "Blue", "Magenta"};
        private Color[] colorTypeValues = {Color.black, Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.magenta};
        private JComboBox colorList = new JComboBox(colorTypes);

        private JTextField widthField = new JTextField("");
        private JTextField heightField = new JTextField("");
        private JTextField xcoordField = new JTextField("");
        private JTextField ycoordField = new JTextField("");

        public Project3() {
            super("Draw Shapes!");
            gui();
        }

        public void gui() {
            setSize(475, 300);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel shapeConfigPanel = new JPanel();
            shapeConfigPanel.setMaximumSize(new Dimension(200,200));
            shapeConfigPanel.setLayout(new GridLayout(7,2,0,2));
            shapeConfigPanel.add(shapeTypeLabel); shapeConfigPanel.add(shapeList);
            shapeConfigPanel.add(fillTypeLabel); shapeConfigPanel.add(fillList);
            shapeConfigPanel.add(colorLabel); shapeConfigPanel.add(colorList);
            shapeConfigPanel.add(widthLabel); shapeConfigPanel.add(widthField);
            shapeConfigPanel.add(heightLabel); shapeConfigPanel.add(heightField);
            shapeConfigPanel.add(xcoordLabel); shapeConfigPanel.add(xcoordField);
            shapeConfigPanel.add(ycoordLabel); shapeConfigPanel.add(ycoordField);

            Drawing drawingPanel = new Drawing();
            drawingPanel.setMaximumSize(drawingPanel.getPreferredSize());
            drawingPanel.setBorder(new TitledBorder("Shape Drawing"));

            JButton drawButton = new JButton(new AbstractAction("Draw") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Shape selectedShape = getShapeInfo(drawingPanel);
                        drawingPanel.drawShape(selectedShape);
                    } catch (OutsideBounds obex) {
                        JOptionPane.showMessageDialog(null, "Desired shape is bigger than drawing panel.");
                    } catch (NumberFormatException nfex) {
                        JOptionPane.showMessageDialog(null, "Incorrect values entered.");
                    }
                }
            });

            drawButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            JPanel mainPanel = new JPanel();
            mainPanel.setMaximumSize(new Dimension(400,400));
            mainPanel.setLayout(new GridLayout(1,2,10,10));
            mainPanel.add(shapeConfigPanel);
            mainPanel.add(drawingPanel);

            add(Box.createRigidArea(new Dimension(450, 10)));
            add(mainPanel);
            add(Box.createRigidArea(new Dimension(450,5)));
            add(drawButton);
            add(Box.createRigidArea(new Dimension(450,10)));
        }

        private Shape getShapeInfo(Drawing panel) throws NumberFormatException, OutsideBounds {
            Shape input = null;
            String shapeType = String.valueOf(shapeList.getSelectedItem());

            String fillType = String.valueOf(fillList.getSelectedItem());
            boolean fillTypeValue;

            if (fillType == "Solid") {
                fillTypeValue = true;
            } else {
                fillTypeValue = false;
            }

            int colorIndex = colorList.getSelectedIndex();
            int width = getInput(widthField);
            int height = getInput(heightField);
            int xcoord = getInput(xcoordField);
            int ycoord = getInput(ycoordField);

            if ((width + xcoord) > panel.getWidth() || (height+ycoord) > panel.getHeight()) {
                throw new OutsideBounds("Shape does not completely fill the panel!");
            } else {
                if (shapeType == "Oval") {
//                    input = new Oval(new Rectangle(xcoord, ycoord, width, height), colorTypeValues[colorIndex], fillTypeValue);
                    System.out.println("hello");
                } else {
                    input = new Rectangular(new Rectangle(xcoord, ycoord, width, height), colorTypeValues[colorIndex], fillTypeValue);
                }
            }

            return input;
        }

        private int getInput(JTextField inputTextField) throws NumberFormatException {
            String inputString = inputTextField.getText();
            return Integer.parseInt(inputString);
        }

    public static void main(String[] args) {
        JFrame project3 = new JFrame("Geometric Drawing");
        project3.setVisible(true);
        project3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        project3.setSize(475, 300);
    }
}