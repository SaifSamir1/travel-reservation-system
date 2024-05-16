package prgram_files;

//The provided class appears to represent an InternationalFlight class, which is a subclass of the Flight class.
public class InternationalFlight extends Flight{
    //Represents an array of international destinations
    public static String[] internationalCountries = {
            "Egypt", "Saudi Arabia", "Sudan", "Libya", "Chad", "Niger", "Mali", "Algeria", "Morocco", "Tunisia",
            "Jordan", "Iraq", "Lebanon", "Syria", "Turkey", "Greece", "Italy", "Cyprus", "Bulgaria", "Romania", "Hungary",
            "United States", "United Kingdom", "Canada", "Australia", "Germany", "France", "Italy",
            "Japan", "China", "India", "Brazil", "Argentina", "Netherlands", "Spain", "Switzerland"
    };

    public InternationalFlight(double ticketPrice,String flightType) {
        //Parameterized Constructor 1 Takes ticketPrice and flightType as parameters.
        setTicketPrice(ticketPrice);
        setFlightType(flightType);
    }

    public InternationalFlight(int flightNumber, String departureCity, String destinationCity, String departureTime) {
        //Parameterized Constructor 2 Takes flightNumber, departureCity, destinationCity, and departureTime as parameters.
        setFlightNumber(flightNumber);
        setDepartureCity(departureCity);
        setDestinationCity(destinationCity);
        setDepartureTime(departureTime);
    }

}