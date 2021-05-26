import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;


public class Triangle extends JPanel {

    int point1Y;
    int point1X;
    int point2Y;
    int point2X;
    int point3Y;
    int point3X;

    Triangle() {

    }

    Triangle(int point1Y, int point1X, int point2Y, int point2X, int point3Y, int point3X) {
        this.point1Y = point1Y;
        this.point1X = point1X;
        this.point2Y = point2Y;
        this.point2X = point2X;
        this.point3Y = point3Y;
        this.point3X = point3X;
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawLine(point1X, point1Y, point2X, point2Y);
        graphics.drawLine(point1X, point1Y, point3X, point3Y);
        graphics.drawLine(point2X, point2Y, point3X, point3Y);
    }

    void coordinateRequest(JFrame jFrame) {
        JFrame requestWindow = new JFrame("Lab3");
        GridLayout gridLayout = new GridLayout(3, 1);
        requestWindow.setLayout(gridLayout);
        JLabel request = new JLabel("Введіть кординати трьох точок");
        JLabel point1 = new JLabel("Точка 1(x,y)");
        JLabel point2 = new JLabel("Точка 2(x,y)");
        JLabel point3 = new JLabel("Точка 3(x,y)");
        JPanel jPanel = new JPanel();
        JTextField x1 = new JTextField("20");
        JTextField x2 = new JTextField("70");
        JTextField x3 = new JTextField("70");
        JTextField y1 = new JTextField("20");
        JTextField y2 = new JTextField("70");
        JTextField y3 = new JTextField("20");
        JButton ok = new JButton("Ok");

        requestWindow.add(request);
        requestWindow.add(jPanel);
        requestWindow.add(ok);
        jPanel.setLayout(gridLayout);
        jPanel.add(point1);
        jPanel.add(x1);
        jPanel.add(y1);
        jPanel.add(point2);
        jPanel.add(x2);
        jPanel.add(y2);
        jPanel.add(point3);
        jPanel.add(x3);
        jPanel.add(y3);

        requestWindow.setVisible(true);
        requestWindow.setSize(600, 400);

        ok.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {
                                     point1Y = Integer.parseInt(y1.getText());
                                     point1X = Integer.parseInt(x1.getText());
                                     point2Y = Integer.parseInt(y2.getText());
                                     point2X = Integer.parseInt(x2.getText());
                                     point3X = Integer.parseInt(x3.getText());
                                     point3Y = Integer.parseInt(y3.getText());

                                     jFrame.repaint();
                                     requestWindow.setVisible(false);
                                 }
                             }
        );
    }

    String measureParties() {
        String result = "Довжини сторін: \n";
        result += Point2D.distance(point1X, point1Y, point2X, point2Y) + "\n";
        result += Point2D.distance(point1X, point1Y, point3X, point3Y) + "\n";
        result += Point2D.distance(point2X, point2Y, point3X, point3Y) + "\n";
        return result;
    }

    String measurePerimetry() {
        return "Периметр:" + (Point2D.distance(point1X, point1Y, point2X, point2Y) + Point2D.distance(point1X, point1Y, point3X, point3Y) + Point2D.distance(point2X, point2Y, point3X, point3Y)) + "\n";
    }

    String measureArea() {
        double a = Point2D.distance(point1X, point1Y, point2X, point2Y);
        double b = Point2D.distance(point1X, point1Y, point3X, point3Y);
        double c = Point2D.distance(point2X, point2Y, point3X, point3Y);
        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return "Площа:" + Double.toString(s) + "\n";
    }


}
