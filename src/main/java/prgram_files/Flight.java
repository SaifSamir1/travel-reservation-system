package prgram_files;

public class Flight {
    private int flightNumber;
    private String departureCity;
    private String destinationCity;
    private String departureTime;
    public static double ticketPrice;
    private  int chairNumber;
    public static String flightType;

    public static String getFlightType() {
        return flightType;
    }

    public static void setFlightType(String flightType) {
        Flight.flightType = flightType;
    }

    public int getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(int chairNumber) {
        this.chairNumber = chairNumber;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        Flight.ticketPrice = ticketPrice;
    }
    public void addDataToReservationFlightTableInDatabase() {
        //Adds flight data to the reservation flight table in the database.
        if (DataBase.executeQuery(
                "insert into reservationflight (customerId, flight_type, flight_number, deparure_city,destination_city,flight_price,moving_time) values (\""+ ReservationDetails.customerDetails.getCustomerId()+"\",\""+getFlightType()+"\",\""+getFlightNumber()+"\",\""+getDepartureCity()+"\",\""+getDestinationCity()+"\",\""+getTicketPrice() * getFlightNumber()+"\",\""+getDepartureTime()+"\");")){
            System.out.print("successfully added");
        }
        else{
            System.out.print("Something went wrong");
        }
    }
}
