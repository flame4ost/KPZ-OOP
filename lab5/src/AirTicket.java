import java.awt.*;
import java.util.Date;

public class AirTicket extends Ticket {
    protected String departurePlace;
    protected String arrivalPlace;
    protected Date travelTime;

    public AirTicket(String id, double ticketPrice, String departurePlace, String arrivalPlace, Date travelTime) {
        super(id, ticketPrice);
        this.departurePlace = departurePlace;
        this.arrivalPlace = arrivalPlace;
        this.travelTime = travelTime;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public Date getTravelTime() {
        return travelTime;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public void setTravelTime(Date travelTime) {
        this.travelTime = travelTime;
    }

    public void paint(Graphics g) {
        g.drawRoundRect(10, 10, 100, 100, 30, 30);
        g.drawString(id, 20, 35);
        g.drawString(""+price+ " грн.", 20, 55);
        g.drawString(departurePlace + " - " + arrivalPlace, 20, 75);
        g.drawString((String.valueOf(travelTime)), 20, 95);
    }

    public String getFullInfo() {
        return "TicketPrice: "
                + price + "\n" +
                "DeparturePlace: " +
                departurePlace + "\n" + "ArrivalPlace: " + "\n" + "TravelTime: " + "\n";
    }
}
