package com.example.travelreservationsystem;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import prgram_files.DataBase;
import prgram_files.ReservationDetails;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelTicket {
    @FXML
    private Label totalPrice,customerName,customerId,hotelName,roomType,roomNumber,contactD;


    @FXML
    private void getTicketData1() throws SQLException {
        //this method get the data from customer details table in database that will
        // be in the Hotel Ticket then show this data in the ticket
        ResultSet rs = DataBase.executeGetData(
                "select * from customerdetails where customerId = \""+ ReservationDetails.customerDetails.getCustomerId()+"\";"
        );
        if (rs.next()){
            customerName.setText(rs.getString("customerName"));
            customerId.setText(ReservationDetails.customerDetails.getCustomerId());
            contactD.setText(rs.getString("customerContact"));
        }
        getTicketData2();
    }

    private void getTicketData2() throws SQLException {
        //this method get the data from hotel_reservation table in database that
        // will be in the Hotel Ticket then show this data in the ticket
        ResultSet rs = DataBase.executeGetData(
                "select * from hotel_reservation where customerId = \""+ ReservationDetails.customerDetails.getCustomerId()+"\";"
        );
        if (rs.next()){
            hotelName.setText(rs.getString("hotelName"));
            roomType.setText(rs.getString("roomType"));
            roomNumber.setText(rs.getString("roomNumber"));
            totalPrice.setText(rs.getString("totalCost"));
        }
    }

    @FXML
    private void finishTheApplication()
    {
        // this method to finish the application
        Platform.exit();
    }
}
