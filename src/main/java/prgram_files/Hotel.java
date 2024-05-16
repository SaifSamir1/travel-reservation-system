package prgram_files;

public class Hotel {
    private String hotelName;
    private static String roomTypes;
    private static String hotelType;
    private boolean roomAvailability =true;
    private double roomPricePerNight;
    private  int roomNumber;
    public Hotel() {}
    public Hotel(String hotelType,String roomTypes){
        this.setHotelType(hotelType);
        this.setRoomTypes(roomTypes);
    }

    public Hotel(String hotelName, double roomPricePerNight, int roomNumber) {
        this.hotelName = hotelName;
        this.roomPricePerNight = roomPricePerNight;
        this.roomNumber = roomNumber;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(String roomTypes) {
        Hotel.roomTypes = roomTypes;
    }

    public boolean getRoomAvailability() {
        return roomAvailability;
    }

    public void setRoomAvailability(boolean roomAvailability) {
        this.roomAvailability = roomAvailability;
    }

    public double getRoomPricePerNight() {
        return roomPricePerNight;
    }

    public void setRoomPricePerNight(double roomPricePerNight) {
        this.roomPricePerNight = roomPricePerNight;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        Hotel.hotelType = hotelType;
    }
    public boolean addDataToReservationHotelTableInDatabase() {
        //Adds hotel data to the reservation hotel table in the database.
        if (DataBase.executeQuery(
                "insert into hotel_reservation (customerId, hotelType, hotelName, roomType,roomNumber,totalCost) values (\""+ ReservationDetails.customerDetails.getCustomerId()+"\",\""+Hotel.hotelType+"\",\""+getHotelName()+"\",\""+Hotel.roomTypes+"\",\""+getRoomNumber()+"\",\""+getRoomPricePerNight()+"\");")){
            System.out.print("successfully added");
            return true;
        }
        else{
            System.out.print("Something went wrong");
            return false;
        }
    }

}
