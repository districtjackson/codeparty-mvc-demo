package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import main.Main;
import models.pages.Page;
import views.LoginController;
import views.NavController;
import views.UserViewController;

public class ViewTransitionModel implements ViewTransitionModelInterface {
	
	BorderPane mainView;
	BorderPane navView;
	SessionModel model = new SessionModel();
	
	String currentUserID;
	
	private Map<String, Page> fakeData = new HashMap<>();
	
	public void setFakeData(Map<String, Page> fakeData) {
		this.fakeData = fakeData;
	}
	
	public void setMainView(BorderPane mainView) {
		this.mainView = mainView;
	}
	
	public void setCurrentUserID(String ID) {
		this.currentUserID = ID;
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
		loader.setLocation(Main.class.getResource("../views/userView.fxml"));
		
		try {
			Pane view = loader.load();
			navView.setCenter(view);
			UserViewController controller = loader.getController();
			controller.setModel(this);
			controller.populateUser(id);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void showHome() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showCurrentUser() {
		this.showUser(currentUserID);
	}

	// If coming from the login screen, which does not have the nav buttons, we need to create
	// the nav view to place all subsequent views in
	@Override
	public void showCurrentUserFromLogin() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../views/navView.fxml"));
		
		try {
			navView = loader.load();
			mainView.setCenter(navView);
			NavController controller = loader.getController();
			controller.setModel(this);
			
			showCurrentUser();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Page getObject(String id) {
		return fakeData.get(id);
	}

	@Override
	public ArrayList<Page> getAllObjectsOfType(Class<?> type) {
		ArrayList<Page> returnData = new ArrayList<Page>();
		
		for(Map.Entry<String, Page> entry : fakeData.entrySet()) {
			Page page = entry.getValue();
			
			if(page.getClass() == type) {
				returnData.add(page);
			}
		}
		
		return returnData;
	}
}
