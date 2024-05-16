package prgram_files;

//This DomesticFlight class represents a specific type of flight that operates within Egypt
public class DomesticFlight extends Flight{
    // Array of Egyptian cities served by domestic flights
    public static String[] egyptianCities = {
            "menuf", "Tanta", "Cairo", "Alexandria", "Giza", "Sharm El Sheikh", "Hurghada", "Port Said", "Suez",
            "Ismailia", "Faiyum", "Zagazig", "Ismailia", "Kafr El Sheikh", "Mansoura", "Damietta", "Beni Suef",
            "Minya", "Asyut", "Sohag", "Qena", "Luxor", "Aswan"
    };
    public DomesticFlight(double ticketPrice,String flightType) {
        // Constructor with parameters to set ticket price and flight type
        setTicketPrice(ticketPrice);
        setFlightType(flightType);
    }

    public DomesticFlight(int flightNumber, String departureCity, String destinationCity, String departureTime) {
        // Constructor with parameters to set flight details
        setFlightNumber(flightNumber);
        setDepartureCity(departureCity);
        setDestinationCity(destinationCity);
        setDepartureTime(departureTime);
    }
}
