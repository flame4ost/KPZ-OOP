package lab1.task2;

import lab1.utility.InputDialog;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window {
    JFrame mainWindow;
    private int numOfCols;
    public Window(JFrame mainWindow){
        this.mainWindow = mainWindow;
        numOfCols = 10;
    }
    public void drawWindow(){
        JFrame window = new JFrame("lab_1");
        window.setLayout(null);
        window.setSize(1100,536);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //The util panel for moving of the cube
        JPanel panel = new JPanel(new BorderLayout());
        panel.setSize(550,400);
        panel.setLocation(30,60);
        Border lineBorder = BorderFactory.createLineBorder(Color.BLUE);
        panel.setBorder(lineBorder);
        panel.setOpaque(true);
        panel.setBackground(Color.white);
        //Info labels
        JLabel viewportLabel = new JLabel("VIEWPORT:");
        viewportLabel.setFont( new Font("Verdana", Font.PLAIN, 20));
        viewportLabel.setSize(viewportLabel.getPreferredSize());
        viewportLabel.setLocation(90, 25);
        JLabel settingLabel = new JLabel("SETTING:");
        settingLabel.setFont( new Font("Verdana", Font.PLAIN, 20));
        settingLabel.setSize(settingLabel.getPreferredSize());
        settingLabel.setLocation(645, 25);
        //Creation of Buttons
        JButton inputColButton = new JButton("" + numOfCols);
        inputColButton.setSize(130,30);
        inputColButton.setFont( new Font("Verdana", Font.PLAIN, 16));
        inputColButton.setLocation(710,138);
        inputColButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InputDialog input = new InputDialog();
                numOfCols = input.showInputDialog();
                inputColButton.setText("" + numOfCols);
            }
        });
        Diagram diagram = new Diagram(numOfCols, panel.getWidth(), panel.getHeight());
        JButton sortButton = new JButton("SORT");
        sortButton.setEnabled(false);
        sortButton.setSize(130,30);
        sortButton.setFont( new Font("Verdana", Font.PLAIN, 16));
        sortButton.setLocation(710,288);
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                diagram.sortRectungleByHeight();
                window.repaint();
                window.validate();
            }
        });
        JButton backButton = new JButton("BACK");
        backButton.setSize(230,40);
        backButton.setFont( new Font("Verdana", Font.PLAIN, 24));
        backButton.setLocation(810,385);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                mainWindow.setVisible(true);
            }
        });
        JButton startButton = new JButton("START");
        startButton.setSize(220,40);
        startButton.setFont( new Font("Verdana", Font.PLAIN, 24));
        startButton.setLocation(620,385);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortButton.setEnabled(true);
                startButton.setEnabled(false);
                inputColButton.setEnabled(false);

                panel.add(diagram);
                window.repaint();
                window.validate();
            }
        });
        //add component to the Window
        window.add(panel);
        window.add(viewportLabel);
        window.add(settingLabel);
        window.add(backButton);
        window.add(inputColButton);
        window.add(sortButton);
        window.add(startButton);
        window.setVisible(true);
    }//End of method
}//End of class
