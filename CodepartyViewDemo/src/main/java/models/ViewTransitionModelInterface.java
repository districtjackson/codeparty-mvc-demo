package models;

import java.util.ArrayList;

import javafx.scene.layout.BorderPane;
import models.pages.Page;

public interface ViewTransitionModelInterface {
	public void setMainView(BorderPane mainView);
	public void setCurrentUserID(String id);
	public void showLogin();
	public void showCurrentUserFromLogin();
	public void showCurrentUser();
	public void showUser(String id);
	public void showHome();
	public Page getObject(String id);
	public ArrayList<Page> getAllObjectsOfType(Class<?> type);
}
