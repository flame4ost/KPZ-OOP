import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_ENTER;

public class MainWindow {
    Triangle triangle;
    void showWindow(){
        JFrame requestWindow = new JFrame("Lab3");
        requestWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(2,1);
        requestWindow.setLayout(gridLayout);
        requestWindow.setVisible(true);
        JTextArea info = new JTextArea();
        triangle = new Triangle();

        requestWindow.add(triangle);
        requestWindow.add(info);
        requestWindow.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == VK_ENTER) {
                    String result = "";
                    result += triangle.measureParties();
                    result += triangle.measurePerimetry();
                    result += triangle.measureArea();
                    info.setText(result);
                }

            }
        });

        triangle.coordinateRequest(requestWindow);
        requestWindow.setSize(600,400);
    }
}
