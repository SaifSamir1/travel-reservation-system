package com.example.travelreservationsystem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import prgram_files.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HotelBook implements Initializable , Booking {
    Hotel hotel;
    ExpensiveHotel expensiveHotel;
    CheapHotel cheapHotel;
    private final String[] expensiveHotelName = {
            "Grand Opulence Suites",
            "Regal Residences",
            "Platinum Towers",
            "Luxe Haven",
            "Pinnacle Palace",
            "Celestial Suites",
            "Elite Escapes",
            "Royal Oasis",
            "Opulent Horizons",
            "Sovereign Sanctuaries",
            "Prestige Palazzo",
            "Majestic Retreats",
            "Grandeur Residences",
            "Elysian Estates",
            "Prestigious Paradises",
            "Imperial Quarters",
            "Lavish Lagoons",
            "Zenith Zephyr",
            "Celestial Chateaus",
            "Luxuria Lofts"
    };
    private final String[] cheapHotelNames = {
            "Economy Inn",
            "Budget B&B",
            "Simple Stays",
            "Affordable Suites",
            "Pocket-Friendly Residency",
            "Value Lodge",
            "Low-Cost Motel",
            "Basic Beds",
            "Modest Inns",
            "Savings Hotel",
            "Inexpensive Lodgings",
            "Bare Necessities Hostel",
            "Thrifty Accommodations",
            "Cost-Cutter Chalet",
            "Frugal Inn",
            "Dime Saver Hotel",
            "Backpacker's Haven",
            "Penny Pincher Palace",
            "Discount Digs",
            "Cheapskate Suites"
    };
    private final Integer[] roomNumbers={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};
    @FXML
    private CheckBox expSingle,expFamily,expDouble,chpSignal,chpDouble,chpFamily;
    @FXML
    private TextField expNumberOfDays,chpNumberOfDays;
    @FXML
    public Label expText,chpText;
    @FXML
    private ChoiceBox<String> expensiveHotelNames,chpHotelName;
    @FXML
    private ChoiceBox<Integer> chpNumberOfRooms,expensiveNumberOfRooms;
    private String hotelType ="";
    private String roomType ="";
    boolean isAvailable = false;
    @FXML
    public void checkTheTypeOfRooms() {
        // this method to determine the type of room and hotel that will be selected from customer
        if(expSingle.isSelected())
        {
            hotelType = "Expensive Hotel";
            roomType = "Single";
            expDouble.setSelected(false);
            expFamily.setSelected(false);
        }
        else if(expDouble.isSelected())
        {
            hotelType = "Expensive Hotel";
            roomType = "Double";
            expSingle.setSelected(false);
            expFamily.setSelected(false);
        }
        else if(expFamily.isSelected())
        {
            hotelType = "Expensive Hotel";
            roomType = "Family";
            expDouble.setSelected(false);
            expSingle.setSelected(false);
        }
        if(chpSignal.isSelected())
        {
            hotelType = "Cheap Hotel";
            roomType = "Single";
            chpDouble.setSelected(false);
            chpFamily.setSelected(false);
        }
        else if(chpDouble.isSelected())
        {
            hotelType = "Cheap Hotel";
            roomType = "Double";
            chpSignal.setSelected(false);
            chpFamily.setSelected(false);
        }
        else if(chpFamily.isSelected())
        {
            hotelType = "Cheap Hotel";
            roomType = "Family";
            chpSignal.setSelected(false);
            chpDouble.setSelected(false);
        }
        hotel = new Hotel(hotelType, roomType);
    }
    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //this method used to set a set of values for choice box of the expensive and
        // cheap hotel ,and the number of rooms in the hotel
        expensiveHotelNames.getItems().addAll(expensiveHotelName);
        chpHotelName.getItems().addAll(cheapHotelNames);
        expensiveNumberOfRooms.getItems().addAll(roomNumbers);
        chpNumberOfRooms.getItems().addAll(roomNumbers);
    }

    @FXML
    public void expAvBtn1() {
        // this method use when selected expensive hotel to stay on it and use to save some information about the
        // hotel that will be selected from the customer
        //and check if tge room is available or not
        expensiveHotel = new ExpensiveHotel(expensiveHotelNames.getValue(),600 * Integer.parseInt(expNumberOfDays.getText()),expensiveNumberOfRooms.getValue());
        if(expensiveHotel.addDataToReservationHotelTableInDatabase())
        {
            isAvailable = true;
            expText.setText("The room is available");
        }else {
            isAvailable = false;
            expText.setText("the room is unavailable");
        }

    }
    @FXML
    public void chpAvBtn1() {
        // this method use when selected Cheap hotel to stay on it and use to save some information about the
        // hotel that will be selected from the customer
        //and check if tge room is available or not
        cheapHotel = new CheapHotel(chpHotelName.getValue(),200 * Integer.parseInt(chpNumberOfDays.getText()),chpNumberOfRooms.getValue());
        if(cheapHotel.addDataToReservationHotelTableInDatabase())
        {
            isAvailable = true;
            chpText.setText("The room is available");
        }else {
            isAvailable = false;
            chpText.setText("The room is unavailable");
        }
    }
    @FXML
    public void chpPrice()
    {
        // use to print the price of the room in the cheap hotel
        chpText.setText("200 pounds per night ");
    }
    @FXML
    public void expPrice(){
        // use to print the price of the room in the Expensive hotel
        expText.setText("600 pounds per night ");
    }
    @FXML
    @Override
    public void book() throws IOException {
        // this method use to sure from the room that selected from the user are available or not and book this room
        if(isAvailable)
        {
            Navigation.navigateToNewStage("hotel-ticket.fxml");
        } else {
            chpText.setText("Please check first whether it is available or not");
            expText.setText("Please check first whether it is available or not");

        }
    }
    @Override
    public void calculateTotalCost() {
        // this method use to calculate the total cost of the room that selected from the user
        System.out.println("the total cost");
    }
}
