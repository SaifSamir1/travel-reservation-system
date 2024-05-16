package prgram_files;

public class CheapHotel extends Hotel {
    //this class is responsible for creating objects of
    // Cheap Hotel  and then storing them in the database ,it's extending from the hotel class
    public CheapHotel(String hotelName, double roomPricePerNight, int roomNumber) {
        // constructor for creating objects
        this.setHotelName(hotelName);
        this.setRoomPricePerNight(roomPricePerNight);
        this.setRoomNumber(roomNumber);
    }
}