package lab1.task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Foursquare extends JPanel {
   private int coordX, coordY, width, height;
    Point maxCoordinates;
    Component formForRepaint;

    public Foursquare(Point startCoord, Point maxCoord, Component form){
        coordX = (int)startCoord.getX();
        coordY = (int)startCoord.getY();
        maxCoordinates = maxCoord;
        width = 45;
        height = 45;
        formForRepaint = form;
    }//End of constructor

    @Override
    public void paint(Graphics g){
    g.fillRect(coordX, coordY,width,height);
    }//End of method

    int incX = 1, incY = 1;
    public void moveFoursquare(){
        Timer timer = new Timer(10,null);
        ActionListener timerAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Move of the Foursquare
                coordX += incX;
                coordY += incY;

                //Valid of the X coordinate
                if (coordX + width >= maxCoordinates.getX()) {
                    incX = -1;
                    changeFieldColor();
                }
                if (coordX <= 0) {
                    incX = 1;
                    changeFieldColor();
                }
                //Valid of the Y coordinate
                if (coordY + height >= maxCoordinates.getY()) {
                    incY = -1;
                    changeFieldColor();
                }
                if (coordY <= 0) {
                    incY = 1;
                    changeFieldColor();
                }

                formForRepaint.repaint();
                formForRepaint.validate();
            }
        };

        timer.addActionListener(timerAction);
        timer.start();
    }//End of method

    private void changeFieldColor(){
        Color [] fieldColor = {Color.white, Color.white, Color.white, Color.white, Color.white, Color.white};
        Random random = new Random();
        formForRepaint.setBackground(fieldColor[random.nextInt(6)]);
    }//End of method

}//End of class

