package models;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import main.Main;
import views.LoginController;

public class ViewTransitionModel implements ViewTransitionModelInterface {
	
	BorderPane mainView;
	SessionModel model = new SessionModel();
	
	public void setMainView(BorderPane mainView) {
		this.mainView = mainView;
	}
	
	public void showLogin() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../views/loginView.fxml"));
		
		try {
			Pane view = loader.load();
			mainView.setCenter(view);
			LoginController controller = loader.getController();
			LoginModel model = new LoginModel();
			controller.setModels(model, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void showUser(String id) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../views/userHome.fxml"));
		
		try {
			Pane view = loader.load();
			mainView.setCenter(view);
			LoginController controller = loader.getController();
			LoginModel model = new LoginModel();
			//controller.setModel(model);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void showHome() {
		// TODO Auto-generated method stub
		
	}
}
