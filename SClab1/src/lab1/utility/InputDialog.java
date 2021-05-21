package lab1.utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class FrameViewThread implements Runnable{
    Thread thread;
    int outputNumber;
    FrameViewThread(){
        outputNumber = 0;
        thread = new Thread(this);
        thread.start();
    }//End of constructor
    public void run(){
        System.out.println("Method start");
        JFrame window = new JFrame("Input Coord");
        window.setLayout(null);
        window.setSize(250,300);
        window.setResizable(false);
        JLabel viewportLabel = new JLabel("0");
        viewportLabel.setSize(250,40);
        viewportLabel.setOpaque(true);
        viewportLabel.setBackground(Color.WHITE);
        viewportLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        JPanel buttonPanel = new JPanel(new GridLayout(4,3));
        buttonPanel.setSize(250,180);
        buttonPanel.setLocation(0,41);
        buttonPanel.setOpaque(true);
        buttonPanel.setBackground(Color.lightGray);
        JButton [] buttonNumbers = new JButton [10];
        for (int i = 0; i < 10; i ++) {
            buttonNumbers[i] = new JButton(""+i);
            buttonNumbers[i].setFont(new Font("Verdana", Font.PLAIN, 18));
            buttonNumbers[i].addActionListener(actionForButton(buttonNumbers[i],viewportLabel));
            buttonPanel.add(buttonNumbers[i]);
        }
        JButton delButton = new JButton("C");
        delButton.setFont(new Font("Verdana", Font.PLAIN, 20));
        delButton.setSize(161,45);
        delButton.setLocation(83,176);
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewportLabel.setText(viewportLabel.getText().substring(0,viewportLabel.getText().length()-1));
                if (viewportLabel.getText().length() == 0) viewportLabel.setText("0");
            }
        });
        JButton cancelButton = new JButton("CANCEL");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                thread.stop();
            }
        });

        JButton okButton = new JButton("INPUT");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputNumber = Integer.parseInt(viewportLabel.getText());
                window.dispose();
            }
        });
        JPanel optionPanel = new JPanel(new GridLayout(1,2));
        optionPanel.add(cancelButton);
        optionPanel.add(okButton);
        optionPanel.setSize(250,54);
        optionPanel.setLocation(0,221);
        window.add(viewportLabel);
        window.add(buttonPanel);
        window.add(delButton,1);
        window.add(optionPanel);
        window.setVisible(true);
        System.out.println("Before loop");
        while (true){System.out.println("loop");}//Not ending process. It will stop by pressing the button.
    }
    private ActionListener actionForButton(JButton button, JLabel label){
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (label.getText().charAt(0) == '0') label.setText(label.getText().substring(1));
                label.setText(label.getText() + button.getText());
            }
        };
        return action;
    }//End of method
}//End o class

public class InputDialog {
    public int showInputDialog(){
        FrameViewThread frameViewThread = new FrameViewThread();
        while (frameViewThread.thread.isAlive()){} //Waiting for thread process ending
        return frameViewThread.outputNumber;
    }//End of method
}//End of class
