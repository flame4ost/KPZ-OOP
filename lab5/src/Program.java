import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {

    private static Ticket ticket;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
    private static JFrame frame;
    private static JComboBox comboBox = new JComboBox();
    private static JTextArea text1;
    private static JTextArea text2;
    private static JTextArea text3;
    private static JTextArea text4;
    private static JTextArea text5;
    private static JButton button3;
    private static JButton button2;
    private static JButton button;
    private static JLabel l5;
    private static JLabel l4;
    private static JLabel l3;
    private static JLabel l2;
    private static JLabel l1;

    public static void main(String[] args) {
        initializeWindow();
        ticket = new Ticket("000000", 0.00);
        frame.getContentPane().add(ticket);
        ticket.setBounds(0, 0, 150, 150);
        frame.getContentPane().add(comboBox);
        comboBox.setBounds(10, 130, 210, 20);
        comboBox.addItem("Ticket");
        comboBox.addItem("Air ticket");
        // 1
        buildInterfaceForInputAndOutput();
        // 6
        buildButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().remove(ticket);
                if (comboBox.getSelectedItem() == "Ticket") {
                    if (text1.getText().length() > 0 && text2.getText().length() > 0) {
                        ticket = new Ticket(text1.getText(), Double.parseDouble(text2.getText()));
                        frame.getContentPane().add(ticket);
                        ticket.setBounds(0, 0, 150, 150);
                        frame.getContentPane().revalidate();
                        frame.getContentPane().repaint();
                    }
                }
                if (comboBox.getSelectedItem() == "Air Ticket") {
                    if (text1.getText().length() > 0 && text2.getText().length() > 0
                            && text3.getText().length() > 0 && text4.getText().length() > 0
                            && text5.getText().length() > 0) {
                        try {
                            ticket = new AirTicket(text1.getText(), Double.parseDouble(text2.getText()), text3.getText(), text4.getText(), dateFormat.parse(text5.getText()));
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                    frame.getContentPane().add(ticket);
                    ticket.setBounds(0, 0, 150, 150);
                    frame.getContentPane().revalidate();
                    frame.getContentPane().repaint();
                }
            }
        });

        buildButton2();
        button2.addActionListener(e -> {
            setDataTicket();
        });

        buildButton3();
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ticket instanceof AirTicket){
                    text1.setText(ticket.getId());
                    text2.setText("" + ticket.getPrice());
                    text3.setText(((AirTicket) ticket).getDeparturePlace());
                    text4.setText(((AirTicket) ticket).getArrivalPlace());
                    text5.setText(dateFormat.format(((AirTicket) ticket).getTravelTime()));
                }
                else{
                    text1.setText(ticket.getId());
                    text2.setText("" + ticket.getPrice());
                }
            }
        });
    }

    private static void setDataTicket() {
        if (comboBox.getSelectedItem() == "Ticket") {
            if (text1.getText().length() > 0 && text2.getText().length() > 0) {
                ticket.setId(text1.getText());
                ticket.setPrice(Double.parseDouble(text2.getText()));
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        }
        if (comboBox.getSelectedItem() == "Air Ticket") {
            if (ticket instanceof AirTicket && text1.getText().length() > 0 &&
                    text2.getText().length() > 0 && text3.getText().length() > 0 &&
                    text4.getText().length() > 0 && text5.getText().length() > 0){
                AirTicket airTicket = (AirTicket) ticket;
                airTicket.setId(text1.getText());
                airTicket.setPrice(Double.parseDouble(text2.getText()));
                airTicket.setDeparturePlace(text3.getText());
                airTicket.setArrivalPlace(text4.getText());
                try {
                    airTicket.setTravelTime(dateFormat.parse(text5.getText()));
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                //t = airTicket;
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        }
    }

    private static void buildButton() {
        button = new JButton();
        frame.getContentPane().add(button);
        button.setBounds(120, 10, 100, 100);
        button.setText("Create!");
    }

    private static void buildButton2() {
        button2 = new JButton();
        frame.getContentPane().add(button2);
        button2.setBounds(10, 360, 105, 40);
        button2.setText("Save!");
    }

    private static void buildButton3() {
        button3 = new JButton();
        frame.getContentPane().add(button3);
        button3.setBounds(115, 360, 105, 40);
        button3.setText("Refresh!");
    }

    private static void initializeWindow() {
        frame = new JFrame("Lab 5 OOP");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 460);
    }

    private static void buildInterfaceForInputAndOutput() {
        l1 = new JLabel();
        frame.getContentPane().add(l1);
        l1.setBounds(10, 150, 210, 20);
        l1.setText("Number");
        text1 = new JTextArea();
        frame.getContentPane().add(text1);
        text1.setBounds(10, 170, 210, 20);
        // 2
        l2 = new JLabel();
        frame.getContentPane().add(l2);
        l2.setBounds(10, 190, 210, 20);
        l2.setText("Price");
        text2 = new JTextArea();
        frame.getContentPane().add(text2);
        text2.setBounds(10, 210, 210, 20);
        // 3
        l3 = new JLabel();
        frame.getContentPane().add(l3);
        l3.setBounds(10, 230, 210, 20);
        l3.setText("Departure Place");
        text3 = new JTextArea();
        frame.getContentPane().add(text3);
        text3.setBounds(10, 250, 210, 20);
        // 4
        l4 = new JLabel();
        frame.getContentPane().add(l4);
        l4.setBounds(10, 270, 210, 20);
        l4.setText("Arrival Place");
        text4 = new JTextArea();
        frame.getContentPane().add(text4);
        text4.setBounds(10, 290, 210, 20);
        // 5
        l5 = new JLabel();
        frame.getContentPane().add(l5);
        l5.setBounds(10, 310, 210, 20);
        l5.setText("Date and Time");
        text5 = new JTextArea();
        frame.getContentPane().add(text5);
        text5.setBounds(10, 330, 210, 20);
    }
}
