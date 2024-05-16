package com.example.travelreservationsystem;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import prgram_files.DataBase;
import prgram_files.Navigation;
import prgram_files.ReservationDetails;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightTicket {
    @FXML
    public Label destinationCity , customerName, contactDetails, ticketSending,
            flightDate,flightNumber,flightTime,departureCity,thePrice,chairNumber;
    boolean isSending = false;
    @FXML
    public void bookHotel() throws IOException {
        //this method make sure that the ticket
        // has been sent to the customer and then navigate to the hotel booking stage
        if(isSending)
        {
            Navigation.navigateToNewStage("hotel-book.fxml");
        }
        else {
            ticketSending.setText("Please send the Ticket to the customer first");
        }
    }
    @FXML
    private void getTicketData1() throws SQLException {
        //this method get the data from customer details table in database that will
        // be in the Flight Ticket then show this data in the ticket
        ResultSet rs = DataBase.executeGetData(
                "select * from customerdetails where customerId = \""+ ReservationDetails.customerDetails.getCustomerId()+"\";"
        );
        if (rs.next()){
            customerName.setText(rs.getString("customerName"));
            contactDetails.setText(rs.getString("customerContact"));
            flightDate.setText(rs.getString("reservationDate"));
        }
        getTicketData2();
    }
    private void getTicketData2() throws SQLException {
        //this method get the data from reservationFlight table in database that
        // will be in the Flight Ticket then show this data in the ticket
        ResultSet rs = DataBase.executeGetData(
                "select * from reservationflight where customerId = \""+ ReservationDetails.customerDetails.getCustomerId()+"\";"
        );
        if (rs.next()){
            flightNumber.setText(rs.getString("flight_number"));
            flightTime.setText(rs.getString("moving_time"));
            departureCity.setText(rs.getString("deparure_city"));
            thePrice.setText(rs.getString("flight_price"));
            chairNumber.setText(rs.getString("chairNumber"));
            destinationCity.setText(rs.getString("destination_city"));
        }
    }
    @FXML
    private void sendTheTicket()
    {
        //this method send the ticket to the customer depended on her contact details table in database
        isSending = true;
        ticketSending.setText("The ticket has been sent successfully");
    }
    @FXML
    public void finishTheApplication()
    {
        // this method to finish the application
        Platform.exit();
    }
}
