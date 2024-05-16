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

public class ThirdStage implements Initializable, Booking, Canceling {
    @FXML
    private ChoiceBox<Integer> choiceBox1;
    @FXML
    private ChoiceBox<String> choiceBox2,domeDeparCity,domeDestCity;
    @FXML
    private Label tickPrice;
    DomesticFlight domesticFlight;
    private final Integer[] flightNumber={1,2,3,4,5,6,7,8};
    private final String[] movingTime={"01:00 AM","04:00 AM","07:00 AM","10:00 AM","01:00 PM","04:00 PM","07:00 PM","10:00 PM"};


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //this method used to set a set of values for the choice box of flightNumber and
        // movingTime and egyptianCities
        choiceBox1.getItems().addAll(flightNumber);
        choiceBox2.getItems().addAll(movingTime);
        domeDeparCity.getItems().addAll(DomesticFlight.egyptianCities);
        domeDestCity.getItems().addAll(DomesticFlight.egyptianCities);

    }
    @FXML
    public void saveFlightDetails() {
        //this method use to save the flight details in the database
        domesticFlight = new DomesticFlight(choiceBox1.getValue(),domeDeparCity.getValue(),domeDestCity.getValue(),choiceBox2.getValue());
        domesticFlight.addDataToReservationFlightTableInDatabase();
    }
    @FXML
    @Override
    public void book() throws IOException {
        //this method to book the domestic flight ticket then navigate to the ticket stage
        saveFlightDetails();
        Navigation.navigateToNewStage("flight-ticket.fxml");
    }
    @Override
    @FXML
    public void finishTheApplication()
    {
        //this method use to finish the application
        Platform.exit();
    }
    @FXML
    @Override
    public void calculateTotalCost() {
        //this method use to calculate the total cost and print it in the GUI
        tickPrice.setText(String.valueOf(Flight.ticketPrice * choiceBox1.getValue()));
    }
}
