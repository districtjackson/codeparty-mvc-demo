package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import main.Main;
import models.pages.Page;
import models.pages.Person;
import views.HomeController;
import views.LinkListCell;
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
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../views/homeView.fxml"));
		
		try {
			Pane view = loader.load();
			navView.setCenter(view);
			HomeController controller = loader.getController();
			controller.setModel(this);
			//controller.setModel(model);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public <T extends Page> ArrayList<T> getAllObjectsOfType(Class<T> type) {
		ArrayList<T> returnData = new ArrayList<T>();
		
		for(Map.Entry<String, Page> entry : fakeData.entrySet()) {
			@SuppressWarnings("unchecked")
			T page = (T) entry.getValue();
			
			if(page.getClass() == type) {
				returnData.add(page);
			}
		}
		
		return returnData;
	}

	private void showList(ListModel model) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../views/listView.fxml"));
	    try {
	    	ListView<LinkData> view = loader.load();
			navView.setCenter(view);
			ViewTransitionModel transitionModel = this;
	      
			view.setCellFactory(new Callback<ListView<LinkData>, ListCell<LinkData>>()
			  {

				@Override
				public ListCell<LinkData> call(ListView<LinkData> lv)
				{
					return new LinkListCell(transitionModel);
				}
			  });
			
			view.setItems(model.getItems());
			
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
		
	}

	@Override
	public void showCompany(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showSkill(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showJobPosting(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends Page> void showListOfAll(Class<T> type) {
		ArrayList<T> pages = this.getAllObjectsOfType(type);
    	
    	ListModel listModel = new ListModel();
    	for(T page : pages) {
    		listModel.addItem(new LinkData(page.getName(), page.getID(), Person.class));
    	}
    	
    	this.showList(listModel);
		
	}

	@Override
	public <T extends Page> void showListOfLinks(Page page, Class<T> type) {
		ArrayList<Page> links = page.getLinks().get(type);
		
		ListModel listModel = new ListModel();
    	for(Page receivedPage : links) {
    		@SuppressWarnings("unchecked")
			T castPage = (T) receivedPage;
    		
    		listModel.addItem(new LinkData(castPage.getName(), castPage.getID(), Person.class));
    	}
    	
    	this.showList(listModel);
		
	}
}
