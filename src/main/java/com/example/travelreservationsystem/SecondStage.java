package com.example.travelreservationsystem;

import javafx.fxml.FXML;
import prgram_files.*;

import java.io.IOException;

public class SecondStage {
    InternationalFlight internationalFlight;
    DomesticFlight domesticFlight;
    @FXML
    public void internationalFlight() throws IOException {
        //this method use to save the flight price and the flight type then navigate to the international flight
        internationalFlight = new InternationalFlight(12000,"international flight");
        Navigation.navigateToNewStage("third-stage2.fxml");
    }
    @FXML
    public void domesticFlight() throws IOException {
        //this method use to save the flight price and the flight type then navigate to the domestic flight
        domesticFlight= new DomesticFlight(1500,"domestic flight");
        Navigation.navigateToNewStage("third-stage.fxml");
    }
}
