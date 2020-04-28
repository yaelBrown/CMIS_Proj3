/*
Filename: OutsideBrounds.java
Author: Yael Brown
Date: 4/26/2020
Brief Purpose of the Program:
*/

public class OutsideBounds extends Exception {
    public OutsideBounds(String msg) {
        super(msg);
    }

    public OutsideBounds() {
        super();
    }
}