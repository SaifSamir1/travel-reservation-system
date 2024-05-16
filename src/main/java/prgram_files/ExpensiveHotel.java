package prgram_files;

//This ExpensiveHotel class represents a specific type of hotel that is considered expensive
public class ExpensiveHotel extends Hotel {
    public ExpensiveHotel(String hotelName, double roomPricePerNight, int roomNumber) {
        // Constructor with parameters to create an ExpensiveHotel object
        this.setHotelName(hotelName);
        this.setRoomPricePerNight(roomPricePerNight);
        this.setRoomNumber(roomNumber);
    }
}
