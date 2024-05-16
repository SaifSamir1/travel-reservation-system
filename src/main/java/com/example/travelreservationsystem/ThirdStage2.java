package com.example.travelreservationsystem;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import prgram_files.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ThirdStage2 implements Initializable, Booking, Canceling {
    @FXML
    public ChoiceBox<Integer> choiceBox3;
    @FXML
    private Label tickPrice;
    @FXML
    private ChoiceBox<String> interDeparCity,interDestCity,choiceBox4;
    InternationalFlight internationalFlight;
    private final Integer[] flightNumber={1,2,3,4,5,6,7,8};
    private final String[] movingTime={"01:00 AM","04:00 AM","07:00 AM","10:00 AM","01:00 PM","04:00 PM","07:00 PM","10:00 PM"};


    public void initialize(URL location, ResourceBundle resources) {
        //this method used to set a set of values for the choice box of flightNumber and
        // movingTime and some international countries
        choiceBox3.getItems().addAll(flightNumber);
        choiceBox4.getItems().addAll(movingTime);
        interDeparCity.getItems().addAll(InternationalFlight.internationalCountries);
        interDestCity.getItems().addAll(InternationalFlight.internationalCountries);
    }

    private void saveFlightDetails() {
        //this method use to save the flight details in the database
        internationalFlight = new InternationalFlight(choiceBox3.getValue(), interDeparCity.getValue(), interDestCity.getValue(), choiceBox4.getValue());
        internationalFlight.addDataToReservationFlightTableInDatabase();

    }

    @FXML
    @Override
    public void book() throws IOException {
        //this method to book the international flight ticket then navigate to the ticket stage
        saveFlightDetails();
        Navigation.navigateToNewStage("flight-ticket.fxml");
    }

    @FXML
    @Override
    public void calculateTotalCost() {
        //this method to calculate the total cost of the international flight ticket and print it in the GUI
        tickPrice.setText(String.valueOf(Flight.ticketPrice * choiceBox3.getValue()));
    }
    @Override
    @FXML
    public void finishTheApplication()
    {
        //this method use to finish the application
        Platform.exit();
    }
}
