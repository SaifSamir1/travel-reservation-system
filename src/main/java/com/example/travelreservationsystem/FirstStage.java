package com.example.travelreservationsystem;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import prgram_files.Navigation;
import prgram_files.ReservationDetails;

import java.io.IOException;

public class FirstStage {
    ReservationDetails reservation;
    @FXML
    private TextField customerName,reservationDate,customerId,contactDetail;
    @FXML
    protected void navigateToSecondStageAndSavingTheData() throws IOException {
        //this method use to call saveCustomerDetails method and navigate to second stage
        saveCustomerDetails();
        Navigation.navigateToNewStage("second-stage.fxml");
    }
    private void saveCustomerDetails()
    {
        //this method use to save customer details in database
        reservation = new ReservationDetails(customerName.getText(),customerId.getText(),contactDetail.getText(),reservationDate.getText());
        reservation.addDataToCustomerDetailsTableInDatabase();
    }

}