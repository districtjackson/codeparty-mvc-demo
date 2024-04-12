package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HomeController {

    @FXML
    void onCompaniesClick(ActionEvent event) {
    	System.out.println("Companies Clicked");
    }

    @FXML
    void onJobsClick(ActionEvent event) {
    	System.out.println("Jobs Clicked");
    }

    @FXML
    void onPeopleClick(ActionEvent event) {
    	System.out.println("People Clicked");
    }

    @FXML
    void onProjectsClick(ActionEvent event) {
    	System.out.println("Projects Clicked");
    }

    @FXML
    void onSkillsClick(ActionEvent event) {
    	System.out.println("Skills Clicked");
    }
}