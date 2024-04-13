package main;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.ViewTransitionModelInterface;
import models.pages.Experience;
import models.pages.Page;
import models.pages.Person;
import views.MainController;
import models.ViewTransitionModel;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Map<String, Page> fakeData = populateFakeData();
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../views/mainView.fxml"));
		
		BorderPane view = loader.load();
		ViewTransitionModelInterface model = new ViewTransitionModel();
		//MainController controller = loader.getController();
		model.setFakeData(fakeData);
		model.setMainView(view);
		model.showLogin();
		
		
		Scene scene = new Scene(view);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public Map<String, Page> populateFakeData() {
		Map<String, Page> fakeData = new HashMap<>();
		
		// Insert fake objects here...
		Person person = new Person("123");
		person.setName("John Doe");
		Experience exp = new Experience();
		person.setCurrentCompany(exp);
		person.setBio("I work hard in the day and in the night. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec egestas pretium ex, quis luctus ligula blandit quis. Suspendisse mattis quis justo non egestas.");
		fakeData.put("123",person);
		
		return fakeData;
	}
}
