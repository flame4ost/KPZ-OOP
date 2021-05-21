package lab1.utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {

    public static void main(String[] args) {
        JFrame mainWindow = new JFrame("MAIN MENU");
        mainWindow.setLayout(null);
        mainWindow.setSize(270,300);
        mainWindow.setResizable(false);
        mainWindow.getContentPane().setBackground(Color.white);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton task1Button = new JButton("TASK 1");
        task1Button.setSize(150,30);
        task1Button.setLocation(50,70);
        task1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lab1.task1.Window winTask1 = new lab1.task1.Window(mainWindow);
                winTask1.drawWindow();
                mainWindow.setVisible(false);
            }
        });
        JButton task2Button = new JButton("TASK 2");
        task2Button.setSize(150,30);
        task2Button.setLocation(50,170);
        task2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lab1.task2.Window winTask2 = new lab1.task2.Window(mainWindow);
                winTask2.drawWindow();
                mainWindow.setVisible(false);;
            }
        });
        JButton exitButton = new JButton("Exit program");
        exitButton.setSize(150,30);
        exitButton.setLocation(50,118);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            mainWindow.dispose();
            }
        });
        mainWindow.add(task1Button);
        mainWindow.add(task2Button);
        mainWindow.add(exitButton);
        mainWindow.setVisible(true);
    }//End of method
}//End of class
